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