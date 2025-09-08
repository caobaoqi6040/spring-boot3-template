package dev.caobaoqi6040.backend.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * EmailSendListener
 *
 * @author caobaoqi6040
 * @since 2025/9/8 15:46
 */
@Slf4j
@Component
public class EmailSendListener implements ApplicationListener<EmailSendEvent> {

	@Override
	public void onApplicationEvent(EmailSendEvent event) {
		log.info("email {} send with {}", event.getId(), event.getCreateTime());
	}

}
