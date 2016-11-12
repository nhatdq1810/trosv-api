-- MySQL dump 10.13  Distrib 5.7.13, for Win64 (x86_64)
--
-- Host: localhost    Database: trosv
-- ------------------------------------------------------
-- Server version	5.7.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `noidung` longtext NOT NULL,
  `ngay` datetime NOT NULL,
  `userID` int(11) NOT NULL,
  `phongtroID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_user1_idx` (`userID`),
  KEY `fk_comment_phongtro1_idx` (`phongtroID`),
  CONSTRAINT `fk_comment_phongtro1` FOREIGN KEY (`phongtroID`) REFERENCES `phongtro` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_user1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (2,'ment1comment1','2016-10-03 00:00:00',1,2),(3,'comment3','2016-10-01 00:00:00',4,2),(4,'comment4','2016-10-02 00:00:00',2,3),(5,'comment5','2016-10-10 00:00:00',1,3),(13,'comment8','2016-09-09 00:00:00',5,3),(14,'comment9','2016-09-10 20:00:00',2,3),(17,'comment12','2016-10-09 00:00:00',5,10),(19,'nhat comment','2016-11-03 23:13:44',1,20),(20,'nhat comment 2','2016-11-03 23:15:20',1,20),(21,'nhat4 commented','2016-11-03 23:22:06',4,20),(22,'nhat4 commented22222','2016-11-03 23:22:12',4,20),(26,'phong tro nay an ninh tot','2016-11-04 00:00:34',4,21),(27,'phong tro gia re, tam dc :D','2016-11-04 00:00:56',4,21),(28,'phòng trọ rộng, nhưng hơi khó tìm','2016-11-06 10:41:58',1,2),(29,'phong tro sach se','2016-11-06 21:43:14',10,15),(30,'phong tro hoi nho','2016-11-06 21:43:49',10,21),(31,'giá quá rẻ :)','2016-11-06 21:44:17',10,22),(32,'giá hơi chua, có thể fix một ít được không','2016-11-06 21:44:57',10,17),(34,'Phòng trọ tốt lắm , các bạn mau nhanh chân không hết chỗ :)','2016-11-10 21:30:56',1,6),(35,'test comment mới','2016-11-10 21:00:00',3,6),(36,'test function thichComment moi','2016-11-10 21:46:46',1,6),(37,'test\ntest\ntest\ntest','2016-11-10 21:49:06',1,6),(40,'good (y)','2016-11-10 22:09:48',2,4),(41,'not good\n','2016-11-10 22:13:52',1,4),(42,'sao lại k good bạn','2016-11-10 22:19:42',2,4),(43,'xa trường quá','2016-11-10 22:31:12',2,25),(44,'test comment\n','2016-11-11 20:32:20',1,3),(45,'phòng trọ mới xây , sạch sẽ lắm các bạn\n<3 <3 <3','2016-11-11 20:47:55',11,26);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giaodich`
--

DROP TABLE IF EXISTS `giaodich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `giaodich` (
  `nganhangID_gui` varchar(45) NOT NULL,
  `nganhangID_nhan` varchar(45) NOT NULL,
  `phongtroID` int(11) NOT NULL,
  `ngay` datetime NOT NULL,
  `tien` int(11) unsigned NOT NULL,
  PRIMARY KEY (`nganhangID_gui`,`nganhangID_nhan`,`ngay`),
  KEY `nganhang_has_nganhang_2_idx` (`nganhangID_nhan`),
  KEY `nganhang_has_nganhang_1_idx` (`nganhangID_gui`),
  KEY `giaodich_has_phongtro_idx` (`phongtroID`),
  CONSTRAINT `giaodich_has_phongtro` FOREIGN KEY (`phongtroID`) REFERENCES `phongtro` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `nganhang_has_nganhang_1` FOREIGN KEY (`nganhangID_gui`) REFERENCES `nganhang` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `nganhang_has_nganhang_2` FOREIGN KEY (`nganhangID_nhan`) REFERENCES `nganhang` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giaodich`
--

LOCK TABLES `giaodich` WRITE;
/*!40000 ALTER TABLE `giaodich` DISABLE KEYS */;
INSERT INTO `giaodich` VALUES ('123786540','98456372',2,'2016-10-03 00:00:00',5000000),('123786540','98456372',10,'2016-10-22 23:30:39',3000000),('255569139','456973822',26,'2016-10-11 18:00:00',1000000),('255569139','98456372',10,'2016-11-06 10:38:51',1500000),('255569139','98456372',13,'2016-11-06 10:41:00',1500000),('255569139','98456372',21,'2016-11-10 22:32:21',3000000),('456973822','255569139',6,'2016-10-09 18:00:00',550000),('456973822','499800056',14,'2016-10-03 15:00:00',400000),('499800056','255569139',6,'2016-10-22 23:37:36',1500000),('98456372','123786540',4,'2016-09-30 00:00:00',2000000),('98456372','123786540',4,'2016-10-01 00:00:00',2500000),('98456372','123786540',4,'2016-10-10 00:00:00',2000000),('98456372','123786540',4,'2016-10-10 05:00:00',1000000),('98456372','255569139',6,'2016-10-22 23:42:04',1500000),('98456372','255569139',6,'2016-10-23 18:08:40',1500000),('98456372','255569139',6,'2016-11-06 10:25:13',3000000),('98456372','255569139',6,'2016-11-06 10:34:41',3000000),('98456372','456973822',3,'2016-11-06 21:38:22',3000000);
/*!40000 ALTER TABLE `giaodich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nganhang`
--

DROP TABLE IF EXISTS `nganhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nganhang` (
  `id` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `hoten` varchar(45) NOT NULL,
  `diachi` mediumtext NOT NULL,
  `sodt` varchar(45) NOT NULL,
  `cmnd` varchar(45) NOT NULL,
  `tien` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nganhang`
--

LOCK TABLES `nganhang` WRITE;
/*!40000 ALTER TABLE `nganhang` DISABLE KEYS */;
INSERT INTO `nganhang` VALUES ('123786540','nhat2','123456','nhat2','1234 abc','0123456789','987654321',1000000),('255569139','nhat5','123456','nhat5','1234 aabc','0123456089','987054321',2000000),('456973822','nhat3','123456','nhat1','123 abc','0123456789','123456789',1000000),('499800056','nhat4','123456','nhat4','1234 aqbc','0133456789','982654321',0),('98456372','nhat','123456','nhat1','123 abc','0123456789','123456789',6500000);
/*!40000 ALTER TABLE `nganhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phongtro`
--

DROP TABLE IF EXISTS `phongtro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phongtro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diachi` mediumtext NOT NULL,
  `giatien` int(11) unsigned NOT NULL DEFAULT '0',
  `ngaydang` datetime NOT NULL,
  `songuoi` int(11) unsigned NOT NULL DEFAULT '1',
  `gioitinh` varchar(5) NOT NULL DEFAULT 'nam',
  `hinhanh` mediumtext,
  `dientich` decimal(10,1) NOT NULL,
  `tiencoc` int(11) unsigned DEFAULT '0',
  `truong` varchar(45) DEFAULT NULL,
  `nganh` varchar(45) DEFAULT NULL,
  `khoa` varchar(45) DEFAULT NULL,
  `wifi` int(11) DEFAULT '0',
  `chu` int(11) DEFAULT '0',
  `ghichu` mediumtext,
  `userID` int(11) NOT NULL,
  `nganhangID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_phongtro_user1_idx` (`userID`),
  KEY `fk_phongtro_nganhang1_idx` (`nganhangID`),
  CONSTRAINT `fk_phongtro_nganhang1` FOREIGN KEY (`nganhangID`) REFERENCES `nganhang` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_phongtro_user1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phongtro`
--

LOCK TABLES `phongtro` WRITE;
/*!40000 ALTER TABLE `phongtro` DISABLE KEYS */;
INSERT INTO `phongtro` VALUES (2,'345 lê văn thọ, phường 15, quận gò vấp, thành phố ho chi minh',2500000,'2016-09-30 00:00:00',0,'nam','http://i.imgur.com/4dBWUZC.jpg-JqHyHieyuQA2TrO',20.0,1500000,'học viện cn bưu chính viễn thông','công nghệ thông tin','2012',1,1,'có nhà vệ sinh riêng, tiền rác đã tính trong tiền nhà',5,'98456372'),(3,'12/3 man thiện, phường hiệp phú, quận 9, thành phố ho chi minh',2000000,'2016-11-12 09:43:27',2,'nữ','http://i.imgur.com/hl6kXkT.jpg-GTkQU4WidUMB1HG',20.0,2000000,'ueh',NULL,NULL,1,1,NULL,6,'456973822'),(4,'333 man thiện, phường tăng nhơn phú a, quận 9, thành phố ho chi minh',2500000,'2016-11-10 22:43:40',2,'nam','http://i.imgur.com/P69IyzZ.jpg-EluLqiJbUBqU3CZ',20.0,2500000,'đại học sư phạm kỹ thuật',NULL,NULL,1,0,NULL,2,'123786540'),(6,'123 cây trâm, phường 15, quận gò vấp, thành phố ho chi minh',2000000,'2016-11-12 23:03:47',2,'nam','http://i.imgur.com/drjfYcs.jpg-zY38A8jZlhy8DgB',20.0,2500000,'huflit',NULL,'2013',1,1,NULL,1,'255569139'),(10,'435-461 phan văn trị, phường 5, quận gò vấp, thành phố hồ chí minh',3000000,'2016-11-12 22:36:50',1,'nữ','http://i.imgur.com/IE2gt6X.jpg-XRD4NoLQJUt9DOX',25.0,3000000,NULL,'kế toán',NULL,1,0,NULL,3,'98456372'),(13,'123/22b lê văn thọ, phường 16, quận gò vấp, thành phố ho chi minh',1300000,'2016-10-26 22:50:01',2,'nữ','http://i.imgur.com/CLrmkGq.jpg-SGE0QLqKRx0o7Ac',12.0,3000000,NULL,NULL,NULL,1,0,NULL,1,'98456372'),(14,'321/22 lê văn thọ, phường 13, quận gò vấp, thành phố ho chi minh',2000000,'2016-11-11 20:29:25',1,'nữ','http://i.imgur.com/I4ZpIkW.jpg-IyXYTMq6M2Xfy6C',12.0,2000000,'sư phạm kỹ thuật',NULL,NULL,1,0,NULL,1,'499800056'),(15,'123/223b nguyễn oanh, phường 6, quận gò vấp, thành phố ho chi minh',2500000,'2016-11-05 20:55:31',1,'nam','http://i.imgur.com/diQHd9p.jpg-GcMLQ6G7bll6x3J',14.0,0,NULL,NULL,NULL,1,0,'Giá chưa bao gồm tiền điện, nước và rác',10,NULL),(17,'321/22 lê văn thọ, phường 16, quận gò vấp, thành phố hồ chí minh',2000000,'2016-11-06 21:59:56',1,'nam','http://i.imgur.com/oaiIhhC.jpg-r4SuXSsAVGE93k7',20.0,0,'bách khoa','điện tử',NULL,1,0,NULL,11,NULL),(20,'123/3e phan văn trị, phường 7, quận gò vấp, thành phố ho chi minh',1500000,'2016-10-26 23:29:13',1,'nữ','http://i.imgur.com/yOWlgfn.jpg-SOPcIqd3FSHhOxO',15.0,0,'cao đẳng tchq',NULL,NULL,1,0,NULL,3,NULL),(21,'864 le duc tho, phường 15, quận go vap, thành phố ho chi minh',1500000,'2016-11-03 23:59:23',1,'nam','http://i.imgur.com/DFBiA6d.jpg-0ChNKxHASsNAXba',15.0,3000000,NULL,NULL,NULL,1,0,NULL,4,'98456372'),(22,'333 le duc tho, phường 15, quận go vap, thành phố ho chi minh',1500000,'2016-11-05 15:43:18',2,'nam','http://i.imgur.com/X67R55G.jpg-CGigqABUZOFgK7L',15.0,3000000,NULL,NULL,NULL,1,0,NULL,10,'499800056'),(25,'50 cách mạng tháng 8, phường 11, quận tân bình, thành phố hồ chí minh',3000000,'2016-11-10 22:30:44',5,'nữ','http://i.imgur.com/dDZGaHX.jpg-iOqECNXEynyFzOC',17.0,0,'đại học sài gòn','quản trị kinh doanh',NULL,1,0,NULL,2,NULL),(26,'590 phạm văn chiêu, phường 11, quận go vap, thành phố hồ chí minh',2000000,'2016-11-11 20:46:46',3,'nữ','http://i.imgur.com/9Pk64K3.jpg-P2KBf1IbJ6xtjBG',12.0,4000000,NULL,NULL,NULL,1,0,NULL,11,'456973822');
/*!40000 ALTER TABLE `phongtro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `hoten` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `diachi` mediumtext,
  `sodt` varchar(45) DEFAULT NULL,
  `skype` varchar(100) DEFAULT NULL,
  `facebook` varchar(100) DEFAULT NULL,
  `dotincay` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nhat','N@025104686/','nhat1','dangquangnhat18101994@gmail.com','864 lê đức thọ, phường 15, quận gò vấp, tp.hcm',NULL,NULL,NULL,9),(2,'nhat2','nhat025104686/','nhat2','dangquangnhat18101994@gmail.com','4/444 nhat','0987654321','sutrix.nhat.dang','https://www.facebook.com/dqn-dqn-dqn',3),(3,'nhat3','SrtV0oelv4evre','nhat3','dangquangnhat18101994@gmail.com',NULL,'0123456789',NULL,NULL,2),(4,'nhat4','lreverv4e0VotS','nhat4','dangquangnhat18101994@gmail.com',NULL,'0987654321',NULL,NULL,5),(5,'nhat5','0rVeoe4rStvlve','nhat5','dangquangnhat18101994@gmail.com',NULL,NULL,NULL,'https://www.facebook.com/abc',3),(6,'nhatdq','ote4errlv0evVS','DQN','dangquangnhat18101994@gmail.com','abc/123 le duc tho',NULL,NULL,NULL,1),(7,'nhatdq1810','N@025104686/','dqn','dangquangnhat18101994@gmail.com',NULL,NULL,NULL,NULL,0),(8,'nhatdq1','N@025104686/','nhatdq','dangquangnhat18101994@gmail.com',NULL,NULL,NULL,NULL,0),(9,'nhatdq2','StvroleveVer40','nhatdq','dangquangnhat18101994@gmail.com',NULL,NULL,NULL,NULL,0),(10,'f-dangquangnhat18101994','W86crS2GtE2H6uTKOSsiEemJpLuutnVB','Dang Quang Nhat','f-dangquangnhat18101994@gmail.com','864 lê đức thọ, phường 15, quận gò vấp, tp.hcm',NULL,NULL,'https://www.facebook.com/QuangNhatDang',0),(11,'g-dangquangnhat18101994','W86crS2GtE2H6uTKOSsiEemJpLuutnVB','Dang Nhat','g-nhatdq1810@gmail.com','864 lê đức thọ, phường 15, quận gò vấp, tp.hcm','0987654333',NULL,NULL,0),(12,'g-nhatdq1810','W86crS2GtE2H6uTKOSsiEemJpLuutnVB','dang nhat','g-nhatdq1810@gmail.com',NULL,NULL,NULL,NULL,0),(13,'nhatTest','N@025104686/','nhat','dangquangnhat18101994@gmail.com',NULL,NULL,NULL,NULL,0),(14,'nhat1810','nhat025104686/','d.q.n','dqn@dqn.com',NULL,'0123987456',NULL,NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_like_comment`
--

DROP TABLE IF EXISTS `user_like_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_like_comment` (
  `userID` int(11) NOT NULL,
  `commentID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`commentID`),
  KEY `fk_user_has_comment_comment1_idx` (`commentID`),
  KEY `fk_user_has_comment_user1_idx` (`userID`),
  CONSTRAINT `fk_user_has_comment_comment1` FOREIGN KEY (`commentID`) REFERENCES `comment` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_user_has_comment_user1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_like_comment`
--

LOCK TABLES `user_like_comment` WRITE;
/*!40000 ALTER TABLE `user_like_comment` DISABLE KEYS */;
INSERT INTO `user_like_comment` VALUES (5,2),(6,2),(11,2),(1,4),(1,13),(2,19),(2,20),(11,20),(2,21),(2,22),(1,27),(11,27),(13,27),(6,35),(2,36),(6,44);
/*!40000 ALTER TABLE `user_like_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_like_phongtro`
--

DROP TABLE IF EXISTS `user_like_phongtro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_like_phongtro` (
  `userID` int(11) NOT NULL,
  `phongtroID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`phongtroID`),
  KEY `fk_user_has_phongtro_phongtro1_idx` (`phongtroID`),
  KEY `fk_user_has_phongtro_user1_idx` (`userID`),
  CONSTRAINT `fk_user_has_phongtro_phongtro1` FOREIGN KEY (`phongtroID`) REFERENCES `phongtro` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_user_has_phongtro_user1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_like_phongtro`
--

LOCK TABLES `user_like_phongtro` WRITE;
/*!40000 ALTER TABLE `user_like_phongtro` DISABLE KEYS */;
INSERT INTO `user_like_phongtro` VALUES (3,2),(13,2),(1,3),(1,4),(2,6),(3,6),(11,20);
/*!40000 ALTER TABLE `user_like_phongtro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'trosv'
--
/*!50003 DROP PROCEDURE IF EXISTS `mysp_boThichComment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_boThichComment`(IN _commentID int, IN _userID int)
BEGIN
	DECLARE exit handler for sqlexception
	  BEGIN
		-- ERROR
	  ROLLBACK;
	END;

	DECLARE exit handler for sqlwarning
	 BEGIN
		-- WARNING
	 ROLLBACK;
	END;
    
    START TRANSACTION;
	delete from user_like_comment
    where commentID = _commentID
    and userID = _userID;
    
    select @userID_comment := userID from comment where id = _commentID;
    
    update user
    set dotincay = dotincay - 1
    where id = @userID_comment;
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_boThichPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_boThichPhongtro`(IN _phongtroID int, IN _userID int)
BEGIN
	DECLARE exit handler for sqlexception
	  BEGIN
		-- ERROR
	  ROLLBACK;
	END;

	DECLARE exit handler for sqlwarning
	 BEGIN
		-- WARNING
	 ROLLBACK;
	END;
    
    START TRANSACTION;
	delete from user_like_phongtro
    where phongtroID = _phongtroID
    and userID = _userID;
    
    select @userID_pt := userID from phongtro where id = _phongtroID;
    
    update user
    set dotincay = dotincay - 1
    where id = @userID_pt;
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_capnhatComment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_capnhatComment`(IN _id int, IN _noidung longtext, IN _ngay varchar(45))
BEGIN
	update comment
    set noidung = _noidung, ngay = _ngay
    where id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_capnhatDotincay` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_capnhatDotincay`(IN _username varchar(45), IN _dotincay int)
BEGIN
	call trosv.mysp_layIdTheoUsername(_username, @id);
    
    update user
    set dotincay = _dotincay
    where id = @id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_capnhatHinhanhPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_capnhatHinhanhPhongtro`(IN _id int, IN _hinhanh mediumtext)
BEGIN
	if _hinhanh = '' then set _hinhanh = NULL;
    end if;
    
	update phongtro
    set hinhanh = _hinhanh
    where id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_capnhatPassword` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_capnhatPassword`(IN _username varchar(45), IN _password varchar(45))
BEGIN
	call trosv.mysp_layIdTheoUsername(_username, @id);
    
    update user
    set password = _password
    where id = @id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_capnhatPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_capnhatPhongtro`(IN _id int, IN _diachi mediumtext, IN _giatien int
, IN _ngaydang varchar(45), IN _songuoi int, IN _tiencoc int, IN _dientich decimal(10,1), IN _gioitinh varchar(5), IN _truong varchar(45)
, IN _nganh varchar(45), IN _khoa varchar(45), IN _wifi int, IN _chu int
, IN _ghichu mediumtext, IN _nganhangID varchar(45))
BEGIN
	if _truong = '' then set _truong = NULL;
    end if;
    if _nganh = '' then set _nganh = NULL;
    end if;
    if _khoa = '' then set _khoa = NULL;
    end if;
    if _ghichu = '' then set _ghichu = NULL;
    end if;
    if _nganhangID = '' then set _nganhangID = NULL;
    end if;

	update phongtro
    set diachi = _diachi, giatien = _giatien, ngaydang = _ngaydang, songuoi = _songuoi
    , tiencoc = _tiencoc, dientich = _dientich, gioitinh = _gioitinh, truong = _truong, nganh = _nganh, khoa = _khoa
    , wifi = _wifi, chu = _chu, ghichu = _ghichu, nganhangID = _nganhangID 
    where id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_capnhatUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_capnhatUser`(IN _username varchar(45), IN _hoten varchar(45)
, IN _diachi mediumtext
, IN _sodt varchar(45), IN _email varchar(45), IN _skype varchar(100)
, IN _facebook varchar(100), OUT _result int)
BEGIN
	call trosv.mysp_layIdTheoUsername(_username, @id);

	set _result := (select count(*) from user where email = _email and username = _username);
    if _result != 0 then
		if _diachi = '' then set _diachi = NULL;
		end if;
		if _sodt = '' then set _sodt = NULL;
		end if;
		if _skype = '' then set _skype = NULL;
		end if;
		if _facebook = '' then set _facebook = NULL;
		end if;

		update user
		set hoten = _hoten, diachi = _diachi, sodt = _sodt
		, skype = _skype, facebook = _facebook
		where id = @id;
	else
		set _result := (select count(*) from user where email = _email);
		if _result = 0 then
		
			if _diachi = '' then set _diachi = NULL;
			end if;
			if _sodt = '' then set _sodt = NULL;
			end if;
			if _skype = '' then set _skype = NULL;
			end if;
			if _facebook = '' then set _facebook = NULL;
			end if;

			update user
			set hoten = _hoten, diachi = _diachi, sodt = _sodt, email = _email
			, skype = _skype, facebook = _facebook
			where id = @id;
		else
			set _result := -2;
		end if;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_chuyenTien` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_chuyenTien`(IN _id_gui varchar(45), IN _id_nhan varchar(45), IN _ngay varchar(45), IN _tien int, IN _phongtroID int, OUT _result int)
BEGIN
    set _result := 0;
    
	select @compare := _tien <= (select tien from nganhang where id = _id_gui);
	
    if @compare = 1 then
		insert into giaodich
        values (_id_gui, _id_nhan, _ngay, _tien);
        
        update nganhang
        set tien = tien - _tien
        where id = _id_gui;
        
        update nganhang
        set tien = tien + _tien
        where id = _id_nhan;
        
        update phongtro
        set songuoi = songuoi - 1
        where id = _phongtroID;
        
        set _result := 1;
    end if;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_kiemtraUserThichPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_kiemtraUserThichPhongtro`(IN _phongtroID int, IN _userID int)
BEGIN
	select count(*) as _result 
    from user_like_phongtro 
    where phongtroID = _phongtroID and userID = _userID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layCommentPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layCommentPhongtro`(IN _phongtroID int)
BEGIN
	select * 
    from comment
    where phongtroID = _phongtroID
    order by ngay DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layCommentUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layCommentUser`(IN _userID int)
BEGIN
	select * 
    from comment
    where userID = _userID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layCommentUserThich` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layCommentUserThich`(IN _userID int)
BEGIN
	select commentID
    from user_like_comment
    where userID = _userID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layGiaodich` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layGiaodich`(IN _nganhangID varchar(45))
BEGIN
	select *
    from giaodich
    where nganhangID_gui = _nganhangID
    or nganhangID_nhan = _nganhangID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layGiaodichGui` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layGiaodichGui`(IN _nganhangID_gui varchar(45))
BEGIN
	select *
    from giaodich
    where nganhangID_gui = _nganhangID_gui;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layGiaodichNhan` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layGiaodichNhan`(IN _nganhangID_nhan varchar(45))
BEGIN
	select *
    from giaodich
    where nganhangID_nhan = _nganhangID_nhan;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layIdTheoUsername` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layIdTheoUsername`(IN _username varchar(45), OUT _id int)
BEGIN
	select id into _id
	from user
	where username = _username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layLuotThichComment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layLuotThichComment`(IN _commentID int)
BEGIN
	select count(*) as thich
    from user_like_comment
    where commentID = _commentID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layLuotThichPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layLuotThichPhongtro`(IN _phongtroID int)
BEGIN
	select count(*) as thich
    from user_like_phongtro
    where phongtroID = _phongtroID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layNghIdTheoUsername` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layNghIdTheoUsername`(IN _username varchar(45), OUT _id varchar(45))
BEGIN
	select id into _id
	from nganhang
	where username = _username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layPhongtro`(IN _id int)
BEGIN
	select * 
    from phongtro
    where id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layPhongtroHot` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layPhongtroHot`(IN _gioihan int)
BEGIN
	select *
    from phongtro
    inner join
    (select phongtroID, count(id) as popularRate
		from comment 
		group by phongtroID) as ptID
	on phongtro.id = ptID.phongtroID
    left join
    (select phongtroID, count(userID) as likeRate
		from user_like_phongtro
		group by phongtroID) as likeID
	on phongtro.id = likeID.phongtroID
    where phongtro.songuoi > 0
    order by popularRate DESC, likeRate DESC, phongtro.ngaydang DESC
    limit _gioihan;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layPhongtroMoi` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layPhongtroMoi`(IN _gioihan int)
BEGIN
	select *
    from phongtro
    where songuoi > 0
    order by ngaydang DESC, id DESC
    limit _gioihan; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layPhongtroUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layPhongtroUser`(IN _userID int)
BEGIN
	select * 
    from phongtro
    where userID = _userID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layTatcaPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layTatcaPhongtro`()
BEGIN
	select *
    from phongtro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layThongtinNganhang` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layThongtinNganhang`(IN _username varchar(45))
BEGIN
	call trosv.mysp_layNghIdTheoUsername(_username, @id);

	select * 
    from nganhang
    where id = @id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layThongtinNganhangTheoId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layThongtinNganhangTheoId`(IN _id varchar(45))
BEGIN
	select * 
    from nganhang
    where id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layThongtinUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layThongtinUser`(IN _username varchar(45))
BEGIN
	call trosv.mysp_layIdTheoUsername(_username, @id);

	select * 
    from user
    where id = @id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layThongtinUserID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layThongtinUserID`(IN _id int)
BEGIN
	select * 
    from user
    where id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_login`(IN _username varchar(45), IN _password varchar(45))
BEGIN
	select *
    from user
    where username = _username
    and password = _password;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_nghLogin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_nghLogin`(IN _username varchar(45), IN _password varchar(45))
BEGIN
	select *
    from nganhang
    where username = _username
    and password = _password;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_phuchoiPassword` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_phuchoiPassword`(IN _username varchar(45), OUT _result int, OUT _email varchar(100), OUT _username_out varchar(45))
BEGIN
	set _result := (select count(*) from user where username = _username or email = _username);
    set _email := (select email from user where username = _username or email = _username);
    set _username_out := (select username from user where username = _username or email = _username);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_themComment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_themComment`(IN _noidung longtext, IN _ngay varchar(45)
, IN _userID int, IN _phongtroID int)
BEGIN
	insert into comment(noidung, ngay, userID, phongtroID)
    values (_noidung, _ngay, _userID, _phongtroID);
    
    set @last_id = LAST_INSERT_ID();
    select * from comment where id = @last_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_themGiaodich` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_themGiaodich`(IN _nganhangID_gui varchar(45), IN _nganhangID_nhan varchar(45)
, IN _ngay varchar(45), IN _tien int)
BEGIN
	insert into giaodich(nganhangID_gui, nganhangID_nhan, ngay, tien)
    values (_nganhangID_gui, _nganhangID_nhan, _ngay, _tien);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_themPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_themPhongtro`(IN _diachi mediumtext, IN _giatien int
, IN _ngaydang varchar(45), IN _songuoi int, IN _tiencoc int, IN _dientich decimal(10,1), IN _hinhanh varchar(45), IN _gioitinh varchar(5), IN _truong varchar(45)
, IN _nganh varchar(45), IN _khoa varchar(45), IN _wifi int, IN _chu int
, IN _ghichu mediumtext, IN _userID int, IN _nganhangID varchar(45), OUT _id int)
BEGIN
	if _truong = '' then set _truong = NULL;
    end if;
    if _nganh = '' then set _nganh = NULL;
    end if;
    if _khoa = '' then set _khoa = NULL;
    end if;
    if _ghichu = '' then set _ghichu = NULL;
    end if;
    if _gioitinh = '' then set _gioitinh = 'nam';
    end if;
    if _nganhangID = '' then set _nganhangID = NULL;
    end if;

	insert into phongtro(diachi, giatien, ngaydang, songuoi, tiencoc, dientich, hinhanh, gioitinh, truong, nganh, khoa
    , wifi, chu, ghichu, userID, nganhangID)
    values (_diachi, _giatien, _ngaydang, _songuoi, _tiencoc, _dientich, _hinhanh, _gioitinh, _truong, _nganh, _khoa
    , _wifi, _chu, _ghichu, _userID, _nganhangID);
    
    set _id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_themUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_themUser`(IN _username varchar(45), IN _password varchar(45)
, IN _hoten varchar(45), IN _email varchar(45), IN _facebook varchar(100), OUT _result int)
BEGIN
	set _result := (select count(*) from user where username = _username);
    if _facebook = '' then set _facebook = NULL;
    end if;
    
	if _result = 0 then
		set _result := (select count(*) from user where email = _email);
        if _result = 0 then
			insert into user(username, password, hoten, email, facebook)
			values (_username, _password, _hoten, _email, _facebook);
			set _result := 1;
		else
			set _result := -2;
		end if;
    else
		set _result := 0;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_thichComment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_thichComment`(IN _commentID int, IN _userID int)
BEGIN
	DECLARE exit handler for sqlexception
	  BEGIN
		-- ERROR
	  ROLLBACK;
	END;

	DECLARE exit handler for sqlwarning
	 BEGIN
		-- WARNING
	 ROLLBACK;
	END;
    
    START TRANSACTION;
	insert into user_like_comment(commentID, userID)
    values(_commentID, _userID);
    
    select @userID_comment := userID from comment where id = _commentID;
    
    update user
    set dotincay = dotincay + 1
    where id = @userID_comment;
    COMMIT;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_thichPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_thichPhongtro`(IN _phongtroID int, IN _userID int)
BEGIN
	DECLARE exit handler for sqlexception
	  BEGIN
		-- ERROR
	  ROLLBACK;
	END;

	DECLARE exit handler for sqlwarning
	 BEGIN
		-- WARNING
	 ROLLBACK;
	END;
    
    START TRANSACTION;
	insert into user_like_phongtro(phongtroID, userID)
    values(_phongtroID, _userID);
    
    select @userID_pt := userID from phongtro where id = _phongtroID;
    
    update user
    set dotincay = dotincay + 1
    where id = @userID_pt;
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_timkiemPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_timkiemPhongtro`(IN _giatien_min int, IN _giatien_max int
, IN _tiencoc_min int, IN _tiencoc_max int, IN _dientich_min int, IN _dientich_max int, IN _truong varchar(45)
, IN _nganh varchar(45), IN _khoa varchar(45), IN _gioitinh varchar(5), IN _wifi int, IN _chu int, IN _gioihan int)
BEGIN
	if _giatien_max = 5000000 then
		set _giatien_max = (select max(giatien) from phongtro);
	end if;
	if _tiencoc_max = 5000000 then
		set _tiencoc_max = (select max(tiencoc) from phongtro);
	end if;
    
    if _dientich_max = 20 then
		set _dientich_max = (select max(dientich) from phongtro);
	end if;
    
	select *
    from phongtro
    where giatien >= _giatien_min 
    and giatien <= _giatien_max
    and tiencoc >= _tiencoc_min 
    and tiencoc <= _tiencoc_max
    and dientich >= _dientich_min 
    and dientich <= _dientich_max
    and (truong like concat('%',_truong,'%') or _truong = '')
    and (nganh like concat('%',_nganh,'%') or _nganh = '')
    and (khoa like concat('%',_khoa,'%') or _khoa = '')
    and (gioitinh = _gioitinh or _gioitinh = '')
    and (wifi = _wifi or _wifi = -1)
    and (chu = _chu or _chu = -1)
    and songuoi > 0
    limit _gioihan;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_xoaComment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_xoaComment`(IN _id int)
BEGIN
	delete from comment
    where id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_xoaGiaodich` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_xoaGiaodich`(IN _nganhangID varchar(45))
BEGIN
	delete from giaodich
    where nganhangID_gui = _nganhangID or nganhangID_nhan = _nganhangID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_xoaHinhanhPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_xoaHinhanhPhongtro`(IN _id int)
BEGIN
	update phongtro
    set hinhanh = NULL
    where id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_xoaPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_xoaPhongtro`(IN _id int)
BEGIN
	delete from user_like_comment
    where commentID in (select id from comment where phongtroID = _id);

	delete from comment
    where phongtroID = _id;
    
	delete from user_like_phongtro
    where phongtroID = _id;
    
	delete from phongtro
    where id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_xoaUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_xoaUser`(IN _username varchar(45))
BEGIN
	call trosv.mysp_layIdTheoUsername(_username, @id);

	delete from user
    where id = @id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-12 23:19:12
