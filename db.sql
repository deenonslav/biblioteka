CREATE DATABASE IF NOT EXISTS `library_app` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */;

USE `library_app`;

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
-- Table structure for table `knjiga`
--

DROP TABLE IF EXISTS `knjiga`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `knjiga` (
  `knjiga_id` int unsigned NOT NULL AUTO_INCREMENT,
  `naslov` text COLLATE utf8mb3_unicode_ci NOT NULL,
  `autor` text COLLATE utf8mb3_unicode_ci NOT NULL,
  `isbn` varchar(20) COLLATE utf8mb3_unicode_ci NOT NULL,
  `godina_izdanja` year NOT NULL,
  `zanr` varchar(50) COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`knjiga_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knjiga`
--

LOCK TABLES `knjiga` WRITE;
/*!40000 ALTER TABLE `knjiga` DISABLE KEYS */;
INSERT INTO `knjiga` VALUES
  (1,'Na Drini cuprija','Ivo Andric','978-86-7436-123-4',1945,'Roman','2026-01-10 10:00:00',NULL,NULL),
  (2,'Mali Princ','Antoine de Saint-Exupery','978-86-521-0345-6',1943,'Bajka','2026-01-10 10:05:00',NULL,NULL),
  (3,'Harry Potter i kamen mudrosti','J.K. Rowling','978-86-7436-456-7',1997,'Fantazija','2026-01-10 10:10:00',NULL,NULL);
/*!40000 ALTER TABLE `knjiga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pozajmica`
--

DROP TABLE IF EXISTS `pozajmica`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pozajmica` (
  `pozajmica_id` int unsigned NOT NULL AUTO_INCREMENT,
  `knjiga_id` int unsigned NOT NULL,
  `ime_clana` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `datum_uzimanja` date NOT NULL,
  `datum_vracanja` date DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pozajmica_id`),
  KEY `fk_pozajmica_knjiga_idx` (`knjiga_id`),
  CONSTRAINT `fk_pozajmica_knjiga` FOREIGN KEY (`knjiga_id`) REFERENCES `knjiga` (`knjiga_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pozajmica`
--

LOCK TABLES `pozajmica` WRITE;
/*!40000 ALTER TABLE `pozajmica` DISABLE KEYS */;
INSERT INTO `pozajmica` VALUES
  (1,1,'Marko Markovic','2026-05-01',NULL,'2026-05-01 09:00:00'),
  (2,2,'Ana Jovanovic','2026-05-10','2026-05-20','2026-05-10 11:30:00');
/*!40000 ALTER TABLE `pozajmica` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-11 12:00:00
