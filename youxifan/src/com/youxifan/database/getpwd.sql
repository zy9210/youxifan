DROP table `youxifan`.`getpwd`;


CREATE TABLE `youxifan`.`getpwd` (
  `email` VARCHAR(45) NOT NULL,
  `getpwdstr` VARCHAR(40) NOT NULL, 
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `modify_date` DATETIME NOT NULL COMMENT '修改时间',
  `bs_flag` VARCHAR(2) NOT NULL DEFAULT 1 COMMENT '0:无效 1:有效',
  PRIMARY KEY(`getpwdstr`)
)
ENGINE = InnoDB;

	select 
	  email as email,
	  getpwdstr as getpwdstr,
	  create_date as createdate
	  
	from getpwd

insert into getpwd (email,getpwdstr,create_date,modify_date,bs_flag)
values ('ddd','ddddddddddd',now(),now(),'1')