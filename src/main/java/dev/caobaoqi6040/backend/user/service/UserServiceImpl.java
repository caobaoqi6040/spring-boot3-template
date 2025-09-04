package dev.caobaoqi6040.backend.user.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.caobaoqi6040.backend.user.exception.UserNotFoundException;
import dev.caobaoqi6040.backend.user.domain.User;
import dev.caobaoqi6040.backend.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author caobaoqi6040
 * @since 2025/9/3 17:19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Override
	public User getByEmail(String email) {
		return this.getOneOpt(Wrappers.lambdaQuery(User.class)
			.eq(User::getEmail, email)
		).orElseThrow(() -> new UserNotFoundException(String.format("user not found with[email] %s", email)));
	}

}
