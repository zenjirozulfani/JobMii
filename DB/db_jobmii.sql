-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2023 at 03:48 PM
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
  `apply_date` date NOT NULL,
  `history_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `vacancy_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `status` varchar(255) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_employee`
--

INSERT INTO `tb_employee` (`employee_id`, `description`, `cv`, `email`, `name`, `phone`, `status`, `position_id`) VALUES
(1, NULL, NULL, 'hr@yopmail.com', 'hr', '000', NULL, NULL),
(2, NULL, 'zenjiro.pdf', 'zenjiro@yopmail.com', 'Zenjiro', '007', 'Sudah Direkrut', 1),
(3, 'Perusahaan ini bergerak di bidang pencarian jodoh.', NULL, 'MCS@yopmail.com', 'PT. Mencari Cinta Sejati', '02546766', NULL, NULL),
(4, NULL, NULL, 'fahrijal@yopmail.com', 'Fahri jnck', '0825', '0', NULL),
(5, NULL, NULL, 'arifin@yopmail.com', 'Arifin', '085', '0', NULL),
(6, NULL, NULL, 'hosea@yopmail.com', 'Hosea', '0822', '0', NULL),
(10, 'Perusahaan ini bergerak di semua bidang.', NULL, 'facebook@yopmail.com', 'Facebook Company', '02522', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_history`
--

CREATE TABLE `tb_history` (
  `history_id` int(11) NOT NULL,
  `update_date` date DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(2, b'1', b'1', '$2a$10$0hSSmEMzcc08FAcbAsLhv.V6IjBGAV2TgG49IBTfxbO4raeJWbrCu', 'zenjiro'),
(3, b'1', b'1', '$2a$10$srtXnKbkKt9XOrFXAtCkvuO.kI9jXcf..2kHdkSjNKp7Y5kFz1R7O', 'MCS'),
(4, b'1', b'1', '$2a$10$ENStG4er2QsQLdNW4HZnNOH4wlbgkYoOlBBcb9a1E0B7XHPi3ls9C', 'fahri'),
(5, b'1', b'1', '$2a$10$FuPFmmQoO1DUObTqiVEoQufKdozLnqherVGdNWjFKqcKfpBDh6u1y', 'arifin'),
(6, b'1', b'1', '$2a$10$xJEVrvntq/jGivCczlPedu9NU3IbcA6GfsVhnDYLQoK9dPxmuk4ue', 'hosea'),
(10, b'1', b'1', '$2a$10$yLhHG9AwNkabSkq1WImq8uiCEUvFcv9ODeTPOJL860eAkEZtc4Ee2', 'facebook');

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
(4, 1),
(5, 1),
(6, 1),
(10, 3);

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
(2, 'Jln. S. Parman No.90, Jakarta Barat', '2023-05-13', b'1', '2023-05-05', 'Dibutuhkan Tenaga External Back End Develop', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_apply_employee`
--
ALTER TABLE `tb_apply_employee`
  ADD PRIMARY KEY (`apply_employee_id`),
  ADD KEY `FKb2b2ncw1hetehakswcpsb1fwa` (`history_id`),
  ADD KEY `FKgkbqbvll8xi06xxobjmbxhas8` (`status`),
  ADD KEY `FKpv4yhkk0d5j4w05lyawkfdusf` (`employee_id`),
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
  MODIFY `apply_employee_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_employee`
--
ALTER TABLE `tb_employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tb_history`
--
ALTER TABLE `tb_history`
  MODIFY `history_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_position`
--
ALTER TABLE `tb_position`
  MODIFY `position_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_vacancy`
--
ALTER TABLE `tb_vacancy`
  MODIFY `vacancy_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_apply_employee`
--
ALTER TABLE `tb_apply_employee`
  ADD CONSTRAINT `FK7anov4lyxhhk74l544m4xcdt3` FOREIGN KEY (`vacancy_id`) REFERENCES `tb_vacancy` (`vacancy_id`),
  ADD CONSTRAINT `FKb2b2ncw1hetehakswcpsb1fwa` FOREIGN KEY (`history_id`) REFERENCES `tb_history` (`history_id`),
  ADD CONSTRAINT `FKgkbqbvll8xi06xxobjmbxhas8` FOREIGN KEY (`status`) REFERENCES `tb_status` (`status_id`),
  ADD CONSTRAINT `FKpv4yhkk0d5j4w05lyawkfdusf` FOREIGN KEY (`employee_id`) REFERENCES `tb_employee` (`employee_id`);

--
-- Constraints for table `tb_employee`
--
ALTER TABLE `tb_employee`
  ADD CONSTRAINT `FKbnhskkrcjhabpknadtx0o146w` FOREIGN KEY (`position_id`) REFERENCES `tb_position` (`position_id`);

--
-- Constraints for table `tb_history`
--
ALTER TABLE `tb_history`
  ADD CONSTRAINT `FK7bgijwvmm0gk1qtsf06yacnc8` FOREIGN KEY (`status_id`) REFERENCES `tb_status` (`status_id`);

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
