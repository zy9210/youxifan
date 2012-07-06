DROP table `youxifan`.`follow`;

CREATE TABLE `youxifan`.`follow` (
  `follow_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `upper` BIGINT UNSIGNED NOT NULL COMMENT '被follow对象',
  `lower` BIGINT UNSIGNED NOT NULL,
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `modify_date` DATETIME NOT NULL COMMENT '更新时间',
  `follow_type` VARCHAR(2) NOT NULL COMMENT '1:人follow人，2:文档follow文档3:人follow文档=收藏',
  PRIMARY KEY(`follow_id`)
)
ENGINE = InnoDB;