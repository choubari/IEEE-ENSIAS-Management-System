-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 30, 2020 at 02:17 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ieee ensias`
--

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
CREATE TABLE IF NOT EXISTS `event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `event_name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `event_description` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `event_date` date NOT NULL,
  `event_time` time NOT NULL,
  `event_guests` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `event_flyer` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `event_status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `datacenter`
--

DROP TABLE IF EXISTS `datacenter`;
CREATE TABLE IF NOT EXISTS `datacenter` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `file_path` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `file_date` date NOT NULL,
  `file_time` time NOT NULL,
  `file_ownerid` int(11) NOT NULL,
  FOREIGN KEY (`file_ownerid`) REFERENCES member(`member_id`),
  PRIMARY KEY (`file_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
CREATE TABLE IF NOT EXISTS `chat` (
  `chat_id` int(11) NOT NULL AUTO_INCREMENT,
  `chat_from` int(11) NOT NULL,
  `chat_to` int(11) NOT NULL,
  `chat_content` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `chat_date` date NOT NULL,
  `chat_time` time NOT NULL,
  FOREIGN KEY (`chat_from`) REFERENCES member(`member_id`),
  FOREIGN KEY (`chat_to`) REFERENCES member(`member_id`),
  PRIMARY KEY (`chat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- --------------------------------------------------------

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_first_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `member_last_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `member_email` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `member_tele` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `member_promo` year(4) NOT NULL,
  `member_branch` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `member_cellule` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `member_role` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `member_password` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE IF NOT EXISTS `task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `task_description` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `task_deadline` date NOT NULL,
  `task_status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `task_responsible_id` int(11) NOT NULL,
  `task_creator_id` int(11) NOT NULL,
  FOREIGN KEY (`task_responsible_id`) REFERENCES member(`member_id`),
  FOREIGN KEY (`task_creator_id`) REFERENCES member(`member_id`),
  PRIMARY KEY (`task_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
COMMIT;
-- --------------------------------------------------------

--
-- Table structure for table `contactus`
--

DROP TABLE IF EXISTS `contactus`;
CREATE TABLE IF NOT EXISTS `contactus` (
  `contactus_id` int(11) NOT NULL AUTO_INCREMENT,
  `contactus_name` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contactus_email` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contactus_subject` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contactus_message` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`contactus_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
COMMIT;
-- --------------------------------------------------------

--
-- Table structure for table `newsletter`
--

DROP TABLE IF EXISTS `newsletter`;
CREATE TABLE IF NOT EXISTS `newsletter` (
  `newsletter_id` int(11) NOT NULL AUTO_INCREMENT,
  `newsletter_name` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `newsletter_email` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`newsletter_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
