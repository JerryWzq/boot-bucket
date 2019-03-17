DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `city_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `p_id` int(11) NOT NULL COMMENT '省份id',
  PRIMARY KEY (`id`),
  KEY `fk_province` (`p_id`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `province` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='市级信息';

/*Data for the table `city` */

insert  into `city`(`id`,`city_name`,`p_id`) values (1,'济南',1);
insert  into `city`(`id`,`city_name`,`p_id`) values (2,'青岛',1);
insert  into `city`(`id`,`city_name`,`p_id`) values (3,'烟台',1);
insert  into `city`(`id`,`city_name`,`p_id`) values (4,'威海',1);
insert  into `city`(`id`,`city_name`,`p_id`) values (5,'济宁',1);
insert  into `city`(`id`,`city_name`,`p_id`) values (6,'潍坊',1);
insert  into `city`(`id`,`city_name`,`p_id`) values (7,'淄博',1);
insert  into `city`(`id`,`city_name`,`p_id`) values (8,'聊城',1);
insert  into `city`(`id`,`city_name`,`p_id`) values (9,'临沂',1);
insert  into `city`(`id`,`city_name`,`p_id`) values (10,'菏泽',1);

/*Table structure for table `province` */
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `province_code` varchar(255) DEFAULT NULL COMMENT '代码',
  `province_name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='省级信息';

/*Data for the table `province` */

insert  into `province`(`id`,`province_code`,`province_name`) values (1,'SD','山东');
insert  into `province`(`id`,`province_code`,`province_name`) values (2,'SX','山西');
insert  into `province`(`id`,`province_code`,`province_name`) values (3,'HN','河南');
insert  into `province`(`id`,`province_code`,`province_name`) values (4,'HB','河北');
insert  into `province`(`id`,`province_code`,`province_name`) values (5,'GD','广东');
insert  into `province`(`id`,`province_code`,`province_name`) values (6,'GX','广西');
insert  into `province`(`id`,`province_code`,`province_name`) values (7,'JS','江苏');
insert  into `province`(`id`,`province_code`,`province_name`) values (8,'JX','江西');
insert  into `province`(`id`,`province_code`,`province_name`) values (9,'SC','四川');
insert  into `province`(`id`,`province_code`,`province_name`) values (10,'FJ','福建');
insert  into `province`(`id`,`province_code`,`province_name`) values (11,'GS','甘肃');
insert  into `province`(`id`,`province_code`,`province_name`) values (12,'JL','吉林');
insert  into `province`(`id`,`province_code`,`province_name`) values (13,'LN','辽宁');
insert  into `province`(`id`,`province_code`,`province_name`) values (14,'NX','宁夏');
insert  into `province`(`id`,`province_code`,`province_name`) values (15,'QH','青海');
