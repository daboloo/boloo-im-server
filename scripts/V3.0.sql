CREATE TABLE `fim_message` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `send_user_account` varchar(255) NOT NULL DEFAULT '' COMMENT '发送方账户',
  `accept_user_account` varchar(255) NOT NULL DEFAULT '' COMMENT '接收放账户',
  `accept_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '接收标志， 0 - 未接收; 1 - 已接收',
  `message` varchar(1000) NOT NULL DEFAULT '' COMMENT '消息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;