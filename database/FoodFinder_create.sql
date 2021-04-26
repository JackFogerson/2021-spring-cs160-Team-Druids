DROP TABLE IF EXISTS `FoodFinder`.`friendship_request`;
DROP TABLE IF EXISTS `FoodFinder`.`friendships`;
DROP TABLE IF EXISTS `FoodFinder`.`user_party`;
DROP TABLE IF EXISTS `FoodFinder`.`restaurant_owners`;
DROP TABLE IF EXISTS `FoodFinder`.`favorites`;
DROP TABLE IF EXISTS `FoodFinder`.`reviews`;
DROP TABLE IF EXISTS `FoodFinder`.`restaurants`;
DROP TABLE IF EXISTS `FoodFinder`.`party`;
DROP TABLE IF EXISTS `FoodFinder`.`users`;

CREATE TABLE `FoodFinder`.`users` (
   `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `first_name` varchar(255) NOT NULL,
   `last_name` varchar(255) NOT NULL,
   `username` varchar(255) NOT NULL,
   `email` varchar(50) NOT NULL,
   `password` varchar(255) NOT NULL,
   `location` varchar(100) DEFAULT NULL,
   `budget` varchar(100) DEFAULT NULL,
   `dob` date DEFAULT NULL,
   `favorite_cusine` varchar(100) DEFAULT NULL,
   `pic_url` varchar(255) DEFAULT NULL,
   UNIQUE KEY `username_UNIQUE` (`username`),
   UNIQUE KEY `email_UNIQUE` (`email`)
);
 
CREATE TABLE `FoodFinder`.`party` (
   `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `party_name` varchar(100) NOT NULL,
   `party_count` int DEFAULT 1,
   `date_created` datetime NOT NULL
);
 
CREATE TABLE `FoodFinder`.`restaurants` (
   `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `restaurant_name` varchar(255) NOT NULL,
   `street` varchar(100) NOT NULL,
   `city` varchar(100) NOT NULL,
   `state` varchar(14) NOT NULL,
   `cuisine` varchar(100) NOT NULL,
   `budget` varchar(100) DEFAULT NULL,
   `pic_url` varchar(255) DEFAULT NULL
);

CREATE TABLE `FoodFinder`.`reviews` (
   `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `user_id` int NOT NULL,
   `restaurant_id` int NOT NULL,
   `title` varchar(100) NOT NULL,
   `body` text(65536) NOT NULL,
   `stars` int NOT NULL,
   CONSTRAINT `ruid`
     FOREIGN KEY (`user_id`)
     REFERENCES `FoodFinder`.`users` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE,
   CONSTRAINT `rrid`
     FOREIGN KEY (`restaurant_id`)
     REFERENCES `FoodFinder`.`restaurants` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);

CREATE TABLE `FoodFinder`.`favorites` (
   `user_id` int NOT NULL,
   `restaurant_id` int NOT NULL,
   `date_added` datetime,
   CONSTRAINT `favuid`
     FOREIGN KEY (`user_id`)
     REFERENCES `FoodFinder`.`users` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE,
   CONSTRAINT `favrid`
     FOREIGN KEY (`restaurant_id`)
     REFERENCES `FoodFinder`.`restaurants` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);
 
CREATE TABLE `FoodFinder`.`user_party` (
   `user_id` INT NOT NULL,
   `party_id` INT NOT NULL,
   CONSTRAINT `upuid`
     FOREIGN KEY (`user_id`)
     REFERENCES `FoodFinder`.`users` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE,
   CONSTRAINT `uppid`
     FOREIGN KEY (`party_id`)
     REFERENCES `FoodFinder`.`party` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);

CREATE TABLE `FoodFinder`.`restaurant_owners` (
   `user_id` INT NOT NULL,
   `restaurant_id` INT NOT NULL,
   CONSTRAINT `rouid`
     FOREIGN KEY (`user_id`)
     REFERENCES `FoodFinder`.`users` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE,
   CONSTRAINT `rorid`
     FOREIGN KEY (`restaurant_id`)
     REFERENCES `FoodFinder`.`restaurants` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);

CREATE TABLE `FoodFinder`.`friendships` (
   `user_id` int NOT NULL,
   `follower_id` int NOT NULL,
   `date_followed` datetime NOT NULL,
   INDEX `id_idx` (`user_id` ASC, `follower_id` ASC) VISIBLE,
   CONSTRAINT `fuid`
     FOREIGN KEY (`user_id`)
     REFERENCES `FoodFinder`.`users` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE,
   CONSTRAINT `ffid`
     FOREIGN KEY (`follower_id`)
     REFERENCES `FoodFinder`.`users` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);

CREATE TABLE `FoodFinder`.`friendship_request` (
   `user_id` int NOT NULL,
   `follower_id` int NOT NULL,
   `date_requested` datetime NOT NULL,
   INDEX `id_idx` (`user_id` ASC, `follower_id` ASC) VISIBLE,
   CONSTRAINT `fruid`
     FOREIGN KEY (`user_id`)
     REFERENCES `FoodFinder`.`users` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE,
   CONSTRAINT `frfid`
     FOREIGN KEY (`follower_id`)
     REFERENCES `FoodFinder`.`users` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);