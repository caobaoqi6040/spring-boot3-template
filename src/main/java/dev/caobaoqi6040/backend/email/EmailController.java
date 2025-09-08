package dev.caobaoqi6040.backend.email;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * EmailController
 *
 * @author caobaoqi6040
 * @since 2025/9/8 15:52
 */
@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

	private final EmailService emailService;

	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}

	@GetMapping
	public ResponseEntity<Void> send() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("title", "======= ikun ========");
		map.put("content", "你干嘛 哎呦");
		Email email = Email.builder()
			.id(1L)
			.content(map)
			.build();
		emailService.sendEmail(email);
		return ResponseEntity.ok(null);
	}

}
