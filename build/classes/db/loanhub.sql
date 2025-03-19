-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 19, 2025 at 02:46 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loanhub`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(20) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_contact` varchar(50) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_password` varchar(150) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_contact`, `u_username`, `u_password`, `u_type`, `u_status`) VALUES
(26, 'testtest', 'test', 'ttest', '09685744756', 'ttest', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'User', 'Active'),
(27, 'tessssssssss', 'te', 'te', '09586744634', 'te', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'User', 'Active'),
(28, 'John Lhoyde', 'Dakay', 'jl@gmail.com', '09685744567', 'jldak', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Admin', 'Active'),
(29, 'test', 'test', 'test', '09865433212', 'testtests', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Admin', 'Pending'),
(30, 'john', 'john', 'john', '09685744653', 'john', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'User', 'Active'),
(31, 'john lhoyde', 'dakay', 'jldakaygmail', '09786755847', 'jldakay', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Admin', 'Active'),
(32, 'jl', 'jl', 'jl', '09786755874', 'jl', 'FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=', 'Admin', 'Active'),
(35, 'mike', 'mike', 'mike', '09584755634', 'mike', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'User', 'Active'),
(36, 'michael', 'mike', 'mike@test.com', '09090909090', 'miketest', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Admin', 'Active'),
(37, 'jk', 'jk', 'jk', '09767544567', 'jk', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Admin', 'Active'),
(38, 'jk', 'jk', 'jkjk', '09876788978', 'jkjk', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'User', 'Active'),
(39, 'jm', 'jm', 'jm', '09876755678', 'jm', 'FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=', 'User', 'Active'),
(41, '11111', '1111', '1111', '09786855867', '1111', '7nmXbJOA1eM3/BwJXs6MjyL5HzBs7rFh+lH+zt4sS6E=', 'Admin', 'Pending'),
(42, '11111', '11111', '11111', '09876544345', '11111', 'U0pKjq/NhImvMjVtWnol+Ixwz+BEhTmnxClkwbiXo1k=', 'Admin', 'Pending'),
(43, '22222', '222222', 'jll@gmail.com', '09685766875', '22222', 'dusXqPsXWWeyFE8ctTbXKBSuR165VCh6rBtZIcxtkiA=', 'User', 'Pending');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
