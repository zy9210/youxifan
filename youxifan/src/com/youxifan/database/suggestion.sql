DROP table `suggestion`;


CREATE TABLE `suggestion` (
  `suggestion_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `upper_sug_id` BIGINT UNSIGNED DEFAULT 0 COMMENT '被回答意见id',
  `user_id` BIGINT UNSIGNED DEFAULT 0 COMMENT '用户id',
  `contact` VARCHAR(200) COMMENT '联系方式',
  `content` VARCHAR(2000) COMMENT '意见内容',
  `bs_flag` VARCHAR(2) NOT NULL DEFAULT '1' COMMENT '0:无效 1:有效',
  `sug_type` VARCHAR(2) NOT NULL DEFAULT '1' COMMENT '意见类型：1意见，2管理员回答',
  PRIMARY KEY(`suggestion_id`)
)
ENGINE = InnoDB;

select 
  suggestion_id as sugid,
  upper_sug_id as uppersugid,
  user_id as userid,
  contact as contact,
  content as content,
  bs_flag as bsflag,
  sug_type as sugtype
from suggestion

insert into suggestion (upper_sug_id,user_id,contact,content)
values (#{uppersugid},#{userid},#{contact},#{content})



