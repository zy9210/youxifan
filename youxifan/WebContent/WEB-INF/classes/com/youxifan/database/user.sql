DROP table `youxifan`.`user`;

CREATE TABLE `youxifan`.`user` (
  `user_id` BIGINT  UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` VARCHAR(60) COMMENT '用户名',
  `alias` VARCHAR(60) COMMENT '别名',
  `email` VARCHAR(60) NOT NULL,
  `password` VARCHAR(40) NOT NULL,
  `signing_message` VARCHAR(120) COMMENT '签名',
  `user_point` INTEGER UNSIGNED NOT NULL DEFAULT 0 COMMENT '积分',
  `image_url` VARCHAR(120) COMMENT '头像url',
  `user_level` INTEGER UNSIGNED  DEFAULT 0 COMMENT '用户等级',
  `bs_flag` VARCHAR(2) NOT NULL DEFAULT 1 COMMENT '0:无效 1:有效',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `modify_date` DATETIME NOT NULL COMMENT '修改时间',
  `game` VARCHAR(120)    COMMENT '常玩游戏',
  `gender` VARCHAR(1) DEFAULT 1 COMMENT '1:男 0:女',
  PRIMARY KEY(`user_id`)
)ENGINE = InnoDB DEFAULT CHARSET=UTF8;

insert into user (email,password,create_date,modify_date,signing_message) 
values("龙宽九段发","fff",now(),now(),"林肯郡");

select * from user;

delete from user where user_id = 16

select 
	user_id as userid,
	user_name as username,
	alias as alias,
	email as email,
	password as password,
	signing_message as signing,
	user_point as userpoint,
	image_url as imageurl,
	user_level as userlevel,
	bs_flag as bsflag,
	create_date as createdate,
	modify_date as modifydate
from user





select 
  d.doc_id as docid,
  d.upper_doc_id as upperdocid,
  d.title as title,
  d.content as content
  d.doc_type as doctype,
  d.doc_point as docpoint,
  d.bs_flag as bsflag,
  d.creater_id as createrid,
  d.create_date as createdate,
  d.modify_date as modifydate,
  u.user_name as username,
  u.alias as alias,
  u.email as email,
  u.user_point as userpoint,
  u.image_url as imageurl,
  u.create_date as createdate,
  u.modify_date as modifydate
from document d
inner join user u on(u.user_id = d.creater_id and u.bs_flag = '1')
where d.bs_flag = '1'