
DROP table `youxifan`.`document`;

CREATE TABLE `youxifan`.`document` (
  `doc_id` BIGINT  UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `upper_doc_id` BIGINT UNSIGNED COMMENT '被follow的doc_id',
  `title` VARCHAR(200) COMMENT '标题',
  `content` TEXT NOT NULL COMMENT '内容',
  `doc_type` VARCHAR(2) NOT NULL COMMENT '文档类型1:问题2:文章3:回答4:评论',
  `bs_flag` VARCHAR(2) NOT NULL DEFAULT 1 COMMENT '0:无效 1:有效',
  `doc_point` FLOAT(10,2)  DEFAULT 0 COMMENT '文档的积分可以为负',
  `views` BIGINT  DEFAULT 0 COMMENT '浏览量',
  `creater_id` BIGINT UNSIGNED NOT NULL COMMENT '创建者id',
  `creater_name` VARCHAR(60) COMMENT '创建用户名',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `modify_date` DATETIME NOT NULL COMMENT '修改时间',
  `answers` INTEGER UNSIGNED DEFAULT 0 COMMENT '回答数',
  `game` VARCHAR(120)    COMMENT '常玩游戏',
  PRIMARY KEY(`doc_id`)
)
ENGINE = InnoDB DEFAULT CHARSET=UTF8;

select 
  d.doc_id as docid,
  d.upper_doc_id as upperdocid,
  d.title as title,
  d.content as content,
  d.doc_type as doctype,
  d.doc_point as docpoint,
  d.bs_flag as bsflag,
  d.creater_id as createrid,
  d.create_date as createdate,
  d.modify_date as modifydate,
  d.creater_name as creatername,
  d.views as views
from document d;

insert into document 
(upper_doc_id,title,content,doc_type,doc_point,
bs_flag,creater_id,create_date,modify_date) 
values
(${upperdocid},${title},${content},${doctype},${docpoint},
${bsflag},${createrid},now(),now());

insert into document 
(content,doc_type,
bs_flag,creater_id,create_date,modify_date) 
values
("adf","1","1",21,now(),now());


select t.* from (
	select 
	  d.doc_id as docid,
	  d.upper_doc_id as upperdocid,
	  d.title as title,
	  d.content as content,
	  d.doc_type as doctype,
	  d.doc_point as docpoint,
	  d.bs_flag as bsflag,
	  d.creater_id as createrid,
	  d.create_date as doccreatedate,
	  d.modify_date as docmodifydate,
	  u.user_name as username,
	  u.alias as useralias,
	  u.email as email,
	  u.user_point as userpoint,
	  u.image_url as imageurl,
	  u.create_date as usercreatedate,
	  u.modify_date as usermodifydate
	from document d
	left join user u on(u.user_id = d.creater_id)
	where d.bs_flag = '1'
) t limit 0, 10

