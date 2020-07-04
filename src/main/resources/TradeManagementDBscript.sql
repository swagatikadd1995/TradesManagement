-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.30 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for trades_management
DROP DATABASE IF EXISTS `trades_management`;
CREATE DATABASE IF NOT EXISTS `trades_management` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `trades_management`;

-- Dumping structure for table trades_management.trade
DROP TABLE IF EXISTS `trade`;
CREATE TABLE IF NOT EXISTS `trade` (
  `trade_id` int(11) NOT NULL AUTO_INCREMENT,
  `trade_type` varchar(50) NOT NULL DEFAULT '0',
  `trade_symbol` varchar(50) NOT NULL DEFAULT '0',
  `trade_shares` varchar(50) NOT NULL DEFAULT '0',
  `trade_price` double NOT NULL DEFAULT '0',
  `trade_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table trades_management.trade: ~7 rows (approximately)
/*!40000 ALTER TABLE `trade` DISABLE KEYS */;
INSERT INTO `trade` (`trade_id`, `trade_type`, `trade_symbol`, `trade_shares`, `trade_price`, `trade_timestamp`, `user_id`) VALUES
    (2, 'buy', 'AC', '110', 162, '2020-07-04 22:52:21', 1),
	(3, 'sell', 'DC', '38', 155, '2020-07-03 23:10:21', 1),
	(4, 'buy', 'DC', '48', 175, '2020-07-04 22:52:14', 1),
	(5, 'sell', 'AC', '54', 146, '2020-07-04 22:51:22', 1),
	(6, 'sell', 'AC', '54', 141, '2020-07-04 22:51:26', 1),
	(7, 'buy', 'AC', '88', 158.78, '2020-07-04 22:51:31', 1),
	(8, 'buy', 'AC', '76', 184.56, '2020-07-04 16:13:53', 1);
/*!40000 ALTER TABLE `trade` ENABLE KEYS */;

-- Dumping structure for table trades_management.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table trades_management.user: ~1 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `user_name`) VALUES
	(1, 'David');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
