package dev.caobaoqi6040.backend.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dev.caobaoqi6040.backend.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
