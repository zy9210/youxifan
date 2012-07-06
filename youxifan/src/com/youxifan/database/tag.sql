DROP table `youxifan`.`tag`;


CREATE TABLE `youxifan`.`tag` (
  `tag_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_name` VARCHAR(45) NOT NULL,
  `tag_point` INTEGER NOT NULL DEFAULT 0 COMMENT 'tag的积分',
  PRIMARY KEY(`tag_id`)
)
ENGINE = InnoDB;

select 
   tag_id as tagid,
   tag_name as tagname,
   tag_point as tagpoint
from tag
order by tag.tag_point desc

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


