/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.1.53-community : Database - 118
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`118` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `118`;

/*Table structure for table `calcforce` */

DROP TABLE IF EXISTS `calcforce`;

CREATE TABLE `calcforce` (
  `Datetime` datetime NOT NULL,
  `Hforce1` float NOT NULL,
  `Hforce2` float NOT NULL,
  `Hforce3` float NOT NULL,
  `Hforce4` float NOT NULL,
  `Hforce5` float NOT NULL,
  `Hforce6` float NOT NULL,
  `Hforce7` float NOT NULL,
  `Hforce8` float NOT NULL,
  `Hforce9` float NOT NULL,
  `Hforce10` float NOT NULL,
  `Hforce11` float NOT NULL,
  `Hforce12` float NOT NULL,
  `Vforce1` float NOT NULL,
  `Vforce2` float NOT NULL,
  `Vforce3` float NOT NULL,
  `Vforce4` float NOT NULL,
  `Vforce5` float NOT NULL,
  `Vforce6` float NOT NULL,
  `Vforce7` float NOT NULL,
  `Vforce8` float NOT NULL,
  `Vforce9` float NOT NULL,
  `Vforce10` float NOT NULL,
  `Vforce11` float NOT NULL,
  `Vforce12` float NOT NULL,
  `Tension1` float NOT NULL,
  `Tension2` float NOT NULL,
  `Tension3` float NOT NULL,
  `Tension4` float NOT NULL,
  `Tension5` float NOT NULL,
  `Tension6` float NOT NULL,
  `Tension7` float NOT NULL,
  `Tension8` float NOT NULL,
  `Tension9` float NOT NULL,
  `Tension10` float NOT NULL,
  `Tension11` float NOT NULL,
  `Tension12` float NOT NULL,
  `Hdiscal1` float NOT NULL,
  `Hdiscal2` float NOT NULL,
  `Hdiscal3` float NOT NULL,
  `Hdiscal4` float NOT NULL,
  `Hdiscal5` float NOT NULL,
  `Hdiscal6` float NOT NULL,
  `Hdiscal7` float NOT NULL,
  `Hdiscal8` float NOT NULL,
  `Hdiscal9` float NOT NULL,
  `Hdiscal10` float NOT NULL,
  `Hdiscal11` float NOT NULL,
  `Hdiscal12` float NOT NULL,
  `Vdiscal1` float NOT NULL,
  `Vdiscal2` float NOT NULL,
  `Vdiscal3` float NOT NULL,
  `Vdiscal4` float NOT NULL,
  `Vdiscal5` float NOT NULL,
  `Vdiscal6` float NOT NULL,
  `Vdiscal7` float NOT NULL,
  `Vdiscal8` float NOT NULL,
  `Vdiscal9` float NOT NULL,
  `Vdiscal10` float NOT NULL,
  `Vdiscal11` float NOT NULL,
  `Vdiscal12` float NOT NULL,
  PRIMARY KEY (`Datetime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `gpsfpd` */

DROP TABLE IF EXISTS `gpsfpd`;

CREATE TABLE `gpsfpd` (
  `DateTime` varchar(25) NOT NULL,
  `Heading` float NOT NULL,
  `Roll` float NOT NULL,
  `Pitch` float NOT NULL,
  `Latitude` float NOT NULL,
  `Longitude` float NOT NULL,
  `Altitude` float NOT NULL,
  `Ve` float NOT NULL,
  `Vn` float NOT NULL,
  `Vu` float NOT NULL,
  `Baseline` float NOT NULL,
  `spmx` float NOT NULL,
  `spmy` float NOT NULL,
  `spmz` float NOT NULL,
  `aftx` float NOT NULL,
  `afty` float NOT NULL,
  `aftz` float NOT NULL,
  `sway` float NOT NULL,
  `surge` float NOT NULL,
  `heave` float NOT NULL,
  PRIMARY KEY (`DateTime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `gpsimu` */

DROP TABLE IF EXISTS `gpsimu`;

CREATE TABLE `gpsimu` (
  `DateTime` varchar(25) NOT NULL,
  `GyroX` float NOT NULL,
  `GyroY` float NOT NULL,
  `GyroZ` float NOT NULL,
  `AccX` float NOT NULL,
  `AccY` float NOT NULL,
  `AccZ` float NOT NULL,
  `Tpr` float NOT NULL,
  PRIMARY KEY (`DateTime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `heave` */

DROP TABLE IF EXISTS `heave`;

CREATE TABLE `heave` (
  `Datetime` varchar(25) NOT NULL,
  `heave` float NOT NULL,
  PRIMARY KEY (`Datetime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `inclinometer` */

DROP TABLE IF EXISTS `inclinometer`;

CREATE TABLE `inclinometer` (
  `DateTime` varchar(25) NOT NULL,
  `v1` float NOT NULL,
  `v2` float NOT NULL,
  `v3` float NOT NULL,
  `v4` float NOT NULL,
  `v5` float NOT NULL,
  `v6` float NOT NULL,
  `v7` float NOT NULL,
  `v8` float NOT NULL,
  `v9` float NOT NULL,
  `v10` float NOT NULL,
  `v11` float NOT NULL,
  `v12` float NOT NULL,
  PRIMARY KEY (`DateTime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `datetime` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `log` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `statistics` */

DROP TABLE IF EXISTS `statistics`;

CREATE TABLE `statistics` (
  `datetime` datetime NOT NULL,
  `windspeed` float NOT NULL,
  `winddir` float NOT NULL,
  `hthird` float NOT NULL,
  `tthird` float NOT NULL,
  `roll` float NOT NULL,
  `pitch` float NOT NULL,
  `eastpos` float NOT NULL,
  `northpos` float NOT NULL,
  `sway` float NOT NULL,
  `surge` float NOT NULL,
  `v1` float NOT NULL,
  `v2` float NOT NULL,
  `v3` float NOT NULL,
  `v4` float NOT NULL,
  `v5` float NOT NULL,
  `v6` float NOT NULL,
  `v7` float NOT NULL,
  `v8` float NOT NULL,
  `v9` float NOT NULL,
  `v10` float NOT NULL,
  `v11` float NOT NULL,
  `v12` float NOT NULL,
  PRIMARY KEY (`datetime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `temperature` */

DROP TABLE IF EXISTS `temperature`;

CREATE TABLE `temperature` (
  `DateTime` datetime NOT NULL,
  `tem` float NOT NULL,
  `humidity` float NOT NULL,
  `bar` float NOT NULL,
  PRIMARY KEY (`DateTime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `warnings` */

DROP TABLE IF EXISTS `warnings`;

CREATE TABLE `warnings` (
  `datetime` datetime NOT NULL,
  `warning` varchar(45) NOT NULL,
  PRIMARY KEY (`datetime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `waveradar` */

DROP TABLE IF EXISTS `waveradar`;

CREATE TABLE `waveradar` (
  `Datetime` datetime NOT NULL,
  `HDiv3` float DEFAULT NULL,
  `TDiv3` float DEFAULT NULL,
  `Hm0` float DEFAULT NULL,
  `Tm02` float DEFAULT NULL,
  `Hmax` float DEFAULT NULL,
  `H10` float DEFAULT NULL,
  `Ngd_zP` float DEFAULT NULL,
  `AV10_H` float DEFAULT NULL,
  PRIMARY KEY (`Datetime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `waveradarsp` */

DROP TABLE IF EXISTS `waveradarsp`;

CREATE TABLE `waveradarsp` (
  `Datetime` datetime NOT NULL,
  `v1` float NOT NULL,
  `v2` float NOT NULL,
  `v3` float NOT NULL,
  `v4` float NOT NULL,
  `v5` float NOT NULL,
  `v6` float NOT NULL,
  `v7` float NOT NULL,
  `v8` float NOT NULL,
  `v9` float NOT NULL,
  `v10` float NOT NULL,
  `v11` float NOT NULL,
  `v12` float NOT NULL,
  `v13` float NOT NULL,
  `v14` float NOT NULL,
  `v15` float NOT NULL,
  `v16` float NOT NULL,
  `v17` float NOT NULL,
  `v18` float NOT NULL,
  `v19` float NOT NULL,
  `v20` float NOT NULL,
  `v21` float NOT NULL,
  `v22` float NOT NULL,
  `v23` float NOT NULL,
  `v24` float NOT NULL,
  `v25` float NOT NULL,
  `v26` float NOT NULL,
  `v27` float NOT NULL,
  `v28` float NOT NULL,
  `v29` float NOT NULL,
  `v30` float NOT NULL,
  `v31` float NOT NULL,
  `v32` float NOT NULL,
  `v33` float NOT NULL,
  `v34` float NOT NULL,
  `v35` float NOT NULL,
  `v36` float NOT NULL,
  `v37` float NOT NULL,
  `v38` float NOT NULL,
  `v39` float NOT NULL,
  `v40` float NOT NULL,
  `v41` float NOT NULL,
  `v42` float NOT NULL,
  `v43` float NOT NULL,
  `v44` float NOT NULL,
  `v45` float NOT NULL,
  `v46` float NOT NULL,
  `v47` float NOT NULL,
  `v48` float NOT NULL,
  `v49` float NOT NULL,
  `v50` float NOT NULL,
  `v51` float NOT NULL,
  PRIMARY KEY (`Datetime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `windsensor` */

DROP TABLE IF EXISTS `windsensor`;

CREATE TABLE `windsensor` (
  `DateTime` datetime NOT NULL,
  `windspeed` float NOT NULL,
  `winddir` float NOT NULL,
  PRIMARY KEY (`DateTime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
