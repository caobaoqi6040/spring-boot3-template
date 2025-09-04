package dev.caobaoqi6040.backend.runner;

import dev.caobaoqi6040.backend.user.domain.User;
import dev.caobaoqi6040.backend.user.service.UserService;
import dev.caobaoqi6040.backend.utils.DataFakerUtils;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * UserDataInitializerRunner
 *
 * @author caobaoqi6040
 * @since 2025/9/4 10:50
 */
@Slf4j
@Component
@Profile("dev")
public class UserDataInitializerRunner implements CommandLineRunner {

	private final UserService userService;

	public UserDataInitializerRunner(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void run(String... args) throws Exception {
		if (userService.count() == 0) {
			Faker faker = DataFakerUtils.getChinaInstance();
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
