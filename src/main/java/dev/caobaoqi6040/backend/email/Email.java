package dev.caobaoqi6040.backend.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Email
 *
 * @author caobaoqi6040
 * @since 2025/9/8 15:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Email {
	private Long id;
	private Map<String, Object> content;
}
