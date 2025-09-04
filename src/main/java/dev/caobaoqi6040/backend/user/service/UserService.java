package dev.caobaoqi6040.backend.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import dev.caobaoqi6040.backend.user.domain.User;

public interface UserService extends IService<User> {
	User getByEmail(String email);
}
