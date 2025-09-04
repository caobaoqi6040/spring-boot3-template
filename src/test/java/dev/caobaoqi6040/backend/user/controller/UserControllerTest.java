package dev.caobaoqi6040.backend.user.controller;

import dev.caobaoqi6040.backend.user.domain.User;
import dev.caobaoqi6040.backend.user.exception.UserNotFoundException;
import dev.caobaoqi6040.backend.user.service.UserService;
import dev.caobaoqi6040.backend.utils.DataFakerUtils;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Test class for the {@link UserController}
 */
@WebMvcTest({UserController.class})
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private UserService service;
	private User mockUser;

	@BeforeEach
	public void setup() {
		Faker faker = DataFakerUtils.getChinaInstanceWithSeed();
		String username = faker.name().fullName();
		mockUser = User.builder()
			.id(null)
			.username(username)
			.age(faker.random().nextInt(18, 110))
			.email(faker.siliconValley().email())
			.password(faker.internet().password())
			.avatar(faker.twitter().getLink(username, 5))
			.build();
	}

	@Test
	public void should_list_users() throws Exception {
		when(service.list()).thenReturn(List.of(mockUser));

		mockMvc.perform(get("/api/v1/users")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0]").isNotEmpty())
			.andDo(print());
	}

	@Test
	public void should_get_user_with_exist_email() throws Exception {
		String email = mockUser.getEmail();

		when(service.getByEmail(email)).thenReturn(mockUser);

		mockMvc.perform(get("/api/v1/users/{0}", email)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andDo(print());
	}

	@Test
	public void should_get_user_with_not_exist_email() throws Exception {
		String email = "not-exist-email@gmail.com";

		when(service.getByEmail(email)).thenThrow(UserNotFoundException.class);

		mockMvc.perform(get("/api/v1/users/{0}", email)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound())
			.andDo(print());
	}

}
