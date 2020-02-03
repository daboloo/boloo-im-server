DROP DATABASE IF EXISTS fim_db;
CREATE DATABASE fim_db;

USE fim_db;

# 用户表
DROP TABLE IF EXISTS `fim_user`;
CREATE TABLE `fim_user` (
`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
`username` VARCHAR(255) NOT NULL COMMENT '用户名',
`password` VARCHAR(255) NOT NULL COMMENT '密码',
PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

# 角色表
DROP TABLE IF EXISTS `fim_role`;
CREATE TABLE `fim_role` (
`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL COMMENT '角色名',
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

# 用户角色关系表
DROP TABLE IF EXISTS `fim_user_role`;
CREATE TABLE `fim_user_role` (
`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
`user_id` BIGINT(11) NOT NULL COMMENT '用户id',
`role_id` BIGINT(11) NOT NULL COMMENT '角色id',
PRIMARY KEY (`id`),
UNIQUE KEY  `idx_user_role` (`user_id`, `role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='用户与角色关系表';

# 权限表
DROP TABLE IF EXISTS `fim_permission`;
CREATE TABLE `fim_permission` (
`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
`url` VARCHAR(255) NOT NULL COMMENT '权限允许访问路径',
`name` VARCHAR(255) NOT NULL COMMENT '权限名',
`description` VARCHAR(255) NULL COMMENT '描述',
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

# 角色与权限关系表
DROP TABLE IF EXISTS `fim_role_permission`;
CREATE TABLE `fim_role_permission` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) NOT NULL COMMENT '角色id',
  `permission_id` bigint(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色与权限关系表';



DROP TABLE IF EXISTS `fim_message`;
CREATE TABLE `fim_message` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `send_user_account` varchar(255) NOT NULL DEFAULT '' COMMENT '发送方账户',
  `accept_user_account` varchar(255) NOT NULL DEFAULT '' COMMENT '接收放账户',
  `accept_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '接收标志， 0 - 未接收; 1 - 已接收',
  `message` varchar(1000) NOT NULL DEFAULT '' COMMENT '消息',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `fim_friends`;
CREATE TABLE `fim_friends` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `friend_user_account` varchar(255) NOT NULL DEFAULT '' COMMENT '用户的好友账号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `my_user_id` (`user_account`,`friend_user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `fim_friends_request`;
CREATE TABLE `fim_friends_request` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `send_user_account` varchar(64) NOT NULL COMMENT '发送请求用户账户',
  `accept_user_account` varchar(64) NOT NULL COMMENT '接收请求用户账户',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='好友请求表';