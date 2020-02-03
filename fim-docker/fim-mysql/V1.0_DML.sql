-- 用户创建
insert into `fim_user`(`id`, `username`, `password`) values(1, 'jiang0001', '$2a$10$/j5AQLTGI9MNsSJJncxie.fPEmJyrq75WMDmIkFnO/fSGEfkFstuq');
insert into `fim_user`(`id`, `username`, `password`) values(2, 'jiang0002', '$2a$10$/j5AQLTGI9MNsSJJncxie.fPEmJyrq75WMDmIkFnO/fSGEfkFstuq');
insert into `fim_user`(`id`, `username`, `password`) values(3, 'jiang0003', '$2a$10$/j5AQLTGI9MNsSJJncxie.fPEmJyrq75WMDmIkFnO/fSGEfkFstuq');
insert into `fim_user`(`id`, `username`, `password`) values(4, 'jiang0004', '$2a$10$/j5AQLTGI9MNsSJJncxie.fPEmJyrq75WMDmIkFnO/fSGEfkFstuq');
insert into `fim_user`(`id`, `username`, `password`) values(5, 'jiang0005', '$2a$10$/j5AQLTGI9MNsSJJncxie.fPEmJyrq75WMDmIkFnO/fSGEfkFstuq');
insert into `fim_user`(`id`, `username`, `password`) values(6, 'jiang0006', '$2a$10$/j5AQLTGI9MNsSJJncxie.fPEmJyrq75WMDmIkFnO/fSGEfkFstuq');
insert into `fim_user`(`id`, `username`, `password`) values(7, 'jiang0007', '$2a$10$/j5AQLTGI9MNsSJJncxie.fPEmJyrq75WMDmIkFnO/fSGEfkFstuq');
insert into `fim_user`(`id`, `username`, `password`) values(8, 'jiang0008', '$2a$10$/j5AQLTGI9MNsSJJncxie.fPEmJyrq75WMDmIkFnO/fSGEfkFstuq');
insert into `fim_user`(`id`, `username`, `password`) values(9, 'jiang0009', '$2a$10$/j5AQLTGI9MNsSJJncxie.fPEmJyrq75WMDmIkFnO/fSGEfkFstuq');
insert into `fim_user`(`id`, `username`, `password`) values(10, 'jiang0010', '$2a$10$/j5AQLTGI9MNsSJJncxie.fPEmJyrq75WMDmIkFnO/fSGEfkFstuq');

-- 角色创建
insert into `fim_role`(`id`, `name`) values(1, 'ADMIN');
insert into `fim_role`(`id`, `name`) values(2, 'USER');

-- 用户角色绑定
insert into `fim_user_role`(`id`, `user_id`, `role_id`) values(1, 1, 2);
insert into `fim_user_role`(`id`, `user_id`, `role_id`) values(2, 2, 2);
insert into `fim_user_role`(`id`, `user_id`, `role_id`) values(3, 3, 2);
insert into `fim_user_role`(`id`, `user_id`, `role_id`) values(4, 4, 2);
insert into `fim_user_role`(`id`, `user_id`, `role_id`) values(5, 5, 2);
insert into `fim_user_role`(`id`, `user_id`, `role_id`) values(6, 6, 2);
insert into `fim_user_role`(`id`, `user_id`, `role_id`) values(7, 7, 2);
insert into `fim_user_role`(`id`, `user_id`, `role_id`) values(8, 8, 2);
insert into `fim_user_role`(`id`, `user_id`, `role_id`) values(9, 9, 2);
insert into `fim_user_role`(`id`, `user_id`, `role_id`) values(10, 10, 2);

-- 好友关系绑定
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(1, 'jiang0001', 'jiang0002');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(2, 'jiang0001', 'jiang0003');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(3, 'jiang0001', 'jiang0004');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(4, 'jiang0001', 'jiang0005');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(5, 'jiang0001', 'jiang0006');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(6, 'jiang0001', 'jiang0007');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(7, 'jiang0001', 'jiang0008');

insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(8, 'jiang0002', 'jiang0001');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(9, 'jiang0003', 'jiang0001');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(10, 'jiang0004', 'jiang0001');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(11, 'jiang0005', 'jiang0001');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(12, 'jiang0006', 'jiang0001');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(13, 'jiang0007', 'jiang0001');
insert into `fim_friends`(`id`, `user_account`, `friend_user_account`) values(14, 'jiang0008', 'jiang0001');

-- 消息
insert into `fim_message`
(`send_user_account`, `accept_user_account`, `accept_flag`, `message`, `create_time`)
values
('jiang0001', 'jiang0002', 0, 'hello world1', '2020-01-30 18:01:32'),
('jiang0002', 'jiang0001', 0, 'hello world2', '2020-01-30 18:02:32'),
('jiang0003', 'jiang0001', 0, 'hello world3', '2020-01-30 18:03:32'),
('jiang0004', 'jiang0001', 0, 'hello world4', '2020-01-30 18:04:32'),
('jiang0005', 'jiang0001', 0, 'hello world5', '2020-01-30 18:05:32'),
('jiang0006', 'jiang0001', 0, 'hello world6', '2020-01-30 18:06:32'),
('jiang0007', 'jiang0001', 0, 'hello world7', '2020-01-30 18:07:32'),
('jiang0008', 'jiang0001', 0, 'hello world8', '2020-01-30 18:08:32'),
('jiang0002', 'jiang0001', 0, 'hello world9', '2020-01-30 18:09:32'),
('jiang0002', 'jiang0001', 0, 'hello world10', '2020-01-30 18:10:32'),
('jiang0002', 'jiang0001', 0, 'hello world11', '2020-01-30 18:11:32'),
('jiang0002', 'jiang0001', 0, 'hello world12', '2020-01-30 18:12:32'),
('jiang0002', 'jiang0001', 0, 'hello world13', '2020-01-30 18:13:32'),
('jiang0002', 'jiang0001', 0, 'hello world14', '2020-01-30 18:14:32'),
('jiang0002', 'jiang0001', 0, 'hello world15', '2020-01-30 18:15:32'),
('jiang0002', 'jiang0001', 0, 'hello world16', '2020-01-30 18:16:32'),
('jiang0002', 'jiang0001', 0, 'hello world17', '2020-01-30 18:17:32'),
('jiang0003', 'jiang0001', 0, 'hello world18', '2020-01-30 18:18:32'),
('jiang0003', 'jiang0001', 0, 'hello world19', '2020-01-30 18:19:32'),
('jiang0003', 'jiang0001', 0, 'hello world20', '2020-01-30 18:20:32');


