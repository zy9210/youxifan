DROP table `youxifan`.`invite`;


CREATE TABLE `youxifan`.`invite` (
  `invite_id` BIGINT UNSIGNED NOT NULL  AUTO_INCREMENT COMMENT '主键',
  `owner_id` BIGINT UNSIGNED NOT NULL DEFAULT 0,
  `invite_str` VARCHAR(60) NOT NULL, 
  `user_id` BIGINT UNSIGNED  DEFAULT 0 COMMENT '使用人id',
  `use_date` DATETIME   COMMENT '被使用时间', 
  PRIMARY KEY(`invite_id`)
)
ENGINE = InnoDB;


select 
   invite_id as inviteid,
   owner_id as ownerid
   invite_str as invitestr,
   user_id as userid,
   use_date as usedate 
from invite  
 
insert into invite (owner_id,invite_str) values (${ownerid},${invitestr});

update tag set tag.tag_point=tag_point+1 where tag.tag_id = ${tagid}


