package dev.caobaoqi6040.backend.user.controller;

import dev.caobaoqi6040.backend.user.exception.UserNotFoundException;
import dev.caobaoqi6040.backend.user.domain.UserStruct;
import dev.caobaoqi6040.backend.user.domain.response.UserInfoVo;
import dev.caobaoqi6040.backend.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController
 *
 * @author caobaoqi6040
 * @since 2025/9/3 17:20
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserService service;
	private final UserStruct struct;

	public UserController(UserService service, UserStruct struct) {
		this.service = service;
		this.struct = struct;
	}

	@GetMapping
	public ResponseEntity<List<UserInfoVo>> list() {
		return ResponseEntity.ok(service.list().stream()
			.map(struct::toUserInfoVo)
			.toList());
	}

	@GetMapping("/{email}")
	public ResponseEntity<UserInfoVo> getByEmail(@PathVariable("email") String email) {
		return ResponseEntity.ok(struct.toUserInfoVo(service.getByEmail(email)));
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
		//TODO("Implement specific handler logic")
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}
