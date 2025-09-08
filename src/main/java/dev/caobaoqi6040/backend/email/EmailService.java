package dev.caobaoqi6040.backend.email;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * EmailService
 *
 * @author caobaoqi6040
 * @since 2025/9/8 15:37
 */
@Service
public class EmailService {

	private final ApplicationEventPublisher eventPublisher;

	public EmailService(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	public void sendEmail(Email email) {
		eventPublisher.publishEvent(new EmailSendEvent(this, email.getId()));
	}

}
