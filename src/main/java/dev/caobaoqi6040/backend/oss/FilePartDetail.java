package dev.caobaoqi6040.backend.oss;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_file_part_detail")
public class FilePartDetail {

	@TableId(value = "id", type = IdType.ASSIGN_UUID)
	private String id;

	@TableField("platform")
	private String platform;

	@TableField("upload_id")
	private String uploadId;

	@TableField("e_tag")
	private String eTag;

	@TableField("part_number")
	private Integer partNumber;

	@TableField("part_size")
	private Long partSize;

	@TableField("hash_info")
	private String hashInfo;

	@TableField("create_time")
	private Date createTime;

	// ---------- Column constants ----------
	public static final String COL_ID = "id";
	public static final String COL_PLATFORM = "platform";
	public static final String COL_UPLOAD_ID = "upload_id";
	public static final String COL_E_TAG = "e_tag";
	public static final String COL_PART_NUMBER = "part_number";
	public static final String COL_PART_SIZE = "part_size";
	public static final String COL_HASH_INFO = "hash_info";
	public static final String COL_CREATE_TIME = "create_time";
}
