-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: topquiz
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `questionbank`
--

DROP TABLE IF EXISTS `questionbank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questionbank` (
  `questionbankId` int NOT NULL,
  `QuestionBankName` varchar(20) DEFAULT NULL,
  `difficultyLevel` varchar(20) DEFAULT NULL,
  `qasetid` int DEFAULT NULL,
  `ID` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionbank`
--

LOCK TABLES `questionbank` WRITE;
/*!40000 ALTER TABLE `questionbank` DISABLE KEYS */;
INSERT INTO `questionbank` VALUES (1,'questionbank1','easy',1,1),(1,'questionbank1','easy',2,2),(1,'questionbank1','easy',3,3),(1,'questionbank1','easy',4,4),(1,'questionbank1','easy',5,5),(1,'questionbank1','easy',6,6),(1,'questionbank1','easy',7,7),(1,'questionbank1','easy',8,8),(1,'questionbank1','easy',9,9),(1,'questionbank1','easy',10,10),(1,'questionbank1','easy',11,11),(1,'questionbank1','easy',12,12),(1,'questionbank1','easy',13,13),(1,'questionbank1','easy',14,14),(1,'questionbank1','easy',15,15),(1,'questionbank1','easy',16,16),(1,'questionbank1','easy',17,17),(1,'questionbank1','easy',18,18),(1,'questionbank1','easy',19,19),(1,'questionbank1','easy',20,20),(1,'questionbank1','easy',21,21),(1,'questionbank1','easy',22,22),(1,'questionbank1','easy',23,23),(1,'questionbank1','easy',24,24),(1,'questionbank1','easy',25,25),(2,'questionbank2','medium',1,26),(2,'questionbank2','medium',2,27),(2,'questionbank2','medium',3,28),(2,'questionbank2','medium',4,29),(2,'questionbank2','medium',5,30),(2,'questionbank2','medium',6,31),(2,'questionbank2','medium',7,32),(2,'questionbank2','medium',8,33),(2,'questionbank2','medium',9,34),(2,'questionbank2','medium',10,35),(2,'questionbank2','medium',11,36),(2,'questionbank2','medium',12,37),(2,'questionbank2','medium',13,38),(2,'questionbank2','medium',14,39),(2,'questionbank2','medium',15,40),(2,'questionbank2','medium',16,41),(2,'questionbank2','medium',17,42),(2,'questionbank2','medium',18,43),(2,'questionbank2','medium',19,44),(2,'questionbank2','medium',20,45),(2,'questionbank2','medium',21,46),(2,'questionbank2','medium',22,47),(2,'questionbank2','medium',23,48),(2,'questionbank2','medium',24,49),(2,'questionbank2','medium',25,50),(4,'questionbank1','easy',1,51),(4,'questionbank1','easy',2,52),(4,'questionbank1','easy',3,53),(4,'questionbank1','easy',4,54),(4,'questionbank1','easy',5,55),(4,'questionbank1','easy',6,56),(4,'questionbank1','easy',7,57),(4,'questionbank1','easy',8,58),(4,'questionbank1','easy',9,59),(4,'questionbank1','easy',10,60),(4,'questionbank1','easy',11,61),(4,'questionbank1','easy',12,62),(4,'questionbank1','easy',13,63),(4,'questionbank1','easy',14,64),(4,'questionbank1','easy',15,65),(4,'questionbank1','easy',16,66),(4,'questionbank1','easy',17,67),(4,'questionbank1','easy',18,68),(4,'questionbank1','easy',19,69),(4,'questionbank1','easy',20,70),(4,'questionbank1','easy',21,71),(4,'questionbank1','easy',22,72),(4,'questionbank1','easy',23,73),(4,'questionbank1','easy',24,74),(4,'questionbank1','easy',25,75);
/*!40000 ALTER TABLE `questionbank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `Id` int NOT NULL,
  `QuestionNumber` int DEFAULT NULL,
  `Question` varchar(100) DEFAULT NULL,
  `AnswerChoice1` varchar(20) DEFAULT NULL,
  `AnswerChoice2` varchar(20) DEFAULT NULL,
  `AnswerChoice3` varchar(20) DEFAULT NULL,
  `AnswerChoice4` varchar(20) DEFAULT NULL,
  `CorrectAnswer` varchar(20) DEFAULT NULL,
  `points` int DEFAULT NULL,
  `QuestionType` varchar(20) DEFAULT NULL,
  `ImageFile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,1,'What force from the Sun pulls on the Earth and keeps it in orbit?','Gravity','Friction','Balance','Inertia','Gravity',3,'MCQ',NULL),(2,2,'Which two are about the same size?','Earth and Mercury','Earth and Venus','Venus and Mars','Venus and Jupiter','Earth and Venus',3,'MCQ',NULL),(3,3,'When a Full Moon causes the ocean to rise, what force is at work?','Magnetic','Gravity','Drag','Friction','Gravity',3,'MCQ',NULL),(4,4,'Shooting stars are actually what?','Comets','Stars','Meteors','Satelites','Meteors',3,'MCQ',NULL),(5,5,'What do we call the Sun and all the space objects in orbit around it?','The Galaxy','The universe','The solar system','Milky Way','The solar system',3,'MCQ',NULL),(6,6,'How long does it take Earth to rotate once on its axis?','24 Hours','A month','A year','6 months','24 Hours',3,'MCQ',NULL),(7,7,'Name the planet closest to the Sun.','Earth','Mars','Venus','Mercury','Mercury',3,'MCQ',NULL),(8,8,'What object orbiting the Sun used to be considered one of our planets?','Venus','Neptune','Pluto','Mercury','Pluto',3,'MCQ',NULL),(9,9,'Does the Earth rotate in an Eastward or Westward direction?',NULL,NULL,NULL,NULL,'Eastward',3,'FillInTheBlanks',NULL),(10,10,'How many colors are in the visible spectrum of white light?','Seven','Eight','Nine','Six','Seven',3,'MCQ',NULL),(11,11,'Oceans cover about three-fourths of the Earth\'s surface.  True or false?','True','False',NULL,NULL,'True',3,'TF',NULL),(12,12,'At midnight the water in an ocean stops moving.  True or false','True','False',NULL,NULL,'False',3,'TF',NULL),(13,13,'What is the word for melted rock deep inside the earth?','Cement','Clay','Magma','Pumice','Magma',3,'MCQ',NULL),(14,14,'About how long does it take the Moon to circle the Earth?','About a year','About 28 days','About a day','About 6 day','About 28 day',3,'MCQ',NULL),(15,15,'Light can travel through all matter.  True or false?','True','False',NULL,NULL,'False',3,'TF',NULL),(16,16,'What do we call deep holes in the moon?','Craters','Boulders','Black Hole','Pits','Craters',3,'MCQ',NULL),(17,17,'What force from the Sun pulls on the earth and keeps it in orbit?','Drag','Lever','Magnetic','Gravity','Gravity',3,'MCQ',NULL),(18,18,'What do we call man-made objects that orbit Earth and photograph the weather?','Shuttles','Space Stations','Labs','Weather satellites','Weather satellites',3,'MCQ',NULL),(19,19,'What is a meteor called when it falls to Earth?','Shooting Star','A meteorite','A comet','A shower','A meteorite',3,'MCQ',NULL),(20,20,'Our galaxy is known as what?','Gems','Kit Kat','Mars','Milky Way','Milky Way',3,'MCQ',NULL),(21,21,'Light can travel through all matter.  True or false?','True','False',NULL,NULL,'False',3,'TF',NULL),(22,22,'What do we call deep holes in the moon?','Craters','Boulders','Black Hole','Pits','Craters',3,'MCQ',NULL),(23,23,'What force from the Sun pulls on the earth and keeps it in orbit?','Drag','Lever','Magnetic','Gravity','Gravity',3,'MCQ',NULL),(24,24,'What do we call man-made objects that orbit Earth and photograph the weather?','Shuttles','Space Stations','Labs','Weather satellites','Weather satellites',3,'MCQ',NULL),(25,25,'What Nebula is this?','Cats Eye Nebula','Eye of Gold Nebula','Orion','Pegasus','Cats Eye Nebula',3,'Image','Picture.png');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz` (
  `quizId` int NOT NULL,
  `quizname` varchar(20) DEFAULT NULL,
  `quizscore` int DEFAULT NULL,
  `QuestionBankId` int DEFAULT NULL,
  `ID` int NOT NULL AUTO_INCREMENT,
  `time_limit` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (1,'SpaceQuiz',75,1,1,30),(1,'SpaceQuiz',75,2,2,25),(1,'SpaceQuiz',75,3,3,25),(2,'WaterQuiz',75,1,4,25),(2,'WaterQuiz',75,2,5,25),(2,'WaterQuiz',75,3,6,25);
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz_user`
--

DROP TABLE IF EXISTS `quiz_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz_user` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Quiz_Id` int DEFAULT NULL,
  `User_id` int DEFAULT NULL,
  `Total_correct` int DEFAULT NULL,
  `Total_Wrong` int DEFAULT NULL,
  `Total_NA` int DEFAULT NULL,
  `User_score` int DEFAULT NULL,
  `quizname` varchar(30) DEFAULT NULL,
  `difficultyLevel` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_user`
--

LOCK TABLES `quiz_user` WRITE;
/*!40000 ALTER TABLE `quiz_user` DISABLE KEYS */;
INSERT INTO `quiz_user` VALUES (1,1,3,20,2,3,60,'spacequiz','easy'),(2,1,3,15,5,5,45,'spacequiz','hard'),(3,1,4,20,2,3,60,'spacequiz','easy'),(4,2,3,20,2,3,60,'waterquiz','easy'),(5,1,2,0,0,0,0,'SpaceQuiz','EASY'),(6,1,9,5,20,0,15,'SpaceQuiz','EASY');
/*!40000 ALTER TABLE `quiz_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) DEFAULT NULL,
  `isAdmin` tinyint DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Sam',1),(2,'Nithya',1),(3,'Teeny',0),(4,'Rachel',0),(5,'Chase',0),(6,'Will',0),(7,'Roger',0),(8,'Willy',0),(9,'Nitya',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-14 20:14:55
