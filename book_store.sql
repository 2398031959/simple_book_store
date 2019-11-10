/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.7.20-log : Database - book_store
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book_store` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book_store`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bId` int(11) NOT NULL AUTO_INCREMENT,
  `bName` varchar(50) DEFAULT NULL,
  `bType` int(11) DEFAULT NULL,
  `bAmount` int(11) DEFAULT NULL,
  PRIMARY KEY (`bId`),
  KEY `bType` (`bType`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`bType`) REFERENCES `book_type` (`tId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`bId`,`bName`,`bType`,`bAmount`) values 
(2,'Java面向对象',1,50),
(3,'JavaWeb应用',1,30),
(4,'JavaEE企业级开发',1,25),
(5,'SpringBoot入门学习',1,10),
(6,'python入门基础',2,50),
(7,'Android进阶之光',4,23),
(8,'C++语言入门',3,35),
(10,'数据分析之python实战',2,44),
(15,'java',1,44);

/*Table structure for table `book_type` */

DROP TABLE IF EXISTS `book_type`;

CREATE TABLE `book_type` (
  `tId` int(11) NOT NULL AUTO_INCREMENT,
  `tName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `book_type` */

insert  into `book_type`(`tId`,`tName`) values 
(1,'Java类'),
(2,'Python类'),
(3,'C++类'),
(4,'Android类');

/*Table structure for table `dict_bus` */

DROP TABLE IF EXISTS `dict_bus`;

CREATE TABLE `dict_bus` (
  `dId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  PRIMARY KEY (`dId`),
  KEY `userId` (`userId`),
  KEY `bookId` (`bookId`),
  CONSTRAINT `dict_bus_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`uId`),
  CONSTRAINT `dict_bus_ibfk_2` FOREIGN KEY (`bookId`) REFERENCES `book` (`bId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `dict_bus` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `uName` varchar(50) DEFAULT NULL,
  `uPwd` varchar(50) DEFAULT NULL,
  `uIdentity` int(11) DEFAULT NULL,
  PRIMARY KEY (`uId`),
  KEY `uIdentity` (`uIdentity`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`uIdentity`) REFERENCES `user_identity` (`iId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uId`,`uName`,`uPwd`,`uIdentity`) values 
(1,'admin','admin',1),
(2,'lv','111111',2),
(3,'lg','lg',2),
(4,'zjq','zjq',2),
(5,'zyq','zyq',1),
(6,'hlm','hml',1);

/*Table structure for table `user_identity` */

DROP TABLE IF EXISTS `user_identity`;

CREATE TABLE `user_identity` (
  `iId` int(11) NOT NULL AUTO_INCREMENT,
  `iName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`iId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_identity` */

insert  into `user_identity`(`iId`,`iName`) values 
(1,'管理员'),
(2,'学生');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
