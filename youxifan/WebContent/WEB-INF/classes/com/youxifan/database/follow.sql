DROP table `youxifan`.`follow`;

CREATE TABLE `youxifan`.`follow` (
  `upper` BIGINT UNSIGNED NOT NULL COMMENT '被follow对象',
  `follower` BIGINT UNSIGNED NOT NULL,
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `modify_date` DATETIME NOT NULL COMMENT '更新时间',
  `follow_type` VARCHAR(2) NOT NULL COMMENT '1:人follow人，2:文档follow文档3:人follow文档=收藏4,人follow Tag 5,文档follow Tag',
  PRIMARY KEY(`upper`, `follower`, `follow_type`)
)
ENGINE = InnoDB;