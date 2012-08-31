DROP table `youxifan`.`vote`;


CREATE TABLE `youxifan`.`vote` (
  `vote_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `voter_id` BIGINT UNSIGNED NOT NULL COMMENT '投票人id',
  `be_voted_id` BIGINT UNSIGNED NOT NULL COMMENT '被投票对象id',
  `vote_type` VARCHAR(2) COMMENT '1:对答案投票',
  PRIMARY KEY(`vote_id`)
)
ENGINE = InnoDB;

select 
  vote_id as voteid,
  voter_id as voterid,
  be_voted_id as bevotedid,
  vote_type as votetype
from vote

insert into vote (voter_id,be_voted_id,vote_type)
values (#{voterid},#{bevotedid},#{votetype})