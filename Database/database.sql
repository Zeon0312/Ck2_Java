-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: login
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `username` varchar(40) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('admin','admin');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `masp` varchar(45) NOT NULL,
  `tensp` varchar(45) NOT NULL,
  `gia` double NOT NULL,
  `hinhanhsp` longtext NOT NULL,
  PRIMARY KEY (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES ('SP002','cafe sữa',18000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\caphesua.jpg'),('SP003','cafe dừa',20000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\caphedua.jpg'),('SP004','cafe muối',15000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\caphemuoi.jpg');
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `maSanPham` varchar(10) NOT NULL,
  `tenSanPham` varchar(45) NOT NULL,
  `giaSanPham` double NOT NULL,
  `hinhanhsp` longtext NOT NULL,
  PRIMARY KEY (`maSanPham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('SP001','Cafe đen',12000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\capheden.png'),('SP002','cafe sữa',18000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\caphesua.jpg'),('SP003','cafe dừa',20000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\caphedua.jpg'),('SP004','cafe muối',15000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\caphemuoi.jpg'),('SP005','cam vắt',30000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\Cam-vat.png'),('SP006','chocolate đá xay',30000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\socoladaxay.jpg'),('SP007','Kem vani',35000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\kemvani.jpg'),('SP008','Kem chocolate',35000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\kemsocola.jpg'),('SP009','Trà đào',25000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\tradao.png'),('SP010','Trà chanh',25000,'F:\\DoAnCoSo1\\DoAnCoSo\\src\\icon\\icon\\trachanh.jpeg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-03 19:32:55
