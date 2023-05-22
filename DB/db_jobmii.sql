-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2023 at 04:57 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_jobmii`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_apply_employee`
--

CREATE TABLE `tb_apply_employee` (
  `apply_employee_id` int(11) NOT NULL,
  `apply_date` varchar(255) NOT NULL,
  `date_test` varchar(255) DEFAULT NULL,
  `location_test` varchar(255) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `vacancy_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_apply_employee`
--

INSERT INTO `tb_apply_employee` (`apply_employee_id`, `apply_date`, `date_test`, `location_test`, `employee_id`, `user_id`, `status_id`, `vacancy_id`) VALUES
(1, '2023/05/17 17:46:10', '2023/05/22', 'APL Tower lt. 18', 4, 1, 3, 1),
(2, '2023/05/17 17:49:03', '2023/05/22', 'APL Tower lt. 18', 4, 1, 2, 2),
(3, '2023/05/18 07:41:34', '2023/05/24', 'Online', 6, 1, 2, 1),
(4, '2023/05/18 07:41:34', '2023/05/24', 'Online', 15, 1, 2, 2),
(5, '2023/05/18 20:58:28', '2023-05-22T09:00', 'Online', 15, 1, 2, 1),
(6, '2023/05/19 01:40:33', '2023/05/22', 'APL Tower lt. 18', 12, 1, 3, 1),
(7, '2023/05/19 09:15:23', '2023-05-21T09:15', 'Online', 5, 1, 3, 3),
(8, '2023/05/19 09:19:31', '2023-05-22T09:19', 'Online', 15, 1, 2, 3),
(9, '2023/05/19 09:34:52', '2023-05-22T09:34', 'Online', 24, 1, 3, 3),
(10, '2023/05/19 09:46:11', '2023-05-22T09:46', 'Online', 13, 1, 3, 3),
(11, '2023/05/19 09:51:55', '2023-05-22T09:51', 'Online', 26, 1, 3, 3),
(12, '2023/05/19 09:57:33', '2023-05-22T09:57', 'Online', 30, 1, 3, 3),
(13, '2023/05/19 10:36:19', '2023-05-22T10:36', 'Online', 25, 1, 3, 3),
(14, '2023/05/19 11:06:27', '2023-05-22T11:06', 'Online', 34, 1, 3, 3),
(15, '2023/05/19 11:27:44', '2023-05-22T11:27', 'Online', 35, 1, 3, 3),
(16, '2023/05/19 11:57:19', '2023-05-22T11:57', 'Online', 33, 1, 3, 3),
(17, '2023/05/19 12:01:03', '2023-05-22T12:00', 'Online', 15, 1, 3, 3),
(18, '2023/05/19 13:46:06', '2023-05-26T13:45', 'Online', 36, 1, 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tb_employee`
--

CREATE TABLE `tb_employee` (
  `employee_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `cv` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_employee`
--

INSERT INTO `tb_employee` (`employee_id`, `description`, `cv`, `email`, `name`, `phone`, `position_id`, `status`) VALUES
(1, NULL, NULL, 'hr@yopmail.com', 'HR', '000', NULL, NULL),
(2, NULL, 'Tugas Tuton 1 EKMA4116.pdf', 'zenjiro@yopmail.com', 'Zenjiro', '0790', 1, b'1'),
(3, 'Perusahaan ini bergerak di bidang pencarian jodoh.', NULL, 'MCS@yopmail.com', 'PT. Mencari Cinta Sejati', '02546766', NULL, NULL),
(4, NULL, 'fahri.pdf', 'fahri@yopail.com', 'Fahrijar', '8255', 1, b'1'),
(5, NULL, 'DAFTAR ISI.pdf', 'arifin@yopmail.com', 'Muhammad Arifin', '08577877', 4, b'1'),
(6, NULL, 'hosea.pdf', 'hosea@yopmail.com', 'hosea', '007', 2, b'1'),
(10, 'Perusahaan ini bergerak di semua.', NULL, 'facebook@yopmail.com', 'Facebook Company', '02522', NULL, NULL),
(12, NULL, NULL, 'raihan@yopmail.com', 'Raihan', '08212', 4, b'1'),
(13, NULL, '', 'shafiq@yopmail.com', 'Shafiq', '08877', 3, b'1'),
(15, NULL, 'verifikasiTA_A11.2018.11524_2.pdf', 'zulfani@yopmail.com', 'zulfani', '777', 1, b'1'),
(16, '-', NULL, 'meta@yopmail.com', 'Meta', '088999', NULL, NULL),
(17, NULL, NULL, 'hr2@yopmail.com', 'HR 2', '00888', NULL, NULL),
(22, NULL, NULL, 'hr3@yopmail.com', 'HR 3', '000', NULL, NULL),
(23, NULL, NULL, 'rina@yopmail.com', 'Rina', '08899', NULL, b'0'),
(24, NULL, NULL, 'dean@yopmail.com', 'Dean', '09988', 3, b'1'),
(25, NULL, '', 'mhus@yopmail.com', 'Mhus', '8899', 3, b'1'),
(26, NULL, '', 'rio@yopmail.com', 'rio', '8899', 3, b'1'),
(27, NULL, 'cek.pdf', 'fadli@yopmail.com', 'Fadli', '8877', 2, b'0'),
(28, 'Cek Description', NULL, 'twitter@yopmail.com', 'Twitter Inc', '8088', NULL, NULL),
(29, '-', NULL, 'shopee@yopmail.com', 'Shopee', '8666', NULL, NULL),
(30, NULL, '', 'sofian@yopmail.com', 'sofian', '8877', 3, b'1'),
(31, NULL, NULL, 'hr4@yopmail.com', 'HR 4', '666', NULL, NULL),
(32, NULL, NULL, 'hr5@yopmail.com', 'HR 5', '877', NULL, NULL),
(33, NULL, '', 'andro@yopmail.com', 'Andro Faiq', '087766', 3, b'1'),
(34, NULL, '', 'angga@yopmail.com', 'Angga Sukma', '08877', 3, b'1'),
(35, NULL, '', 'andika@yopmail.com', 'andika', '08877', 4, b'1'),
(36, NULL, 'verifikasiTA_A11.2018.11524_2.pdf', 'ilham@yopmail.com', 'Ilham', '98776', 3, b'1'),
(37, NULL, NULL, 'mahesa@yopmail.com', 'Mahesa', '0899', NULL, b'0'),
(38, NULL, NULL, 'johan@yopmail.com', 'Johan', '08898', NULL, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `tb_history`
--

CREATE TABLE `tb_history` (
  `history_id` int(11) NOT NULL,
  `update_date` varchar(255) DEFAULT NULL,
  `apply_employee_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_history`
--

INSERT INTO `tb_history` (`history_id`, `update_date`, `apply_employee_id`, `status_id`) VALUES
(1, '2023/05/14 15:32:10', 1, 1),
(2, '2023/05/17 17:35:42', 2, 1),
(3, '2023/05/17 17:46:10', 1, 3),
(4, '2023/05/17 17:49:03', 2, 2),
(5, '2023/05/18 07:41:34', 3, 1),
(6, '2023/05/18 15:33:17', 4, 1),
(7, '2023/05/18 20:58:28', 5, 1),
(8, '2023/05/18 21:00:25', 5, 2),
(9, '2023/05/19 00:14:18', 3, 3),
(10, '2023/05/19 00:35:12', 4, 2),
(11, '2023/05/19 00:36:20', 4, 2),
(12, '2023/05/19 01:03:04', 3, 2),
(13, '2023/05/19 01:40:33', 6, 1),
(14, '2023/05/19 01:41:36', 6, 2),
(15, '2023/05/19 01:56:12', 6, 2),
(16, '2023/05/19 01:56:50', 6, 3),
(17, '2023/05/19 02:37:24', 3, 3),
(18, '2023/05/19 09:15:23', 7, 1),
(19, '2023/05/19 09:19:31', 8, 1),
(20, '2023/05/19 09:22:30', 8, 2),
(21, '2023/05/19 09:22:36', 7, 3),
(22, '2023/05/19 09:34:52', 9, 1),
(23, '2023/05/19 09:36:15', 9, 3),
(24, '2023/05/19 09:46:11', 10, 1),
(25, '2023/05/19 09:47:00', 10, 3),
(26, '2023/05/19 09:51:55', 11, 1),
(27, '2023/05/19 09:52:43', 11, 3),
(28, '2023/05/19 09:57:33', 12, 1),
(29, '2023/05/19 09:58:52', 12, 3),
(30, '2023/05/19 10:36:19', 13, 1),
(31, '2023/05/19 10:37:16', 13, 3),
(32, '2023/05/19 11:06:27', 14, 1),
(33, '2023/05/19 11:07:44', 14, 3),
(34, '2023/05/19 11:27:44', 15, 1),
(35, '2023/05/19 11:29:22', 15, 3),
(36, '2023/05/19 11:57:19', 16, 1),
(37, '2023/05/19 11:58:43', 16, 3),
(38, '2023/05/19 12:01:03', 17, 1),
(39, '2023/05/19 12:02:06', 17, 3),
(40, '2023/05/19 12:04:29', 2, 2),
(41, '2023/05/19 12:05:47', 3, 2),
(42, '2023/05/19 13:46:06', 18, 1),
(43, '2023/05/19 13:47:52', 18, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tb_position`
--

CREATE TABLE `tb_position` (
  `position_id` int(11) NOT NULL,
  `name_position` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_position`
--

INSERT INTO `tb_position` (`position_id`, `name_position`) VALUES
(1, 'Backend'),
(2, 'Frontend'),
(3, 'QA'),
(4, 'IT Support');

-- --------------------------------------------------------

--
-- Table structure for table `tb_position_vacancy`
--

CREATE TABLE `tb_position_vacancy` (
  `position_id` int(11) NOT NULL,
  `vacancy_id` int(11) NOT NULL,
  `quota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_position_vacancy`
--

INSERT INTO `tb_position_vacancy` (`position_id`, `vacancy_id`, `quota`) VALUES
(1, 1, 5),
(1, 2, 8),
(1, 5, 3),
(2, 1, 7),
(3, 1, 2),
(3, 4, 5),
(4, 3, 13);

-- --------------------------------------------------------

--
-- Table structure for table `tb_privilege`
--

CREATE TABLE `tb_privilege` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_privilege`
--

INSERT INTO `tb_privilege` (`id`, `name`) VALUES
(1, 'create_employee'),
(2, 'read_employee'),
(3, 'update_employee'),
(4, 'delete_employee'),
(5, 'create_hr'),
(6, 'read_hr'),
(7, 'update_hr'),
(8, 'delete_hr'),
(9, 'create_client'),
(10, 'read_client'),
(11, 'update_client'),
(12, 'delete_client');

-- --------------------------------------------------------

--
-- Table structure for table `tb_role`
--

CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_role`
--

INSERT INTO `tb_role` (`role_id`, `role_name`) VALUES
(1, 'Employee'),
(2, 'HR'),
(3, 'Client');

-- --------------------------------------------------------

--
-- Table structure for table `tb_role_privilege`
--

CREATE TABLE `tb_role_privilege` (
  `role_id` int(11) NOT NULL,
  `privilege_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_role_privilege`
--

INSERT INTO `tb_role_privilege` (`role_id`, `privilege_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(3, 9),
(3, 10),
(3, 11),
(3, 12);

-- --------------------------------------------------------

--
-- Table structure for table `tb_status`
--

CREATE TABLE `tb_status` (
  `status_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_status`
--

INSERT INTO `tb_status` (`status_id`, `name`) VALUES
(1, 'Process'),
(2, 'Rejected'),
(3, 'Accepted');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL,
  `is_account_non_locked` bit(1) DEFAULT NULL,
  `is_enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`user_id`, `is_account_non_locked`, `is_enabled`, `password`, `username`) VALUES
(1, b'1', b'1', '$2a$10$b8UoPx5xSwAoc87mFsE4auM9FvTB1f9Gskd9oPrg6Gfoi7rWsQyaq', 'hr'),
(2, b'1', b'1', 'zenjiroo', 'zenjiroo'),
(3, b'1', b'1', '$2a$10$srtXnKbkKt9XOrFXAtCkvuO.kI9jXcf..2kHdkSjNKp7Y5kFz1R7O', 'MCS'),
(4, b'1', b'1', '$2a$10$ENStG4er2QsQLdNW4HZnNOH4wlbgkYoOlBBcb9a1E0B7XHPi3ls9C', 'fahri'),
(5, b'1', b'1', '$2a$10$FuPFmmQoO1DUObTqiVEoQufKdozLnqherVGdNWjFKqcKfpBDh6u1y', 'arifin'),
(6, b'1', b'1', '$2a$10$xJEVrvntq/jGivCczlPedu9NU3IbcA6GfsVhnDYLQoK9dPxmuk4ue', 'hosea'),
(10, b'1', b'1', '$2a$10$yLhHG9AwNkabSkq1WImq8uiCEUvFcv9ODeTPOJL860eAkEZtc4Ee2', 'facebook'),
(12, b'1', b'1', '$2a$10$rGJAk3IjecY0qVpjkgf6meubv8LrsOFgZb/Bf6csSVwcbWPb3yWiO', 'raihan'),
(13, b'1', b'1', '$2a$10$VO/SnclXYUwMvyR2PRh1QuLODEluguoE9WM0ZhaHbumHF50ScSCPC', 'shafiq'),
(15, b'1', b'1', '$2a$10$Nqu9TH06tr22fEv6fSFOb.KlZwZFhcD8L7SfpV1nkbJMTj7yyYfja', 'zulfani'),
(16, b'1', b'1', '$2a$10$h9tnj/Bq2XJOMlwIgrymoO4HvETUuEd.EiulgyiWL98oa02QYRqUe', 'meta'),
(17, b'1', b'1', '$2a$10$rbfsATVsHTkNoxaKCNDMwulxdC0IOf4sqqMbcoAaj5xfyge2DxmQ6', 'hr2'),
(22, b'1', b'1', '$2a$10$kTk1kVZ5L4zpqnzTGbuRr.C8klNcUedcbQnNcGnC8wdNaodWug3Ka', 'hr3'),
(23, b'1', b'1', '$2a$10$Qltol.huXroqa82GI3G19u.8eWSR16WswpWfdYsy.1Uq7PcXNo9Ae', 'rina'),
(24, b'1', b'1', '$2a$10$FKUxPhJ2HinuSkMH9b3QNOt.1QtJBf01R0iL4hFzGN9aIiX3QrfsO', 'dean'),
(25, b'1', b'1', '$2a$10$CbrAwrLCuyvO9SBBk/tRt.aQfat/lvl5x8in0GPpG1zhVnO4lAmua', 'mhus'),
(26, b'1', b'1', '$2a$10$ukR571qr6E2HDyI.tYTohOKPWpV12B8OCpCTSppxQ6NQAqX7zGqh2', 'rio'),
(27, b'1', b'1', '$2a$10$JTrZWoBYCdHN9/8GfOOTFuAulvg7.dYamKmTKQA/cq.TeXYAz7ftK', 'fadli'),
(28, b'1', b'1', '$2a$10$5wU9PBOqN7hZi0RDeiAdM.71nv7m65GxRI7a8sa9Sss2Tb8mmvR3.', 'twitter'),
(29, b'1', b'1', '$2a$10$4fA6oCorvlXON8AA/kzdL.kscb5XVOpkmUTj.maqFl9BJzfYfsOFK', 'shopee'),
(30, b'1', b'1', '$2a$10$/A3LIYK2LsX63c3wiGoVfOXbD1n0BcBmQoN5m90YWp0AWltv.81gS', 'sofian'),
(31, b'1', b'1', '$2a$10$Ur.4uCcuuHT07xcDPeGlIulhrgo0YoLaQs5qgjzmbcAPo9nD.Vfxa', 'hr4'),
(32, b'1', b'1', '$2a$10$SyFV90rmGzJOsqChWXCLne.t8uD78M3ALIJz5XiWpvn/NzJ4HAsj.', 'hr5'),
(33, b'1', b'1', '$2a$10$Q1Mqz.Jt2rM/OLjUGgKqx.bKikOvB28Cl8Wex2Rkq.rbhJJwBndbm', 'andro'),
(34, b'1', b'1', '$2a$10$cCZYqnn7wzepjo33ArwQOO1nH/s8WMXMoFRpZo8QfxogoZ6CQJA/.', 'angga'),
(35, b'1', b'1', '$2a$10$XK0MSuemotDZ5wQnmn7eOe2Ku6mvYXGaXJ6ZUTKiMQrYYk7xTmc8G', 'andika'),
(36, b'1', b'1', '$2a$10$FozODcwKUBdeOHs0Ncv.v.XzCKeGvp4fsEhwV1vefWy7n7TrlQxA6', 'ilham'),
(37, b'1', b'1', '$2a$10$TxSwxU6SUVOabjsXcQLcm.U2u7yieeY.Y2XwN/qqyL7zJWDyJyXsS', 'mahesa'),
(38, b'1', b'1', '$2a$10$XhyORJF4/6Qqk.z03BiYSOKtmIX2epk1fY8IG3H6FDxWMWZMVa17e', 'johan');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user_role`
--

CREATE TABLE `tb_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_user_role`
--

INSERT INTO `tb_user_role` (`user_id`, `role_id`) VALUES
(1, 2),
(2, 1),
(3, 3),
(10, 3),
(16, 3),
(17, 2),
(22, 2),
(23, 1),
(27, 1),
(28, 3),
(29, 3),
(31, 2),
(32, 2),
(5, 1),
(5, 1),
(13, 1),
(26, 1),
(30, 1),
(25, 1),
(34, 1),
(35, 1),
(35, 1),
(15, 1),
(4, 1),
(6, 1),
(36, 1),
(37, 1),
(38, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_vacancy`
--

CREATE TABLE `tb_vacancy` (
  `vacancy_id` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `end_date` date NOT NULL,
  `is_active` bit(1) NOT NULL,
  `start_date` date NOT NULL,
  `title` varchar(255) NOT NULL,
  `mitra_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_vacancy`
--

INSERT INTO `tb_vacancy` (`vacancy_id`, `address`, `end_date`, `is_active`, `start_date`, `title`, `mitra_id`) VALUES
(1, 'Jln. S.Parman No. 69, Jakarta Barat', '2023-05-12', b'1', '2023-05-06', 'Full Stack Develop', 10),
(2, 'Jln. Menoreh No. 6, Jakarta Barat', '2023-05-19', b'1', '2023-05-16', 'Back End Develop', 3),
(3, 'Jln. Pemuda No. 1, Jakarta', '2023-05-21', b'1', '2023-05-17', 'Data Analyst', 16),
(4, 'Jln. M.H. Thamrin No. 169, Jakarta', '2023-05-21', b'1', '2023-05-16', 'Quality Assurance', 10),
(5, 'Jln. Pemuda 143 , Jakarta', '2023-05-25', b'1', '2023-05-19', 'Back End Develop', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_apply_employee`
--
ALTER TABLE `tb_apply_employee`
  ADD PRIMARY KEY (`apply_employee_id`),
  ADD KEY `FKpv4yhkk0d5j4w05lyawkfdusf` (`employee_id`),
  ADD KEY `FKq6abafh7kjpjag30wqvc5s6k9` (`user_id`),
  ADD KEY `FKadg511himo5m09l8ygem62gl` (`status_id`),
  ADD KEY `FK7anov4lyxhhk74l544m4xcdt3` (`vacancy_id`);

--
-- Indexes for table `tb_employee`
--
ALTER TABLE `tb_employee`
  ADD PRIMARY KEY (`employee_id`),
  ADD KEY `FKbnhskkrcjhabpknadtx0o146w` (`position_id`);

--
-- Indexes for table `tb_history`
--
ALTER TABLE `tb_history`
  ADD PRIMARY KEY (`history_id`),
  ADD KEY `FKdtd4v3enn3cvw0faxwwvw5rbo` (`apply_employee_id`),
  ADD KEY `FK7bgijwvmm0gk1qtsf06yacnc8` (`status_id`);

--
-- Indexes for table `tb_position`
--
ALTER TABLE `tb_position`
  ADD PRIMARY KEY (`position_id`);

--
-- Indexes for table `tb_position_vacancy`
--
ALTER TABLE `tb_position_vacancy`
  ADD PRIMARY KEY (`position_id`,`vacancy_id`),
  ADD KEY `FK1l48yudps1losd4vkv7y2edhx` (`vacancy_id`);

--
-- Indexes for table `tb_privilege`
--
ALTER TABLE `tb_privilege`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_role`
--
ALTER TABLE `tb_role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `tb_role_privilege`
--
ALTER TABLE `tb_role_privilege`
  ADD KEY `FK6gvpbopw3c17inmv17usj8kes` (`privilege_id`),
  ADD KEY `FKsncdml4xq9xf0opvvrxcycq7y` (`role_id`);

--
-- Indexes for table `tb_status`
--
ALTER TABLE `tb_status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `tb_user_role`
--
ALTER TABLE `tb_user_role`
  ADD KEY `FKea2ootw6b6bb0xt3ptl28bymv` (`role_id`),
  ADD KEY `FK7vn3h53d0tqdimm8cp45gc0kl` (`user_id`);

--
-- Indexes for table `tb_vacancy`
--
ALTER TABLE `tb_vacancy`
  ADD PRIMARY KEY (`vacancy_id`),
  ADD KEY `FKtbv4k7guv788965mfaktg6cno` (`mitra_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_apply_employee`
--
ALTER TABLE `tb_apply_employee`
  MODIFY `apply_employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `tb_employee`
--
ALTER TABLE `tb_employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `tb_history`
--
ALTER TABLE `tb_history`
  MODIFY `history_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `tb_position`
--
ALTER TABLE `tb_position`
  MODIFY `position_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_privilege`
--
ALTER TABLE `tb_privilege`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tb_role`
--
ALTER TABLE `tb_role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tb_status`
--
ALTER TABLE `tb_status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tb_vacancy`
--
ALTER TABLE `tb_vacancy`
  MODIFY `vacancy_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_apply_employee`
--
ALTER TABLE `tb_apply_employee`
  ADD CONSTRAINT `FK7anov4lyxhhk74l544m4xcdt3` FOREIGN KEY (`vacancy_id`) REFERENCES `tb_vacancy` (`vacancy_id`),
  ADD CONSTRAINT `FKadg511himo5m09l8ygem62gl` FOREIGN KEY (`status_id`) REFERENCES `tb_status` (`status_id`),
  ADD CONSTRAINT `FKpv4yhkk0d5j4w05lyawkfdusf` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`employee_id`),
  ADD CONSTRAINT `FKq6abafh7kjpjag30wqvc5s6k9` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`);

--
-- Constraints for table `tb_employee`
--
ALTER TABLE `tb_employee`
  ADD CONSTRAINT `FKbnhskkrcjhabpknadtx0o146w` FOREIGN KEY (`position_id`) REFERENCES `tb_position` (`position_id`);

--
-- Constraints for table `tb_history`
--
ALTER TABLE `tb_history`
  ADD CONSTRAINT `FK7bgijwvmm0gk1qtsf06yacnc8` FOREIGN KEY (`status_id`) REFERENCES `tb_status` (`status_id`),
  ADD CONSTRAINT `FKdtd4v3enn3cvw0faxwwvw5rbo` FOREIGN KEY (`apply_employee_id`) REFERENCES `tb_apply_employee` (`apply_employee_id`);

--
-- Constraints for table `tb_position_vacancy`
--
ALTER TABLE `tb_position_vacancy`
  ADD CONSTRAINT `FK1l48yudps1losd4vkv7y2edhx` FOREIGN KEY (`vacancy_id`) REFERENCES `tb_vacancy` (`vacancy_id`),
  ADD CONSTRAINT `FKbaogt8y168t8cifig9ak8ygfe` FOREIGN KEY (`position_id`) REFERENCES `tb_position` (`position_id`);

--
-- Constraints for table `tb_role_privilege`
--
ALTER TABLE `tb_role_privilege`
  ADD CONSTRAINT `FK6gvpbopw3c17inmv17usj8kes` FOREIGN KEY (`privilege_id`) REFERENCES `tb_privilege` (`id`),
  ADD CONSTRAINT `FKsncdml4xq9xf0opvvrxcycq7y` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`);

--
-- Constraints for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD CONSTRAINT `FKc292wihcuifdkgmv4fbk57n74` FOREIGN KEY (`user_id`) REFERENCES `tb_employee` (`employee_id`);

--
-- Constraints for table `tb_user_role`
--
ALTER TABLE `tb_user_role`
  ADD CONSTRAINT `FK7vn3h53d0tqdimm8cp45gc0kl` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`),
  ADD CONSTRAINT `FKea2ootw6b6bb0xt3ptl28bymv` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`);

--
-- Constraints for table `tb_vacancy`
--
ALTER TABLE `tb_vacancy`
  ADD CONSTRAINT `FKtbv4k7guv788965mfaktg6cno` FOREIGN KEY (`mitra_id`) REFERENCES `tb_employee` (`employee_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
