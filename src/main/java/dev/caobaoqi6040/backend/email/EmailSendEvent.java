package dev.caobaoqi6040.backend.email;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

/**
 * EmailSendEvent
 *
 * @author caobaoqi6040
 * @since 2025/9/8 15:35
 */
@Getter
public class EmailSendEvent extends ApplicationEvent {

	private final Long id;
	private final LocalDateTime createTime = LocalDateTime.now();

	public EmailSendEvent(Object source, Long id) {
		super(source);
		this.id = id;
	}

}
