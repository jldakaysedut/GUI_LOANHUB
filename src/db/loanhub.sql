-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2025 at 12:56 PM
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
-- Table structure for table `tbl_apply`
--

CREATE TABLE `tbl_apply` (
  `a_id` int(20) NOT NULL,
  `u_id` int(20) NOT NULL,
  `p_id` int(20) NOT NULL,
  `a_fname` varchar(50) NOT NULL,
  `a_lname` varchar(50) NOT NULL,
  `a_contact` varchar(50) NOT NULL,
  `amount` varchar(50) NOT NULL,
  `a_monthly_interest` varchar(100) NOT NULL,
  `a_interest` varchar(100) NOT NULL,
  `a_overall_amount` varchar(100) NOT NULL,
  `a_term` varchar(50) NOT NULL,
  `a_monthly_principal` varchar(100) NOT NULL,
  `a_monthly_payment` varchar(100) NOT NULL,
  `a_annual` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_apply`
--

INSERT INTO `tbl_apply` (`a_id`, `u_id`, `p_id`, `a_fname`, `a_lname`, `a_contact`, `amount`, `a_monthly_interest`, `a_interest`, `a_overall_amount`, `a_term`, `a_monthly_principal`, `a_monthly_payment`, `a_annual`, `date`, `status`) VALUES
(2042, 83, 1061, 'Lucel', 'Lemoran', '09090909889', '5000', '', '', '', '4', '', '', '24000', '05-16-2025', 'Approved'),
(2043, 83, 1061, 'Judy', 'Somera', '09090988909', '20000', '', '', '', '8', '', '', '40000', '05-16-2025', 'Approved'),
(2044, 83, 1061, 'mike', 'bustamante', '09685766565', '13000', '', '', '', '3', '', '', '500000', '05-16-2025', 'Pending'),
(2045, 83, 1061, 'sam', 'hady', '09554543433', '4000', '', '', '', '12', '', '', '12000', '05-21-2025', 'Pending'),
(2050, 83, 1061, 'qq', 'qq', '09090909090', '600000', '1000.0', '12000.0', '612000.0', '12', '50000.0', '51000.0', '80000', '05-21-2025', 'Pending'),
(2051, 83, 1060, 'John', 'Vincent', '09685755945', '560000', '777.7777777777778', '28000.0', '588000.0', '36', '15555.555555555555', '16333.333333333334', '120000', '05-21-2025', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logs`
--

CREATE TABLE `tbl_logs` (
  `l_id` int(20) NOT NULL,
  `u_id` int(20) NOT NULL,
  `action` varchar(50) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_logs`
--

INSERT INTO `tbl_logs` (`l_id`, `u_id`, `action`, `date`) VALUES
(522, 83, 'Logged in', '2025-05-14 19:42:40'),
(523, 83, 'Added Application: ID 2029', '2025-05-14 19:43:05'),
(524, 82, 'Logged in', '2025-05-14 19:43:20'),
(525, 83, 'Logged in', '2025-05-14 19:46:49'),
(526, 83, 'Updated Application for Product ID: 1051', '2025-05-14 19:46:57'),
(527, 83, 'Updated Application for Product ID: 1051', '2025-05-14 19:47:28'),
(528, 82, 'Logged in', '2025-05-14 19:47:40'),
(529, 83, 'Logged in', '2025-05-14 19:49:57'),
(530, 83, 'Deleted application: ID 2029', '2025-05-14 19:50:26'),
(531, 83, 'Deleted application: ID 2028', '2025-05-14 19:50:31'),
(532, 83, 'Deleted application: ID 2027', '2025-05-14 19:50:35'),
(533, 83, 'Added Application: ID 2030', '2025-05-14 19:51:17'),
(534, 83, 'Update Application ID: 1049', '2025-05-14 19:51:25'),
(535, 83, 'Logged in', '2025-05-14 19:52:48'),
(536, 83, 'Logged in', '2025-05-14 19:54:18'),
(537, 83, 'Logged in', '2025-05-14 19:59:29'),
(538, 83, 'Logged in', '2025-05-14 20:02:51'),
(539, 83, 'Logged in', '2025-05-14 20:13:52'),
(540, 83, 'Logged in', '2025-05-14 20:20:04'),
(541, 83, 'Logged in', '2025-05-14 20:20:40'),
(542, 83, 'Logged in', '2025-05-14 20:23:11'),
(543, 83, 'Logged in', '2025-05-14 20:23:39'),
(544, 82, 'Logged in', '2025-05-14 20:26:01'),
(545, 82, 'Updated plan: ID 1050', '2025-05-14 20:26:44'),
(546, 82, 'Updated plan: ID 1050', '2025-05-14 20:26:53'),
(547, 83, 'Logged in', '2025-05-14 20:27:19'),
(548, 83, 'Deleted application: ID 2035', '2025-05-14 20:27:28'),
(549, 83, 'Logged in', '2025-05-14 20:32:42'),
(550, 83, 'Added Application: ID 2037', '2025-05-14 20:32:58'),
(551, 83, 'Added Application: ID 2039', '2025-05-14 20:33:42'),
(552, 83, 'Updated Application: ID 2038', '2025-05-14 20:34:37'),
(553, 83, 'Deleted application: ID 2039', '2025-05-14 20:34:45'),
(554, 82, 'Logged in', '2025-05-14 20:35:03'),
(555, 82, 'Logged out', '2025-05-14 20:35:23'),
(556, 83, 'Logged in', '2025-05-14 20:37:09'),
(557, 83, 'Updated Application: ID 2038', '2025-05-14 20:37:17'),
(558, 83, 'Logged in', '2025-05-14 20:38:49'),
(559, 83, 'Added application ID 1050', '2025-05-14 20:39:05'),
(560, 83, 'Deleted application: ID 2041', '2025-05-14 20:39:21'),
(561, 83, 'Deleted application: ID 2040', '2025-05-14 20:39:26'),
(562, 83, 'Deleted application: ID 2038', '2025-05-14 20:39:30'),
(563, 82, 'Logged in', '2025-05-14 20:39:42'),
(564, 82, 'Logged in', '2025-05-14 20:40:42'),
(565, 82, 'Deleted loan type: ID 1051', '2025-05-14 20:41:05'),
(566, 82, 'Deleted loan type: ID 1051', '2025-05-14 20:41:10'),
(567, 82, 'Updated plan: ID 1049', '2025-05-14 20:42:05'),
(568, 82, 'Updated plan: ID 1049', '2025-05-14 20:42:22'),
(569, 82, 'Logged in', '2025-05-14 20:52:48'),
(570, 83, 'Logged in', '2025-05-14 20:55:31'),
(571, 82, 'Logged in', '2025-05-14 20:55:42'),
(572, 82, 'Updated plan: ID 1051', '2025-05-14 20:56:27'),
(573, 82, 'Updated plan: ID 1051', '2025-05-14 20:56:36'),
(574, 82, 'Deleted loan type: ID 1051', '2025-05-14 20:56:52'),
(575, 82, 'Logged in', '2025-05-14 21:32:58'),
(576, 82, 'Logged out', '2025-05-14 21:33:11'),
(577, 83, 'Logged in', '2025-05-14 21:33:16'),
(578, 82, 'Logged in', '2025-05-14 21:39:03'),
(579, 82, 'Added loan type: ID 1057', '2025-05-14 21:39:55'),
(580, 82, 'Deleted loan type: ID 1057', '2025-05-14 21:40:09'),
(581, 82, 'Added loan type: ID 1058', '2025-05-14 21:41:00'),
(582, 82, 'Updated plan: ID 1058', '2025-05-14 21:41:22'),
(583, 83, 'Logged in', '2025-05-14 21:44:53'),
(584, 82, 'Logged in', '2025-05-14 21:45:38'),
(585, 82, 'Added loan type: ID 1059', '2025-05-14 21:46:11'),
(586, 82, 'Updated plan: ID 1059', '2025-05-14 21:46:28'),
(587, 82, 'Logged in', '2025-05-14 21:59:25'),
(588, 82, 'Logged in', '2025-05-16 10:18:45'),
(589, 82, 'Updated user: ID 84', '2025-05-16 10:20:08'),
(590, 82, 'Updated user: ID 83', '2025-05-16 10:21:30'),
(591, 82, 'Deleted user: ID 90', '2025-05-16 10:22:04'),
(592, 82, 'Added new user: ID 91', '2025-05-16 10:24:01'),
(593, 82, 'Deleted loan type: ID 1059', '2025-05-16 10:24:56'),
(594, 82, 'Added loan type: ID 1060', '2025-05-16 10:26:15'),
(595, 82, 'Added loan type: ID 1061', '2025-05-16 10:27:38'),
(596, 82, 'Logged out', '2025-05-16 10:28:06'),
(597, 91, 'Logged in', '2025-05-16 10:28:16'),
(598, 91, 'Updated user: ID 82', '2025-05-16 10:29:06'),
(599, 91, 'Logged out', '2025-05-16 10:29:10'),
(600, 83, 'Logged in', '2025-05-16 10:29:19'),
(601, 83, 'Added application ID 1061', '2025-05-16 10:30:06'),
(602, 83, 'Added application ID 1061', '2025-05-16 10:30:54'),
(603, 82, 'Logged in', '2025-05-16 10:32:41'),
(604, 82, 'Logged out', '2025-05-16 10:33:20'),
(605, 82, 'Logged in', '2025-05-16 10:36:16'),
(606, 82, 'Logged in', '2025-05-16 10:42:04'),
(607, 82, 'Logged in', '2025-05-16 10:43:45'),
(608, 82, 'Denied Application ID: 2042', '2025-05-16 10:43:59'),
(609, 82, 'Logged in', '2025-05-16 10:44:11'),
(610, 82, 'Logged out', '2025-05-16 10:44:55'),
(611, 82, 'Logged in', '2025-05-16 10:45:06'),
(612, 82, 'Approved Application ID: 2042', '2025-05-16 10:45:17'),
(613, 82, 'Logged out', '2025-05-16 10:45:47'),
(614, 82, 'Logged in', '2025-05-16 11:27:58'),
(615, 93, 'Logged in', '2025-05-16 13:13:21'),
(616, 83, 'Logged in', '2025-05-16 13:15:05'),
(617, 83, 'Added application ID 1061', '2025-05-16 13:16:06'),
(618, 82, 'Logged in', '2025-05-16 13:18:15'),
(619, 82, 'Logged out', '2025-05-16 13:18:58'),
(620, 83, 'Logged in', '2025-05-16 13:19:08'),
(621, 82, 'Logged in', '2025-05-16 13:21:30'),
(622, 82, 'Logged in', '2025-05-19 19:12:18'),
(623, 83, 'Logged in', '2025-05-20 23:47:56'),
(624, 83, 'Logged in', '2025-05-21 10:26:07'),
(625, 83, 'Added application ID 1061', '2025-05-21 10:26:57'),
(626, 83, 'Logged in', '2025-05-21 10:37:33'),
(627, 83, 'Logged in', '2025-05-21 10:57:20'),
(628, 83, 'Logged in', '2025-05-21 11:33:02'),
(629, 83, 'Added application ID 1060', '2025-05-21 11:33:43'),
(630, 83, 'Logged in', '2025-05-21 12:42:34'),
(631, 83, 'Updated Application: ID 2046', '2025-05-21 12:43:01'),
(632, 83, 'Logged in', '2025-05-21 12:45:33'),
(633, 83, 'Updated Application: ID 2046', '2025-05-21 12:45:47'),
(634, 83, 'Logged in', '2025-05-21 12:53:40'),
(635, 83, 'Deleted application: ID 2046', '2025-05-21 12:53:54'),
(636, 83, 'Added application ID 1060', '2025-05-21 12:54:23'),
(637, 83, 'Logged in', '2025-05-21 12:57:03'),
(638, 83, 'Added application ID 1060', '2025-05-21 12:57:35'),
(639, 83, 'Logged in', '2025-05-21 13:00:08'),
(640, 83, 'Updated Application: ID 2048', '2025-05-21 13:00:23'),
(641, 83, 'Logged in', '2025-05-21 13:06:24'),
(642, 83, 'Added application ID 1060', '2025-05-21 13:06:59'),
(643, 83, 'Logged in', '2025-05-21 14:19:56'),
(644, 83, 'Deleted application: ID 2049', '2025-05-21 14:20:04'),
(645, 83, 'Deleted application: ID 2048', '2025-05-21 14:20:10'),
(646, 83, 'Deleted application: ID ', '2025-05-21 14:20:16'),
(647, 83, 'Added application ID 1061', '2025-05-21 14:20:48'),
(648, 83, 'Updated Application: ID 2050', '2025-05-21 14:21:31'),
(649, 83, 'Logged in', '2025-05-21 14:28:37'),
(650, 83, 'Logged in', '2025-05-21 14:31:55'),
(651, 83, 'Logged in', '2025-05-21 14:33:32'),
(652, 83, 'Logged in', '2025-05-21 14:52:39'),
(653, 83, 'Logged in', '2025-05-21 15:35:13'),
(654, 83, 'Logged in', '2025-05-21 15:49:14'),
(655, 83, 'Updated Application: ID 2050', '2025-05-21 15:49:31'),
(656, 83, 'Logged in', '2025-05-21 15:59:51'),
(657, 83, 'Logged in', '2025-05-21 16:02:12'),
(658, 83, 'Logged in', '2025-05-21 16:15:36'),
(659, 83, 'Logged in', '2025-05-21 16:19:20'),
(660, 83, 'Logged in', '2025-05-21 16:20:05'),
(661, 83, 'Logged in', '2025-05-21 16:21:31'),
(662, 83, 'Logged in', '2025-05-21 16:23:28'),
(663, 83, 'Logged in', '2025-05-21 16:24:20'),
(664, 83, 'Logged in', '2025-05-21 16:24:54'),
(665, 83, 'Logged in', '2025-05-21 16:26:27'),
(666, 82, 'Logged in', '2025-05-21 16:31:16'),
(667, 82, 'Logged out', '2025-05-21 16:31:25'),
(668, 83, 'Logged in', '2025-05-21 16:31:32'),
(669, 83, 'Logged in', '2025-05-21 16:42:19'),
(670, 83, 'Logged in', '2025-05-21 16:43:59'),
(671, 83, 'Logged in', '2025-05-21 16:44:42'),
(672, 83, 'Logged in', '2025-05-21 16:47:31'),
(673, 83, 'Logged in', '2025-05-21 16:48:06'),
(674, 83, 'Logged in', '2025-05-21 17:01:11'),
(675, 83, 'Logged in', '2025-05-21 17:02:28'),
(676, 83, 'Logged in', '2025-05-21 17:06:07'),
(677, 83, 'Logged in', '2025-05-21 21:48:08'),
(678, 83, 'Logged in', '2025-05-21 22:02:19'),
(679, 83, 'Added application ID 1060', '2025-05-21 22:03:08'),
(680, 83, 'Updated Application: ID 2051', '2025-05-21 22:03:48'),
(681, 82, 'Logged in', '2025-05-21 22:06:22'),
(682, 82, 'Logged in', '2025-05-21 22:07:01'),
(683, 91, 'Logged in', '2025-05-21 22:08:54'),
(684, 91, 'Logged in', '2025-05-21 22:18:17'),
(685, 83, 'Logged in', '2025-05-21 22:18:43'),
(686, 82, 'Logged in', '2025-05-21 22:27:48'),
(687, 83, 'Logged in', '2025-05-22 09:05:18'),
(688, 83, 'Logged in', '2025-05-22 09:05:41'),
(689, 82, 'Logged in', '2025-05-23 10:45:36'),
(690, 82, 'Logged in', '2025-05-23 11:18:56'),
(691, 82, 'Logged out', '2025-05-23 11:19:14'),
(692, 83, 'Logged in', '2025-05-23 11:22:59'),
(693, 82, 'Logged in', '2025-05-23 11:23:58'),
(694, 82, 'Added new user: ID 94', '2025-05-23 11:24:50'),
(695, 82, 'Logged out', '2025-05-23 11:24:59'),
(696, 94, 'Logged in', '2025-05-23 11:25:06'),
(697, 94, 'Logged in', '2025-05-23 11:25:48'),
(698, 94, 'Logged out', '2025-05-23 11:25:50'),
(699, 83, 'Logged in', '2025-05-23 11:27:19'),
(700, 83, 'Logged in', '2025-05-23 14:23:25'),
(701, 82, 'Logged in', '2025-05-24 13:32:27'),
(702, 82, 'Logged in', '2025-05-24 13:34:10'),
(703, 83, 'Logged in', '2025-05-26 00:19:43'),
(704, 82, 'Logged in', '2025-05-26 00:20:22'),
(705, 82, 'Logged in', '2025-05-26 00:25:41'),
(706, 83, 'Logged in', '2025-05-26 00:29:33'),
(707, 83, 'Logged in', '2025-05-26 22:21:19'),
(708, 82, 'Logged in', '2025-05-26 22:21:33'),
(709, 83, 'Logged in', '2025-05-26 22:35:41'),
(710, 82, 'Logged in', '2025-05-26 22:51:11'),
(711, 83, 'Logged in', '2025-05-27 10:55:48'),
(712, 83, 'Logged in', '2025-05-27 18:42:17'),
(713, 82, 'Logged in', '2025-05-27 18:42:44'),
(714, 82, 'Logged in', '2025-05-27 18:44:17'),
(715, 83, 'Logged in', '2025-05-27 18:53:25');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_passphase`
--

CREATE TABLE `tbl_passphase` (
  `p_sid` int(20) NOT NULL,
  `u_id` int(20) NOT NULL,
  `phrase` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_passphase`
--

INSERT INTO `tbl_passphase` (`p_sid`, `u_id`, `phrase`) VALUES
(17, 82, 'RM5nPA97C5+R/0wDLzMOpSEWzmI5dhQeGMQjiiyxhqM='),
(18, 83, 'RM5nPA97C5+R/0wDLzMOpSEWzmI5dhQeGMQjiiyxhqM='),
(19, 93, '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8='),
(20, 94, '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_plan`
--

CREATE TABLE `tbl_plan` (
  `p_id` int(20) NOT NULL,
  `p_name` varchar(50) NOT NULL,
  `p_requirement` varchar(50) NOT NULL,
  `p_interest` varchar(50) NOT NULL,
  `p_status` varchar(50) NOT NULL,
  `p_image` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_plan`
--

INSERT INTO `tbl_plan` (`p_id`, `p_name`, `p_requirement`, `p_interest`, `p_status`, `p_image`) VALUES
(1060, 'Home Loan', 'House Certificate', '5%', 'Available', 'src/planimages/home loan.png'),
(1061, 'Student Loan', 'Student ID', '2%', 'Available', 'src/planimages/student loan.jpg');

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
  `u_status` varchar(50) NOT NULL,
  `u_image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_contact`, `u_username`, `u_password`, `u_type`, `u_status`, `u_image`) VALUES
(82, 'John Lhoyde', 'Dakay', 'jl@gmail.com', '09098898990', 'jl', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Admin', 'Active', 'src/userimages/USERMAN2.jpg'),
(83, 'Mike', 'Bustamante', 'mk@gmail.com', '09887655743', 'mike', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'User', 'Active', 'src/userimages/userman1.jpg'),
(84, 'Carl', 'Fernando', 'carl@gmail.com', '09152647499', 'carl', 'ipvPHlHoEtCvhGWo28yfdBBkvwrzs9COawJGQ3wZ9/s=', 'User', 'Active', 'src/userimages/MEN 5.jpg'),
(91, 'Mika', 'Andres', 'mika@gmail.com', '09098876567', 'mika', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'User', 'Active', 'src/userimages/userwoman1.jpg'),
(92, 'Sam', 'Smith', 'sam@gmail.com', '09097657456', 'sam', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Admin', 'Pending', ''),
(93, 'steve', 'mine', 'steve@gmail.com', '09098788765', 'steve@gmail.com', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Admin', 'Active', ''),
(94, 'wanny', 'paxman', 'pax@gmail.com', '09090987654', 'pax', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Admin', 'Active', 'src/userimages/userwoman2.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_apply`
--
ALTER TABLE `tbl_apply`
  ADD PRIMARY KEY (`a_id`),
  ADD KEY `pid` (`p_id`),
  ADD KEY `uid` (`u_id`);

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`l_id`),
  ADD KEY `uiid` (`u_id`);

--
-- Indexes for table `tbl_passphase`
--
ALTER TABLE `tbl_passphase`
  ADD PRIMARY KEY (`p_sid`),
  ADD KEY `uiiiid` (`u_id`);

--
-- Indexes for table `tbl_plan`
--
ALTER TABLE `tbl_plan`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_apply`
--
ALTER TABLE `tbl_apply`
  MODIFY `a_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2052;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `l_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=716;

--
-- AUTO_INCREMENT for table `tbl_passphase`
--
ALTER TABLE `tbl_passphase`
  MODIFY `p_sid` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tbl_plan`
--
ALTER TABLE `tbl_plan`
  MODIFY `p_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1062;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=95;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_apply`
--
ALTER TABLE `tbl_apply`
  ADD CONSTRAINT `pid` FOREIGN KEY (`p_id`) REFERENCES `tbl_plan` (`p_id`),
  ADD CONSTRAINT `uid` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `uiid` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);

--
-- Constraints for table `tbl_passphase`
--
ALTER TABLE `tbl_passphase`
  ADD CONSTRAINT `uiiiid` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
