DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `city_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `p_id` int(11) NOT NULL COMMENT '省份id',
  `size` varchar(15) NOT NULL DEFAULT 'BIG' COMMENT '城市大小：SMALL,BIG,LARGE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='市级信息';

/*Data for the table `city` */

insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (1,'济南',1,'BIG');
insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (2,'青岛',1,'BIG');
insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (3,'烟台',1,'BIG');
insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (4,'威海',1,'BIG');
insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (5,'济宁',1,'BIG');
insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (6,'潍坊',1,'BIG');
insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (7,'淄博',1,'BIG');
insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (8,'聊城',1,'BIG');
insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (9,'临沂',1,'BIG');
insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (10,'菏泽',1,'BIG');
insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (11,'日照',1,'SMALL');
insert  into `city`(`id`,`city_name`,`p_id`,`size`) values (12,'泰安',1,'SMALL');

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
