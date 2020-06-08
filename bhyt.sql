-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bhyt
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bacsi`
--

DROP TABLE IF EXISTS `bacsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bacsi` (
  `idBS` varchar(10) NOT NULL,
  `hoTen` varchar(45) DEFAULT NULL,
  `tuoi` int DEFAULT NULL,
  `chuyenKhoa` varchar(45) DEFAULT NULL,
  `sdt` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idBS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bacsi`
--

LOCK TABLES `bacsi` WRITE;
/*!40000 ALTER TABLE `bacsi` DISABLE KEYS */;
INSERT INTO `bacsi` VALUES ('BS01','TRần Minh An',26,'Nội soi','0947516869'),('BS02','Nguyễn Trung Hiếu',30,'Răng, hàm, mặt','0345618358');
/*!40000 ALTER TABLE `bacsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benhvien`
--

DROP TABLE IF EXISTS `benhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benhvien` (
  `idBV` varchar(10) NOT NULL,
  `ten` varchar(45) NOT NULL,
  `diachi` varchar(45) NOT NULL,
  `tuyen` int NOT NULL,
  `hotline` varchar(45) NOT NULL,
  PRIMARY KEY (`idBV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benhvien`
--

LOCK TABLES `benhvien` WRITE;
/*!40000 ALTER TABLE `benhvien` DISABLE KEYS */;
INSERT INTO `benhvien` VALUES ('BV01','Bệnh viện Bạch Mai','Bạch Mai, Hà Nội',1,'084088888'),('BV02','Bệnh viện Việt Đức','Việt Đức, Hà Nội',1,'069066541'),('BV03','Bệnh viện quân y 103','Hà Đông, Hà Nội',2,'097944151'),('BV04','Bệnh viện mắt Quốc tế','Cầu Giấy, Hà Nội',1,'015614614');
/*!40000 ALTER TABLE `benhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cauhinh`
--

DROP TABLE IF EXISTS `cauhinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cauhinh` (
  `idCH` int NOT NULL AUTO_INCREMENT,
  `tuoi` int DEFAULT NULL,
  `quyenLoiDungTuyen1` double DEFAULT NULL,
  `quyenLoiDungTuyen2` double DEFAULT NULL,
  `quyenLoiDungTuyen3` double DEFAULT NULL,
  `ttTuyenHuyen` double DEFAULT NULL,
  `ttTuyenTinh` double DEFAULT NULL,
  `ttTuyenTrungUong` double DEFAULT NULL,
  `ngayApDung` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idCH`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cauhinh`
--

LOCK TABLES `cauhinh` WRITE;
/*!40000 ALTER TABLE `cauhinh` DISABLE KEYS */;
INSERT INTO `cauhinh` VALUES (0,6,100,90,80.5,65.5,50,45,'2019-12-14 03:22:00'),(1,10,90.5,85,80.5,60,55,40,'2020-02-03 08:30:00'),(7,11,100,90.5,85.5,70,60,50,'2020-06-07 14:45:00');
/*!40000 ALTER TABLE `cauhinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `idHistory` varchar(10) NOT NULL,
  `idBV` varchar(10) DEFAULT NULL,
  `ten` varchar(45) DEFAULT NULL,
  `diachi` varchar(45) DEFAULT NULL,
  `idBS` varchar(10) DEFAULT NULL,
  `hoTenBS` varchar(45) DEFAULT NULL,
  `idUser` varchar(10) DEFAULT NULL,
  `hoTenBN` varchar(45) DEFAULT NULL,
  `ngayKham` timestamp NULL DEFAULT NULL,
  `tongTienKham` double DEFAULT NULL,
  `tienPhaiTra` double DEFAULT NULL,
  `chuanDoan` varchar(45) DEFAULT NULL,
  `dungTuyen` tinyint DEFAULT NULL,
  PRIMARY KEY (`idHistory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES ('HTR01','BV01','Bệnh viện Bạch Mai','Bạch Mai, Hà Nội','BS01','Trần Minh An','BN01','Lê Văn Tuấn','2019-02-06 09:30:20',1000000,200000,'Viêm dạ dày',1),('HTR02','BV02','Bệnh viện Việt Đức','Việt Đức, Hà Nội','BS02','Nguyễn Trung Hiếu','BN01','Lê Văn Tuấn','2020-03-25 03:20:15',1500000,750000,'Đau răng',1);
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(10) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `hometown` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `nation` varchar(45) DEFAULT NULL,
  `isRelativeMartyrs` tinyint DEFAULT NULL,
  `isPoorFamily` tinyint DEFAULT NULL,
  `bhytID` varchar(45) DEFAULT NULL,
  `bhytRegisterPlace` varchar(45) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tuyenDK` int DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('BN01','Lê Văn Tuấn',22,'Sinh viên','Hà Đông, Hà Nội','Hà Đông, Hà Nội','1998-12-14','Kinh',0,0,'BH2020','Bạch Mai, Hà Nội','tuanlv','1412',1,1),('BN02','Nguyễn Minh An',5,'Học sinh','Long Biên, Hà Nội','Hà Đông, Hà Nội','2014-05-25','Kinh',0,0,'BHS2020','Long Biên, Hà Nội','tuanlv2','abc123',1,1),('BNAM','Admin',22,'Quản trị hệ thống','Hà Nội','Hà Nội','1998-10-10','Kinh',0,0,'AM2020','Việt Đức, Hà Nội','admin','admin',1,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-08 15:43:19
