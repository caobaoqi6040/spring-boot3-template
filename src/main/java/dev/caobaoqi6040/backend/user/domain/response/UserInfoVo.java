package dev.caobaoqi6040.backend.user.domain.response;

import dev.caobaoqi6040.backend.user.domain.User;

/**
 * DTO for {@link User}
 */
public record UserInfoVo(String username, Integer age, String email, String avatar) {
}
