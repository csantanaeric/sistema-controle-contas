# --------------------------------------------------------
# Host:                         127.0.0.1
# Server version:               5.5.56
# Server OS:                    Win64
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2017-06-15 23:31:19
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for test
DROP DATABASE IF EXISTS `test`;
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;


# Dumping structure for table test.conta
DROP TABLE IF EXISTS `conta`;
CREATE TABLE IF NOT EXISTS `conta` (
  `CONTA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `STATUS` char(1) NOT NULL COMMENT 'A - ATIVO, B - BLOQUEADA, C - CANCELADA',
  `NOME` varchar(50) DEFAULT NULL,
  `CONTA_PAI_ID` bigint(20) DEFAULT NULL,
  `CONTA_PAI_MATRIZ_ID` bigint(20) DEFAULT NULL,
  `CONTA_PESSOA_ID` bigint(20) DEFAULT NULL,
  `TP_PESSOA` char(50) DEFAULT NULL,
  `DT_CRIACAO` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`CONTA_ID`),
  UNIQUE KEY `Index 6` (`NOME`),
  KEY `FK_CONTA_conta` (`CONTA_PAI_ID`),
  KEY `FK_CONTA_conta_2` (`CONTA_PAI_MATRIZ_ID`),
  KEY `FK_CONTA_conta_pessoa` (`CONTA_PESSOA_ID`),
  KEY `Index 5` (`NOME`),
  CONSTRAINT `FK_CONTA_conta` FOREIGN KEY (`CONTA_PAI_ID`) REFERENCES `conta` (`CONTA_ID`),
  CONSTRAINT `FK_CONTA_conta_2` FOREIGN KEY (`CONTA_PAI_MATRIZ_ID`) REFERENCES `conta` (`CONTA_ID`),
  CONSTRAINT `FK_CONTA_conta_pessoa` FOREIGN KEY (`CONTA_PESSOA_ID`) REFERENCES `conta_pessoa` (`CONTA_PESSOA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

# Dumping data for table test.conta: ~8 rows (approximately)
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` (`CONTA_ID`, `STATUS`, `NOME`, `CONTA_PAI_ID`, `CONTA_PAI_MATRIZ_ID`, `CONTA_PESSOA_ID`, `TP_PESSOA`, `DT_CRIACAO`) VALUES
	(1, 'A', '1', NULL, NULL, 1, 'J', '2017-06-14 02:03:59'),
	(2, 'A', '111', 1, 1, 1, 'J', '2017-06-14 02:04:24'),
	(3, 'A', '1111', 1, 1, 1, 'J', '2017-06-14 02:04:33'),
	(4, 'A', '112', 2, 1, 1, 'J', '2017-06-14 02:04:59'),
	(5, 'A', '123', 2, 1, 1, 'J', '2017-06-14 02:05:04'),
	(6, 'A', '11', 6, 1, 1, 'J', '2017-06-14 02:05:38'),
	(7, 'A', '2', NULL, NULL, 2, 'j', '2017-06-14 02:14:44'),
	(8, 'A', '22', 7, 7, NULL, NULL, NULL);
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;


# Dumping structure for table test.conta_pessoa
DROP TABLE IF EXISTS `conta_pessoa`;
CREATE TABLE IF NOT EXISTS `conta_pessoa` (
  `CONTA_PESSOA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PESSOA_FISICA_ID` bigint(20) DEFAULT NULL,
  `PESSOA_JURIDICA_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`CONTA_PESSOA_ID`),
  KEY `FK_CONTA_PESSOA_pessoa_fisica` (`PESSOA_FISICA_ID`),
  KEY `FK_CONTA_PESSOA_pessoa_juridica` (`PESSOA_JURIDICA_ID`),
  CONSTRAINT `FK_CONTA_PESSOA_pessoa_fisica` FOREIGN KEY (`PESSOA_FISICA_ID`) REFERENCES `pessoa_fisica` (`PESSOA_FISICA_ID`),
  CONSTRAINT `FK_CONTA_PESSOA_pessoa_juridica` FOREIGN KEY (`PESSOA_JURIDICA_ID`) REFERENCES `pessoa_juridica` (`PESSOA_JURIDICA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

# Dumping data for table test.conta_pessoa: ~4 rows (approximately)
/*!40000 ALTER TABLE `conta_pessoa` DISABLE KEYS */;
INSERT INTO `conta_pessoa` (`CONTA_PESSOA_ID`, `PESSOA_FISICA_ID`, `PESSOA_JURIDICA_ID`) VALUES
	(1, NULL, 1),
	(2, NULL, 1),
	(3, NULL, 1),
	(4, NULL, 1);
/*!40000 ALTER TABLE `conta_pessoa` ENABLE KEYS */;


# Dumping structure for table test.operacao
DROP TABLE IF EXISTS `operacao`;
CREATE TABLE IF NOT EXISTS `operacao` (
  `NU_OPERACAO_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NU_TRANSACAO_ID` bigint(20) NOT NULL,
  `CD_STATUS_OPERACAO` char(2) NOT NULL COMMENT 'A - APRIVADO, N - NEGADO',
  `CD_TIPO_OPERACAO` int(1) NOT NULL,
  `DT_OPERACAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `VL_OPERACAO` double NOT NULL,
  PRIMARY KEY (`NU_OPERACAO_ID`),
  KEY `FK_operacao_transacao` (`NU_TRANSACAO_ID`),
  CONSTRAINT `FK_operacao_transacao` FOREIGN KEY (`NU_TRANSACAO_ID`) REFERENCES `transacao` (`NU_TRANSACAO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table test.operacao: ~0 rows (approximately)
/*!40000 ALTER TABLE `operacao` DISABLE KEYS */;
INSERT INTO `operacao` (`NU_OPERACAO_ID`, `NU_TRANSACAO_ID`, `CD_STATUS_OPERACAO`, `CD_TIPO_OPERACAO`, `DT_OPERACAO`, `VL_OPERACAO`) VALUES
	(1, 10, 'A', 0, '2017-06-15 21:04:10', 500.1),
	(2, 10, 'A', 0, '2017-06-15 21:04:10', 500.1),
	(3, 12, 'A', 0, '2017-06-15 21:40:19', 100),
	(4, 14, 'A', 0, '2017-06-15 21:49:50', 100),
	(5, 20, 'A', 1, '2017-06-15 22:42:05', 500.1),
	(6, 21, 'A', 1, '2017-06-15 22:51:04', 500.1),
	(7, 22, 'A', 1, '2017-06-15 22:56:38', 500.1),
	(8, 23, 'A', 1, '2017-06-15 23:04:39', 10000),
	(9, 24, 'A', 1, '2017-06-15 23:07:19', 10000),
	(10, 26, 'A', 1, '2017-06-15 23:08:20', 10000),
	(11, 27, 'A', 1, '2017-06-15 23:13:52', 50.5);
/*!40000 ALTER TABLE `operacao` ENABLE KEYS */;


# Dumping structure for table test.pessoa_fisica
DROP TABLE IF EXISTS `pessoa_fisica`;
CREATE TABLE IF NOT EXISTS `pessoa_fisica` (
  `PESSOA_FISICA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOME_COMPLETO` varchar(50) DEFAULT NULL,
  `CPF` varchar(30) DEFAULT NULL,
  `DT_NASCIMENTO` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`PESSOA_FISICA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table test.pessoa_fisica: ~0 rows (approximately)
/*!40000 ALTER TABLE `pessoa_fisica` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa_fisica` ENABLE KEYS */;


# Dumping structure for table test.pessoa_juridica
DROP TABLE IF EXISTS `pessoa_juridica`;
CREATE TABLE IF NOT EXISTS `pessoa_juridica` (
  `PESSOA_JURIDICA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RAZAO_SOCIAL` varchar(50) DEFAULT NULL,
  `NOME_FANTASIA` varchar(30) DEFAULT NULL,
  `CNPJ` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`PESSOA_JURIDICA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

# Dumping data for table test.pessoa_juridica: ~4 rows (approximately)
/*!40000 ALTER TABLE `pessoa_juridica` DISABLE KEYS */;
INSERT INTO `pessoa_juridica` (`PESSOA_JURIDICA_ID`, `RAZAO_SOCIAL`, `NOME_FANTASIA`, `CNPJ`) VALUES
	(1, 'HUBFINTECH', 'VALE PRESENTE', '132132100000001-1'),
	(2, 'HUBFINTECH', 'VALE PRESENTE', '132132100000001-1'),
	(3, 'HUBFINTECH', 'VALE PRESENTE', '132132100000001-1'),
	(4, 'HUBFINTECH', 'VALE PRESENTE', '132132100000001-1');
/*!40000 ALTER TABLE `pessoa_juridica` ENABLE KEYS */;


# Dumping structure for table test.saldo
DROP TABLE IF EXISTS `saldo`;
CREATE TABLE IF NOT EXISTS `saldo` (
  `SALDO_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CONTA_ID` bigint(20) NOT NULL,
  `SALDO` double NOT NULL DEFAULT '0',
  `DH_ATUALIZACAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`SALDO_ID`),
  KEY `FK__conta` (`CONTA_ID`),
  CONSTRAINT `FK__conta` FOREIGN KEY (`CONTA_ID`) REFERENCES `conta` (`CONTA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

# Dumping data for table test.saldo: ~22 rows (approximately)
/*!40000 ALTER TABLE `saldo` DISABLE KEYS */;
INSERT INTO `saldo` (`SALDO_ID`, `CONTA_ID`, `SALDO`, `DH_ATUALIZACAO`) VALUES
	(1, 1, 1000, '2017-06-14 02:07:41'),
	(2, 1, 10000, '2017-06-14 02:08:20'),
	(3, 2, 10000, '2017-06-14 02:09:06'),
	(5, 2, 1500, '2017-06-10 13:10:31'),
	(6, 3, 50000, '2017-06-13 02:11:07'),
	(7, 3, 30000, '2017-06-14 02:11:23'),
	(8, 4, 8000, '2017-06-14 02:11:53'),
	(9, 5, 800, '2017-06-14 02:12:07'),
	(10, 6, 9000, '2017-06-14 02:12:21'),
	(11, 5, 2000, '2017-06-15 17:59:06'),
	(12, 5, 3020, '2017-06-15 17:59:29'),
	(13, 5, 4000.6, '2017-06-15 18:00:18'),
	(14, 2, 3000, '2017-06-15 19:03:06'),
	(15, 2, 999.9, '2017-06-15 20:29:55'),
	(16, 2, 2000.1, '2017-06-15 20:30:22'),
	(17, 2, 999.9, '2017-06-15 20:36:03'),
	(18, 2, 999.9, '2017-06-15 20:38:11'),
	(19, 2, 2000.1, '2017-06-15 20:38:48'),
	(20, 2, 999.9, '2017-06-15 20:40:01'),
	(21, 2, 2000.1, '2017-06-15 20:40:03'),
	(22, 2, 999.9, '2017-06-15 20:42:23'),
	(23, 2, 2000.1, '2017-06-15 20:42:25'),
	(24, 2, 999.9, '2017-06-15 20:52:16'),
	(25, 2, 2000.1, '2017-06-15 20:52:16'),
	(26, 2, 999.9, '2017-06-15 20:59:18'),
	(27, 2, 2000.1, '2017-06-15 20:59:18'),
	(28, 2, 999.9, '2017-06-15 21:04:10'),
	(29, 2, 2000.1, '2017-06-15 21:04:10'),
	(30, 2, 1400, '2017-06-15 21:40:19'),
	(31, 2, 1600, '2017-06-15 21:40:19'),
	(32, 2, 2900, '2017-06-15 21:49:50'),
	(33, 5, 3000, '2017-06-15 21:49:50'),
	(34, 1, 1000, '2017-06-14 00:00:00'),
	(35, 1, 1000, '2017-06-14 00:00:00'),
	(36, 1, 1000, '2017-06-14 00:00:00'),
	(37, 1, 1000, '2017-06-14 00:00:00'),
	(38, 1, 1000, '2017-06-14 00:00:00'),
	(39, 1, 1000, '2017-06-14 00:00:00'),
	(40, 1, 1000, '2017-06-14 00:00:00'),
	(41, 1, 11000, '2017-06-15 23:11:26'),
	(42, 1, 11050.5, '2017-06-15 23:13:52');
/*!40000 ALTER TABLE `saldo` ENABLE KEYS */;


# Dumping structure for table test.transacao
DROP TABLE IF EXISTS `transacao`;
CREATE TABLE IF NOT EXISTS `transacao` (
  `NU_TRANSACAO_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DT_TRANSACAO` timestamp NULL DEFAULT NULL,
  `VL_TRANSACAO` double DEFAULT NULL,
  PRIMARY KEY (`NU_TRANSACAO_ID`),
  KEY `Index 2` (`DT_TRANSACAO`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

# Dumping data for table test.transacao: ~7 rows (approximately)
/*!40000 ALTER TABLE `transacao` DISABLE KEYS */;
INSERT INTO `transacao` (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `VL_TRANSACAO`) VALUES
	(1, '2017-06-14 02:03:59', 0),
	(2, '2017-06-14 02:04:14', 0),
	(3, '2017-06-14 02:04:24', 0),
	(4, '2017-06-14 02:04:33', 0),
	(5, '2017-06-15 20:30:37', NULL),
	(6, '2017-06-15 20:40:06', NULL),
	(7, '2017-06-15 20:42:27', NULL),
	(8, '2017-06-15 20:52:16', NULL),
	(9, '2017-06-15 20:59:18', NULL),
	(10, '2017-06-15 21:04:10', NULL),
	(11, '2017-06-15 21:06:02', NULL),
	(12, '2017-06-15 21:40:19', NULL),
	(13, '2017-06-15 21:40:19', NULL),
	(14, '2017-06-15 21:49:50', NULL),
	(15, '2017-06-15 21:49:54', NULL),
	(16, '2017-06-15 22:25:50', NULL),
	(17, '2017-06-15 22:29:44', NULL),
	(18, '2017-06-15 22:35:23', NULL),
	(19, '2017-06-15 22:35:50', NULL),
	(20, '2017-06-15 22:42:13', NULL),
	(21, '2017-06-15 22:51:04', NULL),
	(22, '2017-06-15 22:56:44', NULL),
	(23, '2017-06-15 23:04:39', NULL),
	(24, '2017-06-15 23:07:19', NULL),
	(25, '2017-06-15 23:09:01', NULL),
	(26, '2017-06-15 23:11:18', NULL),
	(27, '2017-06-15 23:13:52', NULL);
/*!40000 ALTER TABLE `transacao` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;