DROP table `youxifan`.`vote`;


CREATE TABLE `youxifan`.`vote` (
  `vote_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `voter_id` BIGINT UNSIGNED NOT NULL,
  `be_voted_id` BIGINT UNSIGNED NOT NULL,
  `vote_type` VARCHAR(2) NOT NULL COMMENT '1:对问题投票2:对答案投票3:文章投票',
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