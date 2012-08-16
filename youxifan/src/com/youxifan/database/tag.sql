DROP table `youxifan`.`tag`;


CREATE TABLE `youxifan`.`tag` (
  `tag_id` BIGINT UNSIGNED NOT NULL  AUTO_INCREMENT COMMENT '主键',
  `father_id` BIGINT UNSIGNED NOT NULL DEFAULT 0,
  `tag_name` VARCHAR(60) NOT NULL,
  `tag_follower` BIGINT UNSIGNED DEFAULT 0 COMMENT 'follower数',
  `tag_point` FLOAT(10,2) DEFAULT 0 COMMENT '评分',
  `tag_type` VARCHAR(2) COMMENT '备用',
  `bs_flag` VARCHAR(2) NOT NULL DEFAULT 1 COMMENT '1:有效0:无效',
  `creator` BIGINT UNSIGNED  DEFAULT 0 COMMENT '创建标签的人',,
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `modify_date` DATETIME NOT NULL  COMMENT '更新时间',
  `alias` VARCHAR(120)  COMMENT 'tag别名' ,
  PRIMARY KEY(`tag_id`)
)
ENGINE = InnoDB;


select 
   tag_id as tagid,
   father_id as fatherid
   tag_name as tagname,
   tag_point as tagpoint,
   tag_type as tagtype,
   tag_follower as followers,
   bs_blag as bsflag
from tag
order by tag.tag_follower desc

select 
   tag_id as tagid,
   tag_name as tagname,
   tag_point as tagpoint
from tag
where tag.tag_name like '%'+${likename}+'%'
order by tag.tag_point desc

select 
   tag_id as tagid,
   tag_name as tagname,
   tag_point as tagpoint
from tag
where tag.tag_name = ${tagname}
order by tag.tag_point desc

insert into (tag_name) values (${tagname});

update tag set tag.tag_point=tag_point+1 where tag.tag_id = ${tagid}


