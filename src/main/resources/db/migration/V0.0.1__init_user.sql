CREATE TABLE tb_user
(
  id          BIGINT                  NOT NULL COMMENT 'id',
  username    VARCHAR(255)            NOT NULL COMMENT '用户名',
  age         TINYINT                 NULL COMMENT '年龄',
  email       VARCHAR(64)             NULL COMMENT '邮箱',
  password    VARCHAR(64)             NOT NULL COMMENT '密码',
  avatar      VARCHAR(255)            NULL COMMENT '头像地址',
  create_time timestamp DEFAULT NOW() NOT NULL COMMENT '创建时间',
  update_time timestamp DEFAULT NOW() NOT NULL COMMENT '更新时间',
  deleted     TINYINT   DEFAULT 0     NOT NULL COMMENT '软删除 [1 已删除 | 0 未删除]',
  CONSTRAINT `PRIMARY` PRIMARY KEY (id)
) COMMENT ='用户表';

ALTER TABLE tb_user
  ADD CONSTRAINT tb_user_id_email_uindex UNIQUE (id, email);
