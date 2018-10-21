/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.41 : Database - score_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`score_db` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `score_db`;

/*Table structure for table `judge` */

DROP TABLE IF EXISTS `judge`;

CREATE TABLE `judge` (
  `judge_id` int(11) NOT NULL AUTO_INCREMENT,
  `judge_name` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`judge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `judge` */

insert  into `judge`(`judge_id`,`judge_name`) values (1,'谢有俊'),(2,'虞姬');

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `judge_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `score_num` double(6,3) DEFAULT NULL,
  PRIMARY KEY (`judge_id`,`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `score` */

insert  into `score`(`judge_id`,`team_id`,`score_num`) values (1,1,6.250),(1,2,6.250),(1,3,6.250);

/*Table structure for table `team` */

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `team_title` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `team_leader` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `team` */

insert  into `team`(`team_id`,`team_name`,`team_title`,`team_leader`) values (1,'Four Leaf Clover','....','林冰纯'),(2,'正在加载中...','!!!','刘锋铭');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
