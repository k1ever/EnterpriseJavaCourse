CREATE DATABASE library;

use library;

CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50),
`author` varchar(50),
`holder` varchar(50),
`status` varchar(50),
  PRIMARY KEY (`id`)
);

INSERT INTO `library`.`books`(`title`, `author`)
VALUES('Core Java', 'Hostmann');

INSERT INTO `library`.`books`(`title`, `author`, `holder`, `status`)
VALUES('Spring for Dummies', 'Parkhomenko/Kravchenko', 'Sergei Voitenko', 'taken');

INSERT INTO `library`.`books`(`title`, `author`)
VALUES('We will teach you how to code!', 'Kravchenko/Parkhomenko');
