# Host: 127.0.0.1  (Version 5.7.13-log)
# Date: 2017-06-06 16:49:53
# Generator: MySQL-Front 5.4  (Build 4.34)
# Internet: http://www.mysqlfront.de/

/*!40101 SET NAMES utf8 */;

#
# Structure for table "address_1"
#

DROP TABLE IF EXISTS `address_1`;
CREATE TABLE `address_1` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Company` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  `PostalCode` char(6) DEFAULT NULL,
  `AdditionalInformation` varchar(255) DEFAULT NULL,
  `MobilePhone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "address_1"
#


#
# Structure for table "address_2"
#

DROP TABLE IF EXISTS `address_2`;
CREATE TABLE `address_2` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Company` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  `PostalCode` char(6) DEFAULT NULL,
  `AdditionalInformation` varchar(255) DEFAULT NULL,
  `MobilePhone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "address_2"
#

INSERT INTO `address_2` VALUES (1,'cjr','cjr','ecnu','410','sh','sh','200062','hiahiahia','13000000000');

#
# Structure for table "cart_1"
#

DROP TABLE IF EXISTS `cart_1`;
CREATE TABLE `cart_1` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Color` varchar(255) DEFAULT NULL,
  `Size` char(3) DEFAULT NULL,
  `Number` int(11) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `Url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "cart_1"
#

INSERT INTO `cart_1` VALUES (1,'Men autumn coat','Yellow','M',3,289,'images/product/1-4.png',NULL),(3,'Women wool coat','Yellow','XL',1,329,'images/product/4-4.png',NULL),(4,'Kids coat','Yellow','L',3,189,'images/product/9-4.png',NULL);

#
# Structure for table "cart_2"
#

DROP TABLE IF EXISTS `cart_2`;
CREATE TABLE `cart_2` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Color` varchar(255) DEFAULT NULL,
  `Size` char(3) DEFAULT NULL,
  `Number` int(11) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `Url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "cart_2"
#


#
# Structure for table "goods"
#

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Introduction` varchar(255) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Number` int(11) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "goods"
#

INSERT INTO `goods` VALUES (1,'Men autumn coat','Coat with light weight and high quality.',289,100,'images/product/1-4.png','product-details.jsp','coat'),(2,'Men sweater','Sweater with simple but special design',189,100,'images/product/2-4.png','product-details.jsp','sweater'),(3,'Men downcoat','Thick downcoat for winter',299,100,'images/product/3-4.png','product-details.jsp','coat'),(4,'Women wool coat','Cute wool coat with warm touch',329,100,'images/product/4-4.png','product-details.jsp','coat'),(5,'Women pilot coat','Pilot coat for early winter',199,100,'images/product/5-4.png','product-details.jsp','coat'),(6,'Women short coat','Short coat with modern design',249,100,'images/product/6-4.png','product-details.jsp','coat'),(7,'Kids T-shirt','Thick T-shirt with simple design',159,100,'images/product/7-4.png','product-details.jsp','shirt'),(8,'Kids hoody','Kids long hoody with various use',179,100,'images/product/8-4.png','images/product/7-4.png','shirt'),(9,'Kids coat','Jeans coat for early autumn to mid autumn',189,100,'images/product/9-4.png','images/product/7-4.png','coat');

#
# Structure for table "orderlist_1"
#

DROP TABLE IF EXISTS `orderlist_1`;
CREATE TABLE `orderlist_1` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `OrderId` varchar(255) DEFAULT NULL,
  `OrderDate` date DEFAULT NULL,
  `ItemNumber` int(11) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `AddressTitle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "orderlist_1"
#

INSERT INTO `orderlist_1` VALUES (1,'#3224','2017-01-01',6,399,'CYH');

#
# Structure for table "orderlist_2"
#

DROP TABLE IF EXISTS `orderlist_2`;
CREATE TABLE `orderlist_2` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `OrderId` varchar(255) DEFAULT NULL,
  `OrderDate` date DEFAULT NULL,
  `ItemNumber` int(11) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `AddressTitle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "orderlist_2"
#

INSERT INTO `orderlist_2` VALUES (1,'#1234','2016-06-06',1,299,'cjr');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `SignNewsLetter` bit(1) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'nzj','502527103@qq.com',NULL,'123456789',NULL),(2,'cjr','nonono@nonono.com','2005-01-01','1234567',b'1');

#
# Structure for table "wishlist_1"
#

DROP TABLE IF EXISTS `wishlist_1`;
CREATE TABLE `wishlist_1` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Color` varchar(255) DEFAULT NULL,
  `Size` char(3) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `Url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "wishlist_1"
#

INSERT INTO `wishlist_1` VALUES (6,'Men sweater','Yellow','XXL',189,'images/product/2-4.png',NULL),(7,'Kids hoody','Yellow','XL',179,'images/product/8-4.png',NULL),(8,'Men autumn coat','Yellow','S',289,'images/product/1-4.png',NULL);

#
# Structure for table "wishlist_2"
#

DROP TABLE IF EXISTS `wishlist_2`;
CREATE TABLE `wishlist_2` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Color` varchar(255) DEFAULT NULL,
  `Size` char(3) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `Url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "wishlist_2"
#

