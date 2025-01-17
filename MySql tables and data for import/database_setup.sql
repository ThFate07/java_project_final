-- MySQL dump 10.13  Distrib 8.4.3, for Win64 (x86_64)
--
-- Host: localhost    Database: bakery
-- ------------------------------------------------------
-- Server version	8.4.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `billing`
--

DROP TABLE IF EXISTS `billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billing` (
  `bId` int NOT NULL AUTO_INCREMENT COMMENT 'Unique id for each entry for the bill',
  `bNumber` varchar(45) DEFAULT NULL COMMENT 'Bill number',
  `bDate` date DEFAULT NULL COMMENT 'Biiling date',
  `bCustName` varchar(45) DEFAULT NULL,
  `item_iId` int NOT NULL,
  `iName` varchar(45) DEFAULT NULL,
  `iDescription` varchar(45) DEFAULT NULL COMMENT 'Description fo the item. This is a foreighn key form the item table',
  `bQty` int DEFAULT NULL COMMENT 'Qty of the item sold',
  `iSp` int DEFAULT NULL COMMENT 'Selling price of the item taken from the item table',
  `iCp` int DEFAULT NULL COMMENT 'Cost price of the item taken from the item table',
  `bOk` varchar(5) DEFAULT 'Yes' COMMENT 'Table to know if row is active or has been deleted\nYes means row is active.\nNo means row has been deleted.',
  `bAmount` int GENERATED ALWAYS AS ((`bQty` * `iSp`)) STORED COMMENT 'Amount of that particular item',
  `bProfit` int GENERATED ALWAYS AS (((`bQty` * `iSp`) - (`bQty` * `iCp`))) STORED,
  PRIMARY KEY (`bId`),
  KEY `billing_item_fk1_idx` (`item_iId`),
  CONSTRAINT `billing_item_fk1` FOREIGN KEY (`item_iId`) REFERENCES `item` (`iId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing`
--

LOCK TABLES `billing` WRITE;
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
INSERT INTO `billing` (`bId`, `bNumber`, `bDate`, `bCustName`, `item_iId`, `iName`, `iDescription`, `bQty`, `iSp`, `iCp`, `bOk`) VALUES (1,'RB/1/17-18','2017-10-01','Ashif Ali',1,'Black forest cake','Black forest cake small piece cake',10,15,10,'No'),(2,'RB/2/17-18','2017-10-02','Sk Wasim',2,'Dark chocolate cake','Dark chocolate small piece cake',5,22,11,'No'),(3,'RB/2/17-18','2017-10-02','Sk Wasim',5,'dfsdfdsf','dfghdfg',2,10,5,'No'),(4,'RB/2/17-18','2017-10-02','Sk Wasim',3,'Apple cake','Apple cake',5,20,12,'No'),(5,'RB/3/17-18','2017-10-20','Sk Shayeed',3,'Apple cake','Apple cake',5,20,12,'No'),(6,'RB/3/17-18','2017-10-20','Sk Shayeed',9,'Kaju Barfi','Bardis made from Kajus',2,25,5,'No'),(7,'RB/3/17-18','2017-10-20','Sk Shayeed',5,'Choco cup','Chocolate filled delight in a cup',6,10,5,'No'),(8,'RB/3/17-18','2017-10-20','Sk Shayeed',1,'Black forest cake','Black forest cake small piece cake',7,30,18,'No'),(10,'1','2024-10-30','Kunaal',3,'Apple cake','Apple cake',2,20,12,'No'),(11,'1','2024-10-30','Kunaal',2,'Dark chocolate cake','Dark chocolate small piece cake',2,22,11,'No'),(12,'1','2024-10-30','Kunaal',2,'Dark chocolate cake','Dark chocolate small piece cake',1,22,11,'No');
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `eId` int NOT NULL AUTO_INCREMENT COMMENT 'Unique Id for each employee in the employee table',
  `eName` varchar(45) DEFAULT NULL COMMENT 'Name of the employee',
  `eAddress` varchar(45) DEFAULT NULL COMMENT 'Address of the employee',
  `ePhoneNo` varchar(10) DEFAULT NULL COMMENT 'Phone No of the employee',
  `eDateOfBirth` date DEFAULT NULL COMMENT 'Dare of Birth of the employee',
  `eType` varchar(45) DEFAULT NULL COMMENT 'Type of the employee\n- Admin\n- Manager\n- Billing executive',
  `eImage` blob COMMENT 'Image of the employee',
  `eActive` varchar(3) DEFAULT 'Yes' COMMENT 'Whether the emplyee is still active. It is used to avoid deletring the details of the employee the have left the bakery',
  PRIMARY KEY (`eId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Sk Shayeed',NULL,NULL,NULL,NULL,NULL,'Yes'),(2,'Ashif Ali',NULL,NULL,NULL,NULL,NULL,'Yes'),(3,'Shagufta Ali',NULL,NULL,NULL,NULL,NULL,'Yes');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `inId` int NOT NULL AUTO_INCREMENT COMMENT 'Unique id for each entry of the inventory',
  `inDate` date DEFAULT NULL,
  `item_iId` int NOT NULL,
  `iniName` varchar(45) DEFAULT NULL,
  `inQty` int DEFAULT NULL COMMENT 'Quantity of the item added in the stock',
  `inActive` varchar(3) DEFAULT 'Yes',
  PRIMARY KEY (`inId`),
  KEY `inventory_item_fk1_idx` (`item_iId`),
  CONSTRAINT `inventory_item_fk1` FOREIGN KEY (`item_iId`) REFERENCES `item` (`iId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,'2017-10-03',3,'Apple cake',10,'Yes'),(2,'2017-10-03',2,'Dark chocolate cake',9,'Yes'),(3,'2017-10-03',8,'h',10,'Yes');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `iId` int NOT NULL AUTO_INCREMENT COMMENT 'Unique Id of the item',
  `iName` varchar(45) DEFAULT NULL COMMENT 'Name of the item',
  `iDescription` varchar(45) DEFAULT NULL COMMENT 'Description of the item',
  `iMinStock` int DEFAULT '5' COMMENT 'Minimum stock of item to be on the showboard. Used to check when more qty of the item is required',
  `iCp` int DEFAULT NULL COMMENT 'The expense for making the item (Cost price)',
  `iSp` int DEFAULT NULL COMMENT 'The selling price of the item',
  `iActive` varchar(3) DEFAULT 'Yes' COMMENT 'Whether the item is still active. It is used to avoid deletring the item when it is removed from the meny',
  PRIMARY KEY (`iId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Black forest cake','Black forest cake small piece cake',10,18,30,'Yes'),(2,'Dark chocolate cake','Dark chocolate small piece cake',10,11,22,'Yes'),(3,'Apple cake','Apple cake',10,12,20,'Yes'),(5,'Choco cup','Chocolate filled delight in a cup',5,5,10,'Yes'),(7,'g','w',1,1,1,'No'),(8,'h','h',1,1,1,'No'),(9,'Kaju Barfi','Bardis made from Kajus',10,5,25,'Yes');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uId` int NOT NULL AUTO_INCREMENT COMMENT 'Unique use id for each user',
  `uName` varchar(45) DEFAULT NULL COMMENT 'Username for login page of the user',
  `uPassword` varchar(45) DEFAULT NULL COMMENT 'Password for the login page of the user',
  `employee_eId` int NOT NULL,
  `uActive` varchar(3) DEFAULT 'Yes' COMMENT 'Whether the user is still active. It is used to avoid deletring the details of the user that have left the bakery',
  `uType` varchar(45) DEFAULT NULL COMMENT 'Type of the employee\n- Admin\n- Manager\n- Billing executive',
  PRIMARY KEY (`uId`),
  KEY `user_employee_fk_idx` (`employee_eId`),
  CONSTRAINT `user_employee_fk` FOREIGN KEY (`employee_eId`) REFERENCES `employee` (`eId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','Password',1,'Yes','Admin');
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

-- Dump completed on 2024-10-30  7:17:20
