DROP table `youxifan`.`tag_follow`;


CREATE TABLE `youxifan`.`tag_follow` (
  `follow_tag_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_id` BIGINT UNSIGNED NOT NULL,
  `follower_id` BIGINT UNSIGNED NOT NULL,
  `follow_type` VARCHAR(2) NOT NULL COMMENT '1:文档follow2:人员follow',
  PRIMARY KEY(`follow_tag_id`)
)
ENGINE = InnoDB;


