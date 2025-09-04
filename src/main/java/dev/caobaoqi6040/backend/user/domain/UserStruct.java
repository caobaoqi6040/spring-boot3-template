package dev.caobaoqi6040.backend.user.domain;

import dev.caobaoqi6040.backend.user.domain.response.UserInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserStruct {
	User toEntity(UserInfoVo userInfoVo);

	UserInfoVo toUserInfoVo(User user);
}
