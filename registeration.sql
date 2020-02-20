-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Feb 20, 2020 at 04:55 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `registeration`
--

CREATE TABLE `registeration` (
  `userName` varchar(10) NOT NULL,
  `password` varchar(15) NOT NULL,
  `admission` varchar(10) NOT NULL,
  `dob` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registeration`
--

INSERT INTO `registeration` (`userName`, `password`, `admission`, `dob`) VALUES
('Ankita', 'hello', 'developer', '1996-01-12 18:30:00'),
('samrat', 'hello', 'tester', '1996-01-04 18:30:00'),
('shreya', 'hello', 'deployer', '1996-07-05 18:30:00'),
('yuktee', 'hello', 'coder', '1996-07-05 18:30:00'),
('yuktee', 'hello', 'coder', '1996-07-05 18:30:00'),
('Yuktii', '12345', 'coder', '2020-02-04 18:30:00'),
('gggggg', 'hello', 'developer', '2020-02-11 18:30:00'),
('aaaaaa', 'hello', 'developer', '2012-12-11 18:30:00'),
('aaaaaa', 'hello', 'developer', '2012-12-11 18:30:00'),
('aaaaaa', 'hello', 'developer', '2012-12-11 18:30:00'),
('aaaaaa', 'hello', 'developer', '2012-12-11 18:30:00'),
('aaaaaa', 'hello', 'developer', '2012-12-11 18:30:00'),
('aaaaaa', 'hello', 'developer', '2012-12-11 18:30:00'),
('pppppp', 'hello', 'developer', '2000-12-11 18:30:00'),
('pppppp', 'hello', 'developer', '2000-12-11 18:30:00'),
('pppppp', 'hello', 'developer', '2000-12-11 18:30:00'),
('pppppp', 'hello', 'developer', '2000-12-11 18:30:00'),
('pppppp', 'hello', 'developer', '2000-12-11 18:30:00'),
('pppppp', 'hello', 'developer', '2000-12-11 18:30:00'),
('pppppp', 'hello', 'developer', '2000-12-11 18:30:00'),
('pppppp', 'hello', 'developer', '2000-12-11 18:30:00'),
('pppppp', 'hello', 'developer', '2000-12-11 18:30:00'),
('rrrrrr', 'hello', 'developer', '2000-12-11 18:30:00'),
('rrrrrr', 'hello', 'developer', '2000-12-11 18:30:00'),
('rrrrrr', 'hello', 'developer', '2000-12-11 18:30:00'),
('rrrrrr', 'hello', 'developer', '2000-12-11 18:30:00'),
('qqqqqq', 'hello', 'developer', '2020-02-06 18:30:00'),
('kkkkkk', 'hello', 'developer', '1996-12-11 18:30:00'),
('kkkkkk', 'hello', 'developer', '1996-12-11 18:30:00'),
('kkkkkk', 'hello', 'developer', '1996-12-11 18:30:00'),
('kkkkkk', 'hello', 'developer', '1996-12-11 18:30:00'),
('pppppp', 'hello', 'deployer', '1990-07-22 18:30:00'),
('pppppp', 'hello', 'deployer', '1990-07-22 18:30:00'),
('pppppp', 'hello', 'deployer', '1990-07-22 18:30:00'),
('hhhhhh', 'hello', 'developer', '2000-12-29 18:30:00'),
('pppppp', 'hello', 'deployer', '1990-07-22 18:30:00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
