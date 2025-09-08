package dev.caobaoqi6040.backend.oss;

import cn.hutool.core.util.ObjectUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.upload.MultipartUploadSupportInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

	private final FileStorageService fileStorageService;

	public FileController(FileStorageService fileStorageService) {
		this.fileStorageService = fileStorageService;
	}

	@PostConstruct
	private void FileControllerPost() {
		MultipartUploadSupportInfo supportInfo = fileStorageService.isSupportMultipartUpload();
		log.info("是否支持手动分片上传 {}", supportInfo.getIsSupport());
		log.info("是否支持列举已上传的分片 {}", supportInfo.getIsSupportListParts());
		log.info("是否支持取消上传 {}", supportInfo.getIsSupportAbort());
	}

	/**
	 * 上传文件
	 */
	@PostMapping("/upload")
	public ResponseEntity<String> upload(MultipartFile file) {
		FileInfo fileInfo = fileStorageService.of(file)
			.setPlatform("minio-1")
			.putAttr("role", "admin") //保存一些属性，可以在切面、保存上传记录、自定义存储平台等地方获取使用，不需要可以不写
			.upload();
		if (ObjectUtil.isNull(fileInfo)) {
			return ResponseEntity.badRequest().body("上传失败");
		}
		return ResponseEntity.ok(fileInfo.getUrl());
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Void> delete(@RequestParam("url") String url) {
		boolean deleted = fileStorageService.delete(url);
		return deleted ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).build();
	}

}
