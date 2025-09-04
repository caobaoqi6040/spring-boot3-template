package dev.caobaoqi6040.backend;

import dev.caobaoqi6040.backend.user.domain.User;
import dev.caobaoqi6040.backend.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Locale;

@Slf4j
@SpringBootApplication
public class SpringBoot3TemplateApplication implements CommandLineRunner {

	private final UserService userService;

	public SpringBoot3TemplateApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3TemplateApplication.class, args);
	}

	@EventListener
	public void handleApplicationReadyEvent(ApplicationReadyEvent event) {
		log.info("<handleApplicationReadyEvent> event = {}", event);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userService.count() == 0) {
			Faker faker = new Faker(new Locale("zh", "cn"));
			String username = faker.name().fullName();
			User user = User.builder()
				.id(null)
				.username(username)
				.age(faker.random().nextInt(18, 110))
				.email(faker.siliconValley().email())
				.password(faker.internet().password())
				.avatar(faker.twitter().getLink(username, 5))
				.build();
			boolean saved = userService.save(user);
			if (!saved) throw new Exception("insert user failure");
		} else {
			log.warn("数据库[tb_user]已存在数据 跳过生成");
		}
	}
}
