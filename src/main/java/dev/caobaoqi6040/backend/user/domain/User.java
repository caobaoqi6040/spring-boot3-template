package dev.caobaoqi6040.backend.user.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * User
 *
 * @author caobaoqi6040
 * @since 2025/9/3 17:01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`sys_user`")
public class User implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 主键 ID
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 姓名
	 */
	@TableField(value = "`username`")
	private String username;

	/**
	 * 年龄
	 */
	@TableField(value = "age")
	private Integer age;

	/**
	 * 邮箱
	 */
	@TableField(value = "email")
	private String email;

	/**
	 * 密码
	 */
	@TableField(value = "`password`")
	private String password;

	/**
	 * 头像
	 */
	@TableField(value = "avatar")
	private String avatar;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	/**
	 * 软删除字段 [ 1 已删除 | 0 未删除 ]
	 */
	@TableLogic
	@TableField(value = "deleted")
	private Integer deleted;
}
