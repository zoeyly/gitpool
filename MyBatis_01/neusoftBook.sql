
CREATE DATABASE `book` ;

USE `book`;

DROP TABLE IF EXISTS `neusoft_user`;

CREATE TABLE `neusoft_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

insert  into `neusoft_user`(`id`,`userName`,`password`) values (1,'Hello everyone',NULL);


