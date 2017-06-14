# --------------------------------------------------------
# Host:                         127.0.0.1
# Server version:               5.5.56
# Server OS:                    Win64
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2017-06-14 08:17:50
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
	(1, '', '1', NULL, NULL, 1, 'J', '2017-06-14 02:03:59'),
	(2, '', '111', 1, 1, 1, 'J', '2017-06-14 02:04:24'),
	(3, '', '1111', 1, 1, 1, 'J', '2017-06-14 02:04:33'),
	(4, '', '112', 2, 1, 1, 'J', '2017-06-14 02:04:59'),
	(5, '', '123', 2, 1, 1, 'J', '2017-06-14 02:05:04'),
	(6, '', '11', 6, 1, 1, 'J', '2017-06-14 02:05:38'),
	(7, '', '2', NULL, NULL, 2, 'j', '2017-06-14 02:14:44'),
	(8, '', '22', 7, 7, NULL, NULL, NULL);
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
  `NU_OPERCAO_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NU_TRANSACAO_ID` bigint(20) NOT NULL,
  `CD_APORTE` varchar(50) DEFAULT NULL,
  `CD_STATUS_OPERACAO` char(2) NOT NULL COMMENT 'A - APROVADO, N - NEGADO',
  `CD_TIPO_OPERACAO` int(1) NOT NULL,
  `DT_OPERACAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `VL_OPERACAO` double NOT NULL,
  PRIMARY KEY (`NU_OPERCAO_ID`),
  KEY `FK_operacao_transacao` (`NU_TRANSACAO_ID`),
  CONSTRAINT `FK_operacao_transacao` FOREIGN KEY (`NU_TRANSACAO_ID`) REFERENCES `transacao` (`NU_TRANSACAO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table test.operacao: ~0 rows (approximately)
/*!40000 ALTER TABLE `operacao` DISABLE KEYS */;
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
  `CONTA_ID` bigint(20) DEFAULT NULL,
  `SALDO` double DEFAULT NULL,
  `DH_ATUALIZACAO` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`SALDO_ID`),
  KEY `FK__conta` (`CONTA_ID`),
  CONSTRAINT `FK__conta` FOREIGN KEY (`CONTA_ID`) REFERENCES `conta` (`CONTA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

# Dumping data for table test.saldo: ~9 rows (approximately)
/*!40000 ALTER TABLE `saldo` DISABLE KEYS */;
INSERT INTO `saldo` (`SALDO_ID`, `CONTA_ID`, `SALDO`, `DH_ATUALIZACAO`) VALUES
	(1, 1, 1000, '2017-06-14 02:07:41'),
	(2, 1, 10000, '2017-06-14 02:08:20'),
	(3, 2, 10000, '2017-06-14 02:09:06'),
	(5, 2, 1500, '2017-06-20 13:10:31'),
	(6, 3, 50000, '2017-06-13 02:11:07'),
	(7, 3, 30000, '2017-06-14 02:11:23'),
	(8, 4, 8000, '2017-06-14 02:11:53'),
	(9, 5, 800, '2017-06-14 02:12:07'),
	(10, 6, 9000, '2017-06-14 02:12:21');
/*!40000 ALTER TABLE `saldo` ENABLE KEYS */;


# Dumping structure for table test.transacao
DROP TABLE IF EXISTS `transacao`;
CREATE TABLE IF NOT EXISTS `transacao` (
  `NU_TRANSACAO_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DT_TRANSACAO` timestamp NULL DEFAULT NULL,
  `VL_TRANSACAO` double DEFAULT NULL,
  PRIMARY KEY (`NU_TRANSACAO_ID`),
  KEY `Index 2` (`DT_TRANSACAO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

# Dumping data for table test.transacao: ~4 rows (approximately)
/*!40000 ALTER TABLE `transacao` DISABLE KEYS */;
INSERT INTO `transacao` (`NU_TRANSACAO_ID`, `DT_TRANSACAO`, `VL_TRANSACAO`) VALUES
	(1, '2017-06-14 02:03:59', 10),
	(2, '2017-06-14 02:04:14', 10),
	(3, '2017-06-14 02:04:24', 10),
	(4, '2017-06-14 02:04:33', 10);
/*!40000 ALTER TABLE `transacao` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
