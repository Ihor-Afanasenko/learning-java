CREATE DATABASE  IF NOT EXISTS `video_library`;
USE `video_library`;

DROP TABLE IF EXISTS `actor`;

CREATE TABLE `actor` (
  `actor_id` int(11) NOT NULL AUTO_INCREMENT,
  `actor_name` varchar(45) NOT NULL,
  `date_of_birth` date NOT NULL,
  PRIMARY KEY (`actor_id`),
  UNIQUE KEY `actor_id_UNIQUE` (`actor_id`),
  KEY `1_idx` (`actor_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

LOCK TABLES `actor` WRITE;
INSERT INTO `actor` VALUES (1,'Antonio Banderas','1960-09-10'),(2,'Bradley Cooper','1975-01-05'),(3,'Chadwick Boseman','1977-11-29'),(4,'Clint Eastwood','1930-05-31'),(5,'Iben Hjejle','1971-03-22'),(6,'James McAvoy','1979-04-21'),(7,'Will Smith','1968-10-25'),(8,'Jennifer Lawrence','1990-09-15'),(9,'Michael Fassbender','1977-04-02'),(10,'Evan Peters','1987-01-20');
UNLOCK TABLES;

DROP TABLE IF EXISTS `director`;

CREATE TABLE `director` (
  `director_id` int(11) NOT NULL AUTO_INCREMENT,
  `director_name` varchar(45) NOT NULL,
  `date_of_birth` date NOT NULL,
  PRIMARY KEY (`director_id`,`director_name`),
  UNIQUE KEY `director_id_UNIQUE` (`director_id`),
  KEY `1_idx` (`director_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

LOCK TABLES `director` WRITE;
INSERT INTO `director` VALUES (1,'Bryan Singer','1965-09-17'),(2,'Clint Eastwood','1930-05-31'),(3,'Kenneth Biller','1980-01-01'),(4,'Kenneth Kainz','1970-05-22'),(5,'Peter Landesman','1965-01-03'),(6,'Ryan Coogler','1986-05-23'),(7,'Natasha Arthy','1969-05-23'),(8,'James Hawes','1970-08-27'),(9,'Kevin Hooks','1958-09-19'),(10,'Francis Lawrence','1971-03-26');
UNLOCK TABLES;

DROP TABLE IF EXISTS `film`;

CREATE TABLE `film` (
  `film_id` int(11) NOT NULL,
  `title` varchar(60) DEFAULT NULL,
  `release_year` year(4) NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`film_id`),
  KEY `1_idx` (`film_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `film` WRITE;
INSERT INTO `film` VALUES (1,'The Rain',2018,'Denmark'),(2,'Black Panther',2018,'USA'),(3,'Genius: Picasso',2018,'USA'),(4,'X-Men: Apocalypse',2016,'UK'),(5,'Concussion',2015,'USA'),(6,'Million Dollar Baby',2004,'USA'),(7,'American Sniper',2014,'USA'),(8,'I Am Legend',2007,'USA'),(9,'Delete Film',1995,'UK');
UNLOCK TABLES;

DROP TABLE IF EXISTS `film_actor`;
CREATE TABLE `film_actor` (
  `film_id` int(11) NOT NULL AUTO_INCREMENT,
  `actor_id` int(11) NOT NULL,
  PRIMARY KEY (`film_id`,`actor_id`),
  KEY `1_idx` (`actor_id`),
  CONSTRAINT `film_actor_to_actor` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`actor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `film_actor_to_film` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

LOCK TABLES `film_actor` WRITE;
INSERT INTO `film_actor` VALUES (3,1),(7,2),(2,3),(6,4),(1,5),(4,6),(5,7),(8,7),(4,8),(4,9),(4,10);
UNLOCK TABLES;

DROP TABLE IF EXISTS `film_director`;
CREATE TABLE `film_director` (
  `director_id` int(11) NOT NULL,
  `film_id` int(11) NOT NULL,
  PRIMARY KEY (`director_id`,`film_id`),
  KEY `1_idx` (`film_id`),
  CONSTRAINT `film_director_to_director` FOREIGN KEY (`director_id`) REFERENCES `director` (`director_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `film_director_to_film` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `film_director` WRITE;
INSERT INTO `film_director` VALUES (4,1),(7,1),(6,2),(3,3),(8,3),(9,3),(1,4),(5,5),(2,6),(2,7),(10,8);
UNLOCK TABLES;

-- Dump completed on 2018-05-14 19:36:55
