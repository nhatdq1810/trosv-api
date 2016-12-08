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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (2,'ment1comment1','2016-10-03 00:00:00',1,2),(3,'comment3','2016-10-01 00:00:00',4,2),(4,'comment4','2016-10-02 00:00:00',2,3),(5,'comment5','2016-10-10 00:00:00',1,3),(13,'comment8','2016-09-09 00:00:00',5,3),(14,'comment9','2016-09-10 20:00:00',2,3),(17,'comment12','2016-10-09 00:00:00',5,10),(19,'nhat comment','2016-11-03 23:13:44',1,20),(20,'nhat comment 2','2016-11-03 23:15:20',1,20),(21,'nhat4 commented','2016-11-03 23:22:06',4,20),(22,'nhat4 commented22222','2016-11-03 23:22:12',4,20),(26,'phong tro nay an ninh tot','2016-11-04 00:00:34',4,21),(27,'phong tro gia re, tam dc :D','2016-11-04 00:00:56',4,21),(28,'phòng trọ rộng, nhưng hơi khó tìm','2016-11-06 10:41:58',1,2),(29,'phong tro sach se','2016-11-06 21:43:14',10,15),(30,'phong tro hoi nho','2016-11-06 21:43:49',10,21),(31,'giá quá rẻ :)','2016-11-06 21:44:17',10,22),(32,'giá hơi chua, có thể fix một ít được không','2016-11-06 21:44:57',10,17),(34,'Phòng trọ tốt lắm , các bạn mau nhanh chân không hết chỗ :)','2016-11-10 21:30:56',1,6),(35,'test comment mới','2016-11-10 21:00:00',3,6),(36,'test function thichComment moi','2016-11-10 21:46:46',1,6),(37,'test\ntest\ntest\ntest','2016-11-10 21:49:06',1,6),(40,'good (y)','2016-11-10 22:09:48',2,4),(41,'not good\n','2016-11-10 22:13:52',1,4),(42,'sao lại k good bạn','2016-11-10 22:19:42',2,4),(43,'xa trường quá','2016-11-10 22:31:12',2,25),(44,'test comment\n','2016-11-11 20:32:20',1,3),(45,'phòng trọ mới xây , sạch sẽ lắm các bạn\n<3 <3 <3','2016-11-11 20:47:55',11,26),(46,'test\ntest ','2016-11-14 21:21:31',1,13),(47,'good\nnot bad','2016-11-18 22:38:11',1,13);
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
INSERT INTO `giaodich` VALUES ('123786540','98456372',2,'2016-10-03 00:00:00',5000000),('123786540','98456372',10,'2016-10-22 23:30:39',3000000),('255569139','456973822',26,'2016-10-11 18:00:00',1000000),('255569139','456973822',3,'2016-11-14 23:55:05',500000),('255569139','98456372',10,'2016-11-06 10:38:51',1500000),('255569139','98456372',13,'2016-11-06 10:41:00',1500000),('255569139','98456372',21,'2016-11-10 22:32:21',3000000),('456973822','255569139',6,'2016-10-09 18:00:00',550000),('499800056','255569139',6,'2016-10-22 23:37:36',1500000),('98456372','123786540',4,'2016-09-30 00:00:00',2000000),('98456372','123786540',4,'2016-10-01 00:00:00',2500000),('98456372','123786540',4,'2016-10-10 00:00:00',2000000),('98456372','123786540',4,'2016-10-10 05:00:00',1000000),('98456372','255569139',6,'2016-10-22 23:42:04',1500000),('98456372','255569139',6,'2016-10-23 18:08:40',1500000),('98456372','255569139',6,'2016-11-06 10:25:13',3000000),('98456372','255569139',6,'2016-11-06 10:34:41',3000000),('98456372','255569139',6,'2016-11-14 23:49:58',2500000),('98456372','456973822',3,'2016-11-06 21:38:22',3000000),('98456372','456973822',3,'2016-11-14 23:42:50',500000),('98456372','456973822',3,'2016-11-14 23:45:39',500000),('98456372','499800056',27,'2016-11-18 22:06:12',500000);
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
INSERT INTO `nganhang` VALUES ('123786540','nhat2','123456','Nguyen Van B','1234 abc','0123456789','987654321',1000000),('255569139','nhat5','123456','nhat5','1234 aabc','0123456089','987054321',4000000),('456973822','nhat3','123456','nhat1','123 abc','0123456789','123456789',2000000),('499800056','nhat4','123456','nhat4','1234 aqbc','0133456789','982654321',500000),('98456372','nhat','123456','Nguyen Van A','123 abc','0123456789','123456789',3000000);
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
  `loaiPhong` int(11) NOT NULL DEFAULT '2',
  `diachi` mediumtext NOT NULL,
  `giatien` int(11) unsigned NOT NULL DEFAULT '0',
  `giatienTheoNguoi` int(10) unsigned NOT NULL DEFAULT '0',
  `ngaydang` datetime NOT NULL,
  `sophong` int(11) unsigned NOT NULL DEFAULT '1',
  `gioitinh` varchar(5) NOT NULL,
  `hinhanh` mediumtext,
  `dientich` decimal(10,1) NOT NULL,
  `tiencoc` int(11) unsigned DEFAULT '0',
  `tiencocTheoNguoi` int(11) unsigned DEFAULT '0',
  `truong` varchar(45) DEFAULT NULL,
  `nganh` varchar(45) DEFAULT NULL,
  `khoa` varchar(45) DEFAULT NULL,
  `wifi` int(11) DEFAULT '0',
  `chu` int(11) DEFAULT '0',
  `ghichu` mediumtext,
  `duyet` int(11) NOT NULL DEFAULT '0',
  `an` int(11) NOT NULL DEFAULT '0',
  `userID` int(11) NOT NULL,
  `nganhangID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_phongtro_user1_idx` (`userID`),
  KEY `fk_phongtro_nganhang1_idx` (`nganhangID`),
  CONSTRAINT `fk_phongtro_nganhang1` FOREIGN KEY (`nganhangID`) REFERENCES `nganhang` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_phongtro_user1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phongtro`
--

LOCK TABLES `phongtro` WRITE;
/*!40000 ALTER TABLE `phongtro` DISABLE KEYS */;
INSERT INTO `phongtro` VALUES (2,2,'345 lê văn thọ, phường 15, quận gò vấp, thành phố ho chi minh',2500000,500000,'2016-09-30 00:00:00',5,'','http://i.imgur.com/4dBWUZC.jpg-JqHyHieyuQA2TrO',20.0,1500000,500000,'học viện cn bưu chính viễn thông','công nghệ thông tin','2012',1,1,'có nhà vệ sinh riêng, tiền rác đã tính trong tiền nhà',0,0,5,'98456372'),(3,1,'12/3 man thiện, phường hiệp phú, quận 9, thành phố HCM',0,500000,'2016-11-12 09:43:27',2,'nữ','http://i.imgur.com/hl6kXkT.jpg-GTkQU4WidUMB1HG',20.0,0,500000,'ueh',NULL,NULL,1,1,NULL,0,1,6,'456973822'),(4,2,'333 man thiện, phường tăng nhơn phú a, quận 9, thành phố hồ chí minh',2500000,500000,'2016-11-10 22:43:40',2,'nam','http://i.imgur.com/P69IyzZ.jpg-EluLqiJbUBqU3CZ',20.0,2500000,500000,'đại học sư phạm kỹ thuật',NULL,'2012',1,0,NULL,1,0,2,'123786540'),(6,0,'123 cây trâm, phường 15, quận gò vấp, thành phố ho chi minh',2000000,0,'2016-10-20 19:56:53',2,'','http://i.imgur.com/RuH6SwU.jpg-oKrlBIiYGnv8FDq',20.0,2500000,0,'huflit',NULL,NULL,0,1,NULL,1,0,1,'255569139'),(10,2,'435-461 phan văn trị, phường 5, quận gò vấp, thành phố hồ chí minh',3000000,1000000,'2016-08-12 22:36:50',1,'nữ','http://i.imgur.com/IE2gt6X.jpg-XRD4NoLQJUt9DOX',25.0,3000000,0,NULL,'kế toán',NULL,1,0,NULL,1,0,3,'98456372'),(13,1,'e1-e2 quang trung, phường 11, quận gò vấp, thành phố hồ chí minh',0,950000,'2016-10-18 22:39:18',5,'','http://i.imgur.com/847Pf7p.jpg-UoTqdHJvIYqyHSw',17.0,0,0,'đại học sư phạm kỹ thuật',NULL,NULL,1,0,NULL,1,1,1,NULL),(15,0,'2a phan văn trị, phường 10, quận gò vấp, thành phố hồ chí minh',2500000,0,'2016-09-14 22:21:37',1,'nam','http://i.imgur.com/diQHd9p.jpg-GcMLQ6G7bll6x3J',14.0,0,0,NULL,NULL,NULL,1,0,'Giá chưa bao gồm tiền điện, nước và rác',0,0,10,NULL),(17,1,'321/22 lê văn thọ, phường 16, quận gò vấp, thành phố hồ chí minh',0,500000,'2016-11-06 21:59:56',1,'nam','http://i.imgur.com/oaiIhhC.jpg-r4SuXSsAVGE93k7',20.0,0,1000000,'bách khoa','điện tử',NULL,1,0,NULL,0,0,11,'123786540'),(20,1,'123/3e phan văn trị, phường 7, quận gò vấp, thành phố ho chi minh',0,500000,'2016-08-26 23:29:13',1,'nữ','http://i.imgur.com/yOWlgfn.jpg-SOPcIqd3FSHhOxO',15.0,0,0,'cao đẳng tchq',NULL,NULL,1,0,NULL,-1,0,3,NULL),(21,2,'864 le duc tho, phường 15, quận go vap, thành phố ho chi minh',1500000,500000,'2016-11-03 23:59:23',1,'nam','http://i.imgur.com/DFBiA6d.jpg-0ChNKxHASsNAXba',15.0,3000000,0,NULL,NULL,NULL,1,0,NULL,1,0,4,'98456372'),(22,0,'368 nguyễn oanh, phường 17, quận gò vấp, thành phố hồ chí minh',1500000,0,'2016-09-15 22:12:11',2,'','http://i.imgur.com/X67R55G.jpg-CGigqABUZOFgK7L',15.0,3000000,0,NULL,NULL,NULL,1,0,NULL,1,0,10,'499800056'),(25,2,'50 cách mạng tháng 8, phường 11, quận tân bình, thành phố hồ chí minh',3000000,1500000,'2016-11-10 22:30:44',5,'nữ','http://i.imgur.com/dDZGaHX.jpg-iOqECNXEynyFzOC',17.0,0,0,'đại học sài gòn','quản trị kinh doanh',NULL,1,0,NULL,-1,0,2,NULL),(26,2,'590 phạm văn chiêu, phường 11, quận go vap, thành phố hồ chí minh',2000000,500000,'2016-11-11 20:46:46',3,'nữ','http://i.imgur.com/9Pk64K3.jpg-P2KBf1IbJ6xtjBG',12.0,4000000,0,NULL,NULL,NULL,1,0,NULL,-1,0,11,'456973822'),(27,2,'261b lê quang định, phường 7, quận bình thạnh, thành phố hồ chí minh',1500000,500000,'2016-11-14 21:29:11',3,'nam','http://i.imgur.com/Mp1AGQQ.jpg-9XImQ1SzHBBGlfH',12.0,0,500000,NULL,'cơ khí',NULL,1,1,NULL,1,0,12,'499800056'),(28,1,'11 hẻm 11, phường tây thạnh, quận tân phú, thành phố hồ chí minh',0,1000000,'2016-11-15 22:03:46',5,'','http://i.imgur.com/tfybyTe.jpg-cO3vtMbxmbfTuSX',5.0,0,500000,'đại học công nghiệp thực phẩm',NULL,NULL,1,0,NULL,-1,0,7,'123786540'),(30,1,'69/1b lê văn thọ, phường 8, quận gò vấp, thành phố hồ chí minh',0,1500000,'2016-09-15 22:14:01',4,'','http://i.imgur.com/whRkCDe.jpg-KP3q2wrkqg5qYH0',11.0,0,0,NULL,NULL,NULL,1,1,NULL,0,0,10,NULL),(31,2,'718 quang trung, phường 11, quận gò vấp, thành phố hồ chí minh',2500000,800000,'2016-11-18 22:26:16',5,'','http://i.imgur.com/6QEP5NJ.jpg-mdqAOr6XO7bVp2G',13.0,0,0,NULL,NULL,NULL,1,1,NULL,0,0,12,NULL),(32,1,'311 lê quang định, phường 7, quận bình thạnh, thành phố hồ chí minh',0,750000,'2016-10-18 23:07:43',5,'','http://i.imgur.com/m6GIIFO.jpg-y79x7SZpRylnIRF',12.0,0,0,'đại học sài gòn','kế toán',NULL,1,1,NULL,1,0,1,NULL),(33,2,'107 cộng hòa, phường 13, quận tân bình, thành phố hồ chí minh',2300000,1000000,'2016-11-20 22:50:27',5,'','http://i.imgur.com/Lr3IWBr.jpg-wGrf5oiPDGBwtx8',11.0,0,0,'đại học mở','quản trị kinh doanh','2014',0,1,NULL,-1,0,8,NULL),(34,2,'hẻm b22 bạch đằng, phường 2, quận tân bình, thành phố hồ chí minh',3000000,1500000,'2016-11-20 23:17:09',1,'nữ','http://i.imgur.com/bQRbPj8.jpg-9iIElsd5Sve98Zt',14.0,0,0,NULL,'ngân hàng',NULL,1,0,NULL,0,0,9,NULL),(35,2,'149 lê văn sỹ, phường 14, quận phú nhuận, thành phố hồ chí minh',4000000,2000000,'2016-11-20 23:18:53',2,'nam','http://i.imgur.com/0Hv1las.jpg-ld9heSqmnLw8p8J',15.0,0,0,NULL,NULL,NULL,1,0,NULL,0,0,9,NULL),(36,0,'248 nguyễn văn nghi, phường 7, quận gò vấp, thành phố hồ chí minh',1800000,0,'2016-11-20 23:24:41',2,'nam','http://i.imgur.com/HJXgy3y.jpg-shOGQjskR3ry6MQ',11.0,0,0,'công nghiệp 4','công nghệ thông tin','2015',1,1,NULL,-1,0,13,NULL),(37,0,'747 trường chinh, phường tây thạnh, quận tân phú, thành phố hồ chí minh',1200000,0,'2016-11-20 23:45:26',4,'','http://i.imgur.com/HWSfrba.jpg-3y2lVo5VrIQWMw0',12.0,1000000,0,NULL,NULL,'2015',1,1,NULL,-1,0,1,'123786540'),(53,2,'26 trường chinh, phường tây thạnh, quận tân phú, thành phố hồ chí minh',2000000,1000000,'2016-12-04 14:46:52',2,'','http://i.imgur.com/bZ3t2x6.jpg-MpTgSCRHUA3LrkT',5.0,0,0,NULL,NULL,NULL,1,1,NULL,-1,0,1,NULL);
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
  `loai` varchar(45) NOT NULL DEFAULT 'user',
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `hoten` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `ngayDK` datetime DEFAULT NULL,
  `diachi` mediumtext,
  `sodt` varchar(45) DEFAULT NULL,
  `skype` varchar(100) DEFAULT NULL,
  `facebook` varchar(100) DEFAULT NULL,
  `dotincay` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','nhat','N@025104686/','nhat1','dangquangnhat18101994@gmail.com','2016-08-29 00:00:00','864 lê đức thọ, phường 15, quận gò vấp, tp.hcm',NULL,NULL,NULL,9),(2,'user','nhat2','nhat025104686/','nhat2','dangquangnhat2@gmail.com','2016-07-29 00:00:00','4/444 nhat','0987654321','sutrix.nhat.dang','https://www.facebook.com/dqn-dqn-dqn',3),(3,'user','nhat3','SrtV0oelv4evre','nhat3','dangquangnhat3@gmail.com','2016-08-01 00:00:00',NULL,'0123456789',NULL,NULL,2),(4,'user','nhat4','lreverv4e0VotS','nhat4','dangquangnhat4@gmail.com','2016-06-29 00:00:00',NULL,'0987654321',NULL,NULL,5),(5,'user','nhat5','0rVeoe4rStvlve','nhat5','dangquangnhat5@gmail.com','2016-06-29 00:00:00',NULL,NULL,NULL,'https://www.facebook.com/abc',3),(6,'user','nhatdq','ote4errlv0evVS','DQN','dangquangnhat6@gmail.com','2016-07-29 00:00:00','abc/123 le duc tho',NULL,NULL,NULL,1),(7,'user','nhatdq1810','N@025104686/','dqn','dangquangnhat7@gmail.com','2016-09-29 00:00:00',NULL,NULL,NULL,NULL,0),(8,'user','nhatdq1','N@025104686/','nhatdq','dangquangnhat8@gmail.com','2016-09-29 00:00:00',NULL,NULL,NULL,NULL,0),(9,'user','nhatdq2','StvroleveVer40','nhatdq','dangquangnhat9@gmail.com','2016-09-29 00:00:00',NULL,NULL,NULL,NULL,0),(10,'user','fb-dangquangnhat18101994','W86crS2GtE2H6uTKOSsiEemJpLuutnVB','Dang Quang Nhat','fb-dangquangnhat18101994@gmail.com','2016-08-29 00:00:00','864 lê đức thọ, phường 15, quận gò vấp, tp.hcm',NULL,NULL,'https://www.facebook.com/QuangNhatDang',0),(11,'user','gg-dangquangnhat18101994','W86crS2GtE2H6uTKOSsiEemJpLuutnVB','Dang Nhat','gg-dangquangnhat18101994@gmail.com','2016-09-29 00:00:00','864 lê đức thọ, phường 15, quận gò vấp, tp.hcm','0987654333',NULL,NULL,0),(12,'user','gg-dqn1810','W86crS2GtE2H6uTKOSsiEemJpLuutnVB','dang nhat','gg-dqn1810@gmail.com','2016-09-29 00:00:00',NULL,NULL,NULL,'https://www.facebook.com/QuangNhatDang',0),(13,'user','nhatTest','N@025104686/','nhat','dangquangnhat10@gmail.com','2016-09-29 00:00:00',NULL,NULL,NULL,NULL,0),(14,'user','nhat1810','nhat025104686/','d.q.n','dqn@dqn.com','2016-10-29 00:00:00',NULL,'0123987456',NULL,NULL,0),(15,'admin','admin','N@025104686/','DQN','nhatdq1810@gmail.com','2016-06-01 00:00:00',NULL,NULL,NULL,NULL,0),(16,'user','nhatTestNgay','nhat025104686/','nhat dang','nhat.dang@gmail.com','2016-12-01 00:00:00',NULL,NULL,NULL,NULL,0);
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
/*!50003 DROP FUNCTION IF EXISTS `GET_DUONG` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `GET_DUONG`(x VARCHAR(255)) RETURNS varchar(255) CHARSET utf8mb4
return substring(x, char_length(substring_index(x, ' ', 1)) + 1, 
char_length(substring_index(x, ',', 1)) - char_length(substring_index(x, ' ', 1))) ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `SPLIT_STR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SPLIT_STR`(
x VARCHAR(255),
delim VARCHAR(12),
pos INT
) RETURNS varchar(255) CHARSET utf8mb4
RETURN REPLACE(SUBSTRING(SUBSTRING_INDEX(x, delim, pos),
CHAR_LENGTH(SUBSTRING_INDEX(x, delim, pos -1)) + 1),
delim, '') ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_anPT` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_anPT`(IN _phongtroID int, IN _an int)
BEGIN
	update phongtro
    set an = _an
    where id = _phongtroID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_capnhatPhongtro`(IN _id int, IN _loaiPhong int, IN _diachi mediumtext, IN _giatien int, IN _giatienTheoNguoi int
, IN _ngaydang varchar(45), IN _sophong int, IN _tiencoc int, IN _tiencocTheoNguoi int, IN _dientich decimal(10,1), IN _gioitinh varchar(5), IN _truong varchar(45)
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
    set loaiPhong = _loaiPhong, diachi = _diachi, giatien = _giatien, giatienTheoNguoi = _giatienTheoNguoi, ngaydang = _ngaydang, sophong = _sophong
    , tiencoc = _tiencoc, tiencocTheoNguoi = _tiencocTheoNguoi, dientich = _dientich, gioitinh = _gioitinh, truong = _truong, nganh = _nganh, khoa = _khoa
    , wifi = _wifi, chu = _chu, ghichu = _ghichu, nganhangID = _nganhangID, duyet = 0 
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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_chuyenTien`(IN _id_gui varchar(45), IN _id_nhan varchar(45), IN _ngay varchar(45), IN _tien int, IN _phongtroID int, OUT _result int)
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
    
    
    set _result := 0;
    
	select @compare := _tien <= (select tien from nganhang where id = _id_gui);
	
    if @compare = 1 then
		START TRANSACTION;
		insert into giaodich(nganhangID_gui, nganhangID_nhan, phongtroID, ngay, tien)
        values (_id_gui, _id_nhan, _phongtroID, _ngay, _tien);
        
        update nganhang
        set tien = tien - _tien
        where id = _id_gui;
        
        update nganhang
        set tien = tien + _tien
        where id = _id_nhan;
        
        set _result := 1;
        COMMIT;
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
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layDulieuTimkiemPhongtro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layDulieuTimkiemPhongtro`()
BEGIN
	select truong, nganh, khoa
    from phongtro
    where (!isnull(truong) or !isnull(nganh) or !isnull(khoa));
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
    where phongtro.sophong > 0
    and phongtro.duyet = 1
    and phongtro.an = 0
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
    where sophong > 0
    and phongtro.duyet = 1
    and phongtro.an = 0
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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layPhongtroUser`(IN _userID int)
BEGIN
	select * 
    from phongtro
    where userID = _userID
    order by ngaydang DESC;
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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layTatcaPhongtro`(IN _duyet int)
BEGIN
	select *
    from phongtro
    where duyet = _duyet;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_layTatcaUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_layTatcaUser`()
BEGIN
	select *
    from user
    where loai = 'user';
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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_login`(IN _username varchar(45), IN _password varchar(45)
, IN _loai varchar(45))
BEGIN
	select *
    from user
    where username = _username
    and password = _password
    and loai = _loai;
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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_themPhongtro`(IN _loaiPhong int, IN _diachi mediumtext, IN _giatien int, IN _giatienTheoNguoi int
, IN _ngaydang varchar(45), IN _sophong int, IN _tiencoc int, IN _tiencocTheoNguoi int, IN _dientich decimal(10,1), IN _hinhanh varchar(45), IN _gioitinh varchar(5), IN _truong varchar(45)
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
    if _nganhangID = '' then set _nganhangID = NULL;
    end if;

	insert into phongtro(loaiPhong, diachi, giatien, giatienTheoNguoi, ngaydang, sophong, tiencoc, tiencocTheoNguoi, dientich, hinhanh, gioitinh, truong, nganh, khoa
    , wifi, chu, ghichu, userID, nganhangID)
    values (_loaiPhong, _diachi, _giatien, _giatienTheoNguoi, _ngaydang, _sophong, _tiencoc, _tiencocTheoNguoi, _dientich, _hinhanh, _gioitinh, _truong, _nganh, _khoa
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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_themUser`(IN _username varchar(45), IN _password varchar(45)
, IN _hoten varchar(45), IN _email varchar(45), IN _facebook varchar(100), IN _ngayDK varchar(45),OUT _result int)
BEGIN
	set _result := (select count(*) from user where username = _username);
    if _facebook = '' then set _facebook = NULL;
    end if;
    
	if _result = 0 then
		set _result := (select count(*) from user where email = _email);
        if _result = 0 then
			insert into user(username, password, hoten, email, facebook, ngayDK)
			values (_username, _password, _hoten, _email, _facebook, _ngayDK);
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
/*!50003 DROP PROCEDURE IF EXISTS `mysp_thongkePTMoiTrenTongso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_thongkePTMoiTrenTongso`(IN _thang int, OUT _slPTMoi int, OUT _slPTCu int)
BEGIN
	select count(id) into _slPTMoi from phongtro where month(ngaydang) = _thang;   				
	select count(id) into _slPTCu from phongtro where month(ngaydang) < _thang;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_thongkePTTheoComment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_thongkePTTheoComment`(IN _thang int, IN _limit int)
BEGIN
	select * 
    from phongtro,
    (select count(*) as counter, phongtroID
    from comment
    group by phongtroID
    order by counter desc, phongtroID asc) as cmt
    where phongtro.id = cmt.phongtroID
    and month(ngaydang) <= _thang
    limit _limit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_thongkePTTheoDiachi` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_thongkePTTheoDiachi`(IN _loai int, IN _thang int,IN _limit int)
BEGIN
	if _loai = 1 then
		select concat(substring(diachi,
		char_length(substring_index(diachi, ' ', 1)) + 2,
		char_length(substring_index(diachi, ',',1))
		- 1 - char_length(substring_index(diachi, ' ', 1))),', ',
        substring(diachi, char_length(substring_index(diachi, ',',2)) + 3)) as value,
		count(*) as counter 
		from phongtro 
        where month(ngaydang) <= _thang
		group by concat(substring(diachi,
		char_length(substring_index(diachi, ' ', 1)) + 2,
		char_length(substring_index(diachi, ',',1))
		- 1 - char_length(substring_index(diachi, ' ', 1))),', ',
        substring(diachi, char_length(substring_index(diachi, ',',2)) + 3)) 
		order by counter desc
		limit _limit;
    else
		select substring(diachi,
		char_length(substring_index(diachi, ',', _loai - 1)) + 3) as value,
		count(*) as counter 
		from phongtro 
        where month(ngaydang) <= _thang
		group by SPLIT_STR(diachi,',', _loai) 
		order by counter desc
		limit _limit;
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_thongkePTTheoInput` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_thongkePTTheoInput`(IN _column varchar(45), IN _thang int, IN _limit int)
BEGIN
	set @sql = concat('select ', _column, ', count(*) as counter 
    from phongtro 
    where ',_column,' is not null
    and month(ngaydang) <= ',_thang,
    ' group by ', _column, ' 
    order by ', _column, ' asc 
    limit ', _limit);
    
    prepare stm from @sql;
    
	execute stm;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_thongkePTTheoLike` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_thongkePTTheoLike`(IN _thang int, IN _limit int)
BEGIN
	select * 
    from phongtro,
    (select count(*) as counter, phongtroID
    from user_like_phongtro
    group by phongtroID
    order by counter desc, phongtroID asc) as user_like
    where phongtro.id = user_like.phongtroID
    and month(ngaydang) <= _thang
    limit _limit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_thongkePTTheoThang` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_thongkePTTheoThang`(IN _thangBD int, IN _thangKT int)
BEGIN
	select count(id) as countPT, month(ngaydang) as thangDK
    from phongtro
    where month(ngaydang) <= _thangKT
    and month(ngaydang) >= _thangBD
    group by thangDK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_thongkePTTheoTienVaDientich` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_thongkePTTheoTienVaDientich`(IN _column varchar(45), IN _thang int,IN _limit int)
BEGIN
	
    set @sql = concat('select ', _column, ', count(*) as counter 
    from phongtro 
    where ',_column,' > 0
    and month(ngaydang) <= ',_thang,
    ' group by ', _column, ' 
    order by ', _column, ' asc 
    limit ', _limit);
    
    prepare stm from @sql;
    
	execute stm;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_thongkeUserMoiTrenTongso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_thongkeUserMoiTrenTongso`(IN _thang int, OUT _slUserMoi int, OUT _slUserCu int)
BEGIN
	select count(id) into _slUserMoi from user where month(ngayDK) = _thang and loai='user';   				
	select count(id) into _slUserCu from user where month(ngayDK) < _thang and loai='user';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_thongkeUserTheoThang` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_thongkeUserTheoThang`(IN _thangBD int, IN _thangKT int)
BEGIN
	select count(id) as countUser, month(ngayDK) as thangDK
    from user
    where month(ngayDK) <= _thangKT
    and month(ngayDK) >= _thangBD
	and loai='user'
    group by thangDK;
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
, IN _giatienTheoNguoi_min int, IN _giatienTheoNguoi_max int, IN _dientich_min int, IN _dientich_max int, IN _truong varchar(45)
, IN _nganh varchar(45), IN _khoa varchar(45), IN _gioitinh varchar(5), IN _wifi int, IN _chu int, IN _gioihan int, IN _loaiPhong int, IN _diachi mediumtext)
BEGIN
	if _giatien_max = 5000000 then
		set _giatien_max = (select max(giatien) from phongtro);
	end if;
	if _giatienTheoNguoi_max = 5000000 then
		set _giatienTheoNguoi_max = (select max(giatienTheoNguoi) from phongtro);
	end if;
    
    if _dientich_max = 20 then
		set _dientich_max = (select max(dientich) from phongtro);
	end if;
    
	select *
    from phongtro
    where (loaiPhong = _loaiPhong or _loaiPhong = 2)
    and giatien >= _giatien_min 
    and giatien <= _giatien_max
    and giatienTheoNguoi >= _giatienTheoNguoi_min 
    and giatienTheoNguoi <= _giatienTheoNguoi_max
    and dientich >= _dientich_min 
    and dientich <= _dientich_max
    and (diachi like concat('%',_diachi,'%') or _diachi = '')
    and (truong like concat('%',_truong,'%') or _truong = '')
    and (nganh like concat('%',_nganh,'%') or _nganh = '')
    and (khoa like concat('%',_khoa,'%') or _khoa = '')
    and (gioitinh = _gioitinh or _gioitinh = '')
    and (wifi = _wifi or _wifi = -1)
    and (chu = _chu or _chu = -1)
    and sophong > 0
    and duyet = 1
    and an = 0
    limit _gioihan;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mysp_xetduyetPT` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_xetduyetPT`(IN _phongtroID int, IN _duyet int)
BEGIN
	update phongtro
    set duyet = _duyet
    where id = _phongtroID;
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
    where commentID in (select id from comment where phongtroID = _id);

	delete from comment
    where phongtroID = _id;
    
	delete from user_like_phongtro
    where phongtroID = _id;
    
	delete from phongtro
    where id = _id;
    COMMIT;
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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mysp_xoaUser`(IN _id int)
BEGIN
	delete from comment
    where userID = _id;
    
    delete from phongtro
    where userID = _id;
    
    delete from user_like_comment
    where userID = _id;
    
    delete from user_like_phongtro
    where userID = _id;
    
	delete from user
    where id = _id;
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

-- Dump completed on 2016-12-09  1:06:09
