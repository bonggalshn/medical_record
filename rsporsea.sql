/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 10.1.21-MariaDB : Database - rs_porsea
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rs_porsea` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `rs_porsea`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(294);

/*Table structure for table `jadwal_dokter` */

DROP TABLE IF EXISTS `jadwal_dokter`;

CREATE TABLE `jadwal_dokter` (
  `id_jadwal` int(11) NOT NULL AUTO_INCREMENT,
  `jam_mulai` varchar(10) DEFAULT NULL,
  `jam_selesai` varchar(10) DEFAULT NULL,
  `jumat` int(11) DEFAULT '0',
  `kamis` int(11) DEFAULT '0',
  `keterangan` varchar(100) DEFAULT NULL,
  `minggu` int(11) DEFAULT '0',
  `nama_dokter` int(11) DEFAULT NULL,
  `rabu` int(11) DEFAULT '0',
  `sabtu` int(11) DEFAULT '0',
  `selasa` int(11) DEFAULT '0',
  `senin` int(11) DEFAULT '0',
  `status` varchar(25) DEFAULT 'Aktif',
  `opt_version` int(11) DEFAULT '0',
  PRIMARY KEY (`id_jadwal`),
  KEY `nama_dokter` (`nama_dokter`),
  CONSTRAINT `jadwal_dokter_ibfk_1` FOREIGN KEY (`nama_dokter`) REFERENCES `t_dokter` (`id_dokter`)
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=latin1;

/*Data for the table `jadwal_dokter` */

insert  into `jadwal_dokter`(`id_jadwal`,`jam_mulai`,`jam_selesai`,`jumat`,`kamis`,`keterangan`,`minggu`,`nama_dokter`,`rabu`,`sabtu`,`selasa`,`senin`,`status`,`opt_version`) values 
(204,'08:00','14:00',1,1,'',1,65,1,1,1,1,'Aktif',3),
(205,'08:00','14:00',1,1,'',0,73,1,1,1,1,'Aktif',0),
(206,'08:00','14:00',1,1,'',0,185,1,1,1,1,'Aktif',0),
(207,'08:00','14:00',1,1,'',0,186,1,1,1,1,'Aktif',0),
(208,'08:00','14:00',1,1,'',0,187,1,1,1,1,'Aktif',0),
(209,'08:00','14:00',1,1,'',0,188,1,1,1,1,'Aktif',0),
(210,'08:00','14:00',1,1,'',0,189,1,1,1,1,'Aktif',0),
(211,'08:00','14:00',1,1,'',0,190,1,1,1,1,'Aktif',0),
(212,'08:00','14:00',1,1,'',0,191,1,1,1,1,'Aktif',0),
(213,'08:00','14:00',1,1,'On Call 24 Jam',0,192,1,1,1,1,'Aktif',0),
(214,'08:00','14:00',0,0,'On Call 24 Jam',0,193,1,0,1,1,'Aktif',0),
(215,'08:00','14:00',1,1,'On Call 24 Jam',0,194,0,1,0,0,'Aktif',0),
(216,'08:00','14:00',1,1,'',0,195,1,1,1,1,'Aktif',0),
(217,'08:00','14:00',1,1,'',0,196,1,1,1,1,'Aktif',0),
(219,'08:00','14:00',1,1,'',0,218,1,1,1,1,'Aktif',0),
(220,'08:00','14:00',1,1,'',0,197,1,1,1,1,'Aktif',0),
(221,'08:00','14:00',1,1,'',0,198,1,1,1,1,'Aktif',0),
(222,'08:00','14:00',1,1,'',0,199,1,1,1,1,'Aktif',0),
(223,'08:00','13:00',1,0,'',0,200,0,0,0,0,'Aktif',0),
(224,'08:00','14:00',0,0,'',0,201,1,0,1,0,'Aktif',0),
(225,'08:00','13:00',0,0,'On Call 24 Jam',0,202,0,0,1,0,'Aktif',1),
(226,'13:00','00:00',0,1,'On Call 24 Jam',0,202,1,0,0,0,'Aktif',0),
(227,'08:00','11:00',0,0,'',0,203,0,0,1,1,'Aktif',0),
(228,'13:00','00:00',0,0,'',0,203,1,0,0,0,'Aktif',0),
(232,'08:00','14:00',1,1,'',0,56,1,1,1,1,'Aktif',0),
(233,'08:00','14:00',1,1,'',0,116,1,1,1,1,'Aktif',0),
(265,'08:00','14:00',0,1,'',0,195,1,0,1,1,'Aktif',0),
(266,'08:00','14:00',0,0,'',0,54,0,0,1,1,'Tidak Aktif',2),
(274,'10:00','17:00',NULL,NULL,'',NULL,54,1,NULL,1,1,'Aktif',4),
(275,'09:09','09:09',NULL,NULL,'',NULL,54,NULL,NULL,NULL,NULL,'Tidak Aktif',1),
(276,'09:09','09:09',1,NULL,'',NULL,54,NULL,1,NULL,NULL,'Aktif',1);

/*Table structure for table `t_akun` */

DROP TABLE IF EXISTS `t_akun`;

CREATE TABLE `t_akun` (
  `id_akun` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(10) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`id_akun`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `t_akun` */

insert  into `t_akun`(`id_akun`,`role`,`username`,`password`) values 
(1,'Admin','admin','admin123'),
(2,'RekamMedik','rekammedik','medik123'),
(3,'Loket','loket','loket123'),
(4,'TataUsaha','tatausaha','tatausaha123');

/*Table structure for table `t_dokter` */

DROP TABLE IF EXISTS `t_dokter`;

CREATE TABLE `t_dokter` (
  `id_dokter` int(11) NOT NULL,
  `nip` varchar(25) DEFAULT NULL,
  `nama_dokter` varchar(40) DEFAULT NULL,
  `spesialis_dokter` varchar(40) DEFAULT NULL,
  `tanggal_lahir_dokter` datetime DEFAULT NULL,
  `opt_version` int(11) DEFAULT '0',
  `alamat` varchar(25) DEFAULT NULL,
  `jenis_kelamin` varchar(25) DEFAULT NULL,
  `tempat_lahir` varchar(25) DEFAULT NULL,
  `no_telepon` varchar(25) DEFAULT NULL,
  `status` varchar(25) DEFAULT 'Aktif',
  PRIMARY KEY (`id_dokter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_dokter` */

insert  into `t_dokter`(`id_dokter`,`nip`,`nama_dokter`,`spesialis_dokter`,`tanggal_lahir_dokter`,`opt_version`,`alamat`,`jenis_kelamin`,`tempat_lahir`,`no_telepon`,`status`) values 
(54,'192900349910020','dr. Irwan Simatupang','Umum','1984-01-23 00:00:00',11,'Laguboti','Pria','Balige','085278529371','Aktif'),
(56,'119340277723013','dr. Murni Harianja','Umum','1977-09-12 00:00:00',4,'Porsea','Wanita','Medan','081387345092','Aktif'),
(63,'143546578980954','dr. Desmonia T. Damanik, SpP','Paru','1981-01-15 00:00:00',10,'Laguboti','Wanita','Laguboti','','Aktif'),
(64,'188718729300234','Dr. Strange','THT','0001-01-01 00:00:00',4,'Porsea','Pria','Laguboti','213534523','Tidak Aktif'),
(65,'126534564345403','dr. Yunita V. Tampubolon, SpPd','Penyakit Dalam / Internis','1981-01-01 00:00:00',4,'-','Wanita','-','-','Aktif'),
(73,'123345345034091','dr. Gopas M. Simanjuntak, SpPd','Penyakit Dalam / Internis','1981-01-01 00:00:00',2,'-','Pria','-','-','Aktif'),
(116,'172678826392619','dr. Ismail N. Nainggolan','Umum','1981-01-01 00:00:00',1,'-','Pria','Balige','-','Aktif'),
(184,'7767','jhfhfhjfhj','jffjh','2018-06-09 00:00:00',1,'gfjf','Pria','hjf','','Tidak Aktif'),
(185,'817263540928394','dr. Martuani Hutabarat, SpOG','Kebidanan & Kandungan','1981-01-01 00:00:00',2,'-','Wanita','-','-','Aktif'),
(186,'-','dr. Sahat Siburian, SpOG','Kebidanan & Kandungan','1981-01-01 00:00:00',0,'-','Pria','-','-','Aktif'),
(187,'-','dr. Thrisna, SpOG','Kebidanan & Kandungan','1981-01-01 00:00:00',0,'-','Wanita','-','-','Aktif'),
(188,'-','dr. Flora M. Panjaitan, SpA','Anak','1981-01-01 00:00:00',0,'-','Wanita','-','-','Aktif'),
(189,'-','dr. Laily Munawwarah, SpA','Anak','1981-01-01 00:00:00',0,'-','Wanita','-','-','Aktif'),
(190,'3183769379821','dr. Pantas Martin Saing, SpA','Anak','1981-01-01 00:00:00',1,'-','Pria','-','-','Aktif'),
(191,'-','dr. Dame Lamtiur Sitompul, SpA','Anak','1981-01-01 00:00:00',0,'-','Wanita','-','-','Aktif'),
(192,'-','dr. Reynold Sianturi, SpB','Bedah Umum','1981-01-01 00:00:00',0,'-','Pria','-','-','Aktif'),
(193,'-','dr. Saut Hutasoit, SpAn','Anastesi','1981-01-01 00:00:00',0,'-','Pria','-','-','Aktif'),
(194,'-','dr. Taor Leonardo Marpaung, SpAn','Anastesi','1981-01-01 00:00:00',0,'-','Pria','-','-','Aktif'),
(195,'-','dr. Dahliani Waruwu, SpPA','Patologi Anatomi','1981-01-01 00:00:00',0,'-','Wanita','-','-','Aktif'),
(196,'-','dr. Jumala Marpaung, SpPK','Patologi Klinis / Laboratorium','1981-01-01 00:00:00',0,'-','Pria','-','-','Aktif'),
(197,'-','dr. Yusak P. Simanjuntak, SpKJ','Psikiater / Jiwa','1981-01-01 00:00:00',0,'-','Pria','-','-','Aktif'),
(198,'-','dr. Poltak Jeremias Sirait, SpKJ','Psikiater / Jiwa','1981-01-01 00:00:00',0,'-','Pria','-','-','Aktif'),
(199,'-','dr. Rahel M. Sitorus, SpRad','Radiologi','1981-01-01 00:00:00',0,'-','Wanita','-','-','Aktif'),
(200,'-','dr. Januar Sitorus, SpM','Mata','1997-01-01 00:00:00',0,'-','Pria','-','-','Aktif'),
(201,'-','dr. Toman Simamora, SpTHT-KL','THT-KL','1981-01-01 00:00:00',0,'-','Pria','-','-','Aktif'),
(202,'-','dr. Erwin Sinaga, SpJP','Jantung dan Pembuluh Darah','1981-01-01 00:00:00',0,'-','Pria','-','-','Aktif'),
(203,'-','dr. Feryary Diploma Sembiring, SpS','Saraf / Neurologi','1981-01-01 00:00:00',0,'-','Pria','-','-','Aktif'),
(218,'-','dr. Pita Omas Lumban Gaol, SpPK','Patologi Klinis / Laboratorium','1981-01-01 00:00:00',0,'-','Wanita','-','-','Aktif');

/*Table structure for table `t_jadwal_dokter` */

DROP TABLE IF EXISTS `t_jadwal_dokter`;

CREATE TABLE `t_jadwal_dokter` (
  `id_jadwal` int(11) NOT NULL,
  `hari_mulai` varchar(255) DEFAULT NULL,
  `hari_selesai` varchar(255) DEFAULT NULL,
  `nama_dokter` int(11) DEFAULT NULL,
  `jam_mulai` varchar(255) DEFAULT NULL,
  `jam_selesai` varchar(255) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `opt_version` int(11) DEFAULT '0',
  `status` varchar(20) DEFAULT 'Aktif',
  PRIMARY KEY (`id_jadwal`),
  KEY `t_jadwal_dokter_ibfk_1` (`nama_dokter`),
  CONSTRAINT `t_jadwal_dokter_ibfk_1` FOREIGN KEY (`nama_dokter`) REFERENCES `t_dokter` (`id_dokter`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_jadwal_dokter` */

/*Table structure for table `t_jadwal_dokter_pengganti` */

DROP TABLE IF EXISTS `t_jadwal_dokter_pengganti`;

CREATE TABLE `t_jadwal_dokter_pengganti` (
  `id_jadwal_pengganti` int(11) NOT NULL,
  `nama_dokter_berhalangan` int(11) DEFAULT NULL,
  `nama_dokter_pengganti` int(11) DEFAULT NULL,
  `tanggal_pergantian_mulai` date DEFAULT NULL,
  `opt_version` int(11) DEFAULT '0',
  `keterangan` varchar(255) DEFAULT NULL,
  `tanggal_pergantian_selesai` date DEFAULT NULL,
  `status` varchar(20) DEFAULT 'Aktif',
  PRIMARY KEY (`id_jadwal_pengganti`),
  KEY `t_jadwal_dokter_pengganti_ibfk_1` (`nama_dokter_berhalangan`),
  KEY `t_jadwal_dokter_pengganti_ibfk_2` (`nama_dokter_pengganti`),
  CONSTRAINT `t_jadwal_dokter_pengganti_ibfk_1` FOREIGN KEY (`nama_dokter_berhalangan`) REFERENCES `t_dokter` (`id_dokter`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `t_jadwal_dokter_pengganti_ibfk_2` FOREIGN KEY (`nama_dokter_pengganti`) REFERENCES `t_dokter` (`id_dokter`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_jadwal_dokter_pengganti` */

insert  into `t_jadwal_dokter_pengganti`(`id_jadwal_pengganti`,`nama_dokter_berhalangan`,`nama_dokter_pengganti`,`tanggal_pergantian_mulai`,`opt_version`,`keterangan`,`tanggal_pergantian_selesai`,`status`) values 
(268,73,65,'2018-06-10',2,'','2018-06-13','Aktif'),
(286,65,73,'2018-06-01',2,'','2018-06-30','Tidak Aktif'),
(287,54,56,'2018-06-01',0,'','2018-06-30','Aktif'),
(288,54,116,'2018-06-12',0,'','2018-06-22','Aktif'),
(289,116,54,'2018-06-01',0,'','2018-06-30','Aktif');

/*Table structure for table `t_pasien` */

DROP TABLE IF EXISTS `t_pasien`;

CREATE TABLE `t_pasien` (
  `nomor_rekam_medik` varchar(15) DEFAULT NULL,
  `id_pasien` int(11) NOT NULL,
  `alamat` varchar(25) DEFAULT NULL,
  `nama_pasien` varchar(50) DEFAULT NULL,
  `nik` varchar(25) DEFAULT NULL,
  `jenis_kelamin` varchar(25) DEFAULT NULL,
  `pekerjaan` varchar(25) DEFAULT NULL,
  `tanggal_lahir` date DEFAULT NULL,
  `tempat_lahir` varchar(25) DEFAULT NULL,
  `opt_version` int(11) DEFAULT '0',
  `status` varchar(25) DEFAULT 'Aktif',
  PRIMARY KEY (`id_pasien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_pasien` */

insert  into `t_pasien`(`nomor_rekam_medik`,`id_pasien`,`alamat`,`nama_pasien`,`nik`,`jenis_kelamin`,`pekerjaan`,`tanggal_lahir`,`tempat_lahir`,`opt_version`,`status`) values 
(NULL,0,'Balige','Johan Sitanggang','9812739812739','Pria','','1991-06-06','Balige',1,'Tidak Aktif'),
(NULL,163,'IT Del','Bonggal Baringin Siahaan','12981928301923','Pria','Mahasiswa','1997-01-09','Balige',7,'Aktif'),
(NULL,165,'IT Del','Riris Hasibuan','12090901232','Wanita','Mahasiswa','1997-12-15','Laguboti',1,'Aktif'),
(NULL,166,'IT Del','Joe Allen Butarbutar','29389218302','Pria','Mahasiswa','1997-08-27','Porsea',0,'Aktif'),
(NULL,167,'IT Del','Aldoni Hutapea','9209102991213','Pria','Mahasiswa','1997-06-14','Sipahutar',0,'Aktif'),
(NULL,176,'Laguboti','Test','123','Wanita','','2018-06-02','Balige',4,'Tidak Aktif'),
(NULL,181,'gfg','gfh','677678','Pria','','2018-06-07','gffhj',1,'Tidak Aktif'),
(NULL,237,'Lumban Lobu','Riski H. Tambun','1029830918392','Pria','','1997-12-07','Lumban Lobu',0,'Aktif'),
(NULL,238,'Balige','Osman Aritonang','56787981722198','Pria','','1952-01-06','Balige',0,'Aktif'),
(NULL,239,'Sigumpar','Rosita Sibarani','9238198309182','Wanita','','1942-04-07','Sigumpar',0,'Aktif'),
(NULL,240,'Lumban Lobu','Adat Manalu','9182839182903','Pria','','1983-04-20','Lumban Lobu',0,'Aktif'),
(NULL,241,'Pintu Pohan','Lamria Marpaung','0012309381902','Wanita','','1958-12-22','Pintu Pohan',0,'Aktif'),
(NULL,242,'Porsea','Syahden Sinambela','012302931893','Pria','','1970-10-11','Porsea',0,'Aktif'),
(NULL,243,'Parparean I','Hirim Hutapea','001239901201','Wanita','','1953-12-31','Parparean I',0,'Aktif'),
(NULL,244,'Porsea','Saut Siagian','8927318793182','Pria','','1961-04-15','Porsea',0,'Aktif'),
(NULL,262,'Laguboti','Mr. Bean','0000046567125632','Pria','Mahasiswa','1997-06-17','Balige',3,'Tidak Aktif'),
(NULL,263,'Balige','Bonggal','1234567','Pria','Mahasiswa','2018-02-06','Balige ',0,'Aktif');

/*Table structure for table `t_pengobatan_pasien_rawat_inap` */

DROP TABLE IF EXISTS `t_pengobatan_pasien_rawat_inap`;

CREATE TABLE `t_pengobatan_pasien_rawat_inap` (
  `id_pengobatan_rawat_inap` int(11) NOT NULL AUTO_INCREMENT,
  `berat_inap` int(11) DEFAULT NULL,
  `detail_inap` varchar(100) DEFAULT NULL,
  `diagnosa` text,
  `dokter_pemeriksa_rawat_inap` int(11) DEFAULT NULL,
  `id_pasien` int(11) DEFAULT NULL,
  `jenis_perawatan_pasien_rawat_inap` varchar(25) DEFAULT NULL,
  `keterangan` varchar(100) DEFAULT NULL,
  `proses_keluar` varchar(50) DEFAULT NULL,
  `suhu_inap` int(11) DEFAULT NULL,
  `tanggal_masuk` date DEFAULT NULL,
  `tekanan_darah_inap` int(11) DEFAULT NULL,
  `opt_version` int(11) DEFAULT '0',
  `status` varchar(25) DEFAULT 'Aktif',
  PRIMARY KEY (`id_pengobatan_rawat_inap`),
  KEY `id_pasien` (`id_pasien`,`dokter_pemeriksa_rawat_inap`),
  KEY `id_dokter_inap` (`dokter_pemeriksa_rawat_inap`),
  CONSTRAINT `t_pengobatan_pasien_rawat_inap_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `t_pasien` (`id_pasien`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_pengobatan_pasien_rawat_inap_ibfk_2` FOREIGN KEY (`dokter_pemeriksa_rawat_inap`) REFERENCES `t_dokter` (`id_dokter`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=294 DEFAULT CHARSET=latin1;

/*Data for the table `t_pengobatan_pasien_rawat_inap` */

insert  into `t_pengobatan_pasien_rawat_inap`(`id_pengobatan_rawat_inap`,`berat_inap`,`detail_inap`,`diagnosa`,`dokter_pemeriksa_rawat_inap`,`id_pasien`,`jenis_perawatan_pasien_rawat_inap`,`keterangan`,`proses_keluar`,`suhu_inap`,`tanggal_masuk`,`tekanan_darah_inap`,`opt_version`,`status`) values 
(235,80,'Demam','Intoksikasi',54,163,'Penyakit Dalam','','Hidup - Atas Permintaan Sendiri',NULL,'2018-06-07',NULL,11,'Aktif'),
(246,NULL,'Angiografi Ginjal','Angiografi Ginjal',65,237,'Penyakit Dalam','','Hidup - Dirujuk',NULL,'2018-05-15',NULL,0,'Aktif'),
(247,NULL,'Asma','Asma',63,239,'Paru-paru','','Hidup - Atas Permintaan Sendiri',NULL,'2018-05-23',NULL,0,'Aktif'),
(251,NULL,'Endometriosis','Endometriosis',73,166,'Penyakit Dalam','','Hidup - Atas Permintaan Sendiri',NULL,'2016-03-14',NULL,0,'Aktif'),
(252,NULL,'Asma','Asma',63,241,'Paru-paru','','Hidup - Atas Permintaan Sendiri',NULL,'2014-01-08',NULL,0,'Aktif'),
(254,NULL,'-','Glokagonoma',73,238,'Penyakit Dalam','','Hidup - Atas Permintaan Sendiri',NULL,'2018-06-15',NULL,0,'Aktif'),
(256,NULL,'-','Glokagonoma',65,239,'Penyakit Dalam','','Hidup - Atas Permintaan Sendiri',NULL,'2017-12-11',NULL,0,'Aktif'),
(259,NULL,'-','Asma',63,241,'Paru-paru','','Hidup - Atas Permintaan Sendiri',NULL,'2015-02-01',NULL,1,'Aktif'),
(260,NULL,'-','Asma',63,243,'Paru-paru','','Hidup - Atas Permintaan Sendiri',NULL,'2015-11-01',NULL,0,'Aktif'),
(270,NULL,'-','Dispepsia',56,163,'Gigi & Mulut','','Hidup - Atas Permintaan Sendiri',NULL,'2018-06-07',NULL,1,'Aktif'),
(293,78,'Alergi Eksim','Alergi Eksim',54,163,'Penyakit Dalam','','Hidup - Atas Permintaan Sendiri',37,'2018-06-07',120,0,'Aktif');

/*Table structure for table `t_pengobatan_pasien_rawat_jalan` */

DROP TABLE IF EXISTS `t_pengobatan_pasien_rawat_jalan`;

CREATE TABLE `t_pengobatan_pasien_rawat_jalan` (
  `id_pengobatan_pasien_rawat_jalan` int(11) NOT NULL AUTO_INCREMENT,
  `berat_badan` int(11) DEFAULT NULL,
  `hasil_pemeriksaan` varchar(100) DEFAULT NULL,
  `diagnosa` varchar(25) DEFAULT NULL,
  `dokter_pemeriksa` int(11) DEFAULT NULL,
  `keterangan` varchar(100) DEFAULT NULL,
  `poli` varchar(25) DEFAULT NULL,
  `obat_jalan` varchar(25) DEFAULT NULL,
  `suhu_jalan` int(11) DEFAULT NULL,
  `tanggal_pemeriksaan` date DEFAULT NULL,
  `tekanan_darah_jalan` int(11) DEFAULT NULL,
  `jenis_perawatan_pasien_rawat_jalan` varchar(25) DEFAULT NULL,
  `opt_version` int(11) DEFAULT '0',
  `id_pasien` int(11) DEFAULT NULL,
  `status` varchar(25) DEFAULT 'Aktif',
  PRIMARY KEY (`id_pengobatan_pasien_rawat_jalan`),
  KEY `tabel_pengobatan_jalan_ibfk_1` (`id_pasien`),
  KEY `t_pengobatan_pasien_rawat_jalan_ibfk_2` (`dokter_pemeriksa`),
  CONSTRAINT `t_pengobatan_pasien_rawat_jalan_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `t_pasien` (`id_pasien`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_pengobatan_pasien_rawat_jalan_ibfk_2` FOREIGN KEY (`dokter_pemeriksa`) REFERENCES `t_dokter` (`id_dokter`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=292 DEFAULT CHARSET=latin1;

/*Data for the table `t_pengobatan_pasien_rawat_jalan` */

insert  into `t_pengobatan_pasien_rawat_jalan`(`id_pengobatan_pasien_rawat_jalan`,`berat_badan`,`hasil_pemeriksaan`,`diagnosa`,`dokter_pemeriksa`,`keterangan`,`poli`,`obat_jalan`,`suhu_jalan`,`tanggal_pemeriksaan`,`tekanan_darah_jalan`,`jenis_perawatan_pasien_rawat_jalan`,`opt_version`,`id_pasien`,`status`) values 
(230,78,'Alergi Eksim','Alergi Eksim',54,'Alergi Eksim','Umum','Epormin',37,'2018-06-07',100,'Obat',7,163,'Tidak Aktif'),
(236,NULL,'','Dermatitis',56,'','Umum','',NULL,'2015-10-18',NULL,'',1,165,'Aktif'),
(245,NULL,'','Anemia',116,'','Umum','',NULL,'2018-06-06',NULL,'',0,239,'Aktif'),
(248,NULL,'','Bronkiolitis',63,'','Paru','',NULL,'2017-02-04',NULL,'',1,243,'Aktif'),
(249,NULL,'','Dispepsia',116,'','Umum','',NULL,'2016-09-12',NULL,'',0,238,'Aktif'),
(250,NULL,'','Divertikulosis',65,'','Penyakit Dalam','',NULL,'2016-12-23',NULL,'',0,240,'Aktif'),
(253,NULL,'','Dispepsia',NULL,'','Umum','',NULL,'2018-06-07',NULL,'',1,163,'Aktif'),
(255,NULL,'','Alergi Eksim',56,'','Umum','',NULL,'2018-05-27',NULL,'',0,167,'Aktif'),
(257,NULL,'','Dispepsia',56,'','Umum','',NULL,'2018-03-04',NULL,'',0,165,'Aktif'),
(258,NULL,'','Dispepsia',116,'','Umum','',NULL,'2018-06-06',NULL,'',0,242,'Aktif'),
(261,80,'','Dispepsia',56,'','Umum','',40,'2018-06-06',NULL,'',0,163,'Aktif'),
(264,NULL,'Demam','Dispepsia',54,'','Umum','',NULL,'2018-06-06',NULL,'',0,263,'Aktif'),
(269,NULL,'','Batuk',54,'','Umum','sanadril',3,'2018-06-06',12,'minum',0,166,'Aktif'),
(290,78,'Alergi Eksim','Alergi Eksim',54,'Alergi Eksim','Umum','Epormin',37,'2018-06-07',120,'Obat',3,163,'Aktif'),
(291,NULL,'','Dispepsia',54,'','Umum','',NULL,'2018-06-07',232,'',1,163,'Tidak Aktif');

/*Table structure for table `viewjadwal` */

DROP TABLE IF EXISTS `viewjadwal`;

CREATE TABLE `viewjadwal` (
  `id_jadwal` int(11) NOT NULL,
  `hari_mulai` varchar(255) DEFAULT NULL,
  `hari_selesai` varchar(255) DEFAULT NULL,
  `id_dokter` int(11) DEFAULT NULL,
  `jam_mulai` varchar(255) DEFAULT NULL,
  `jam_selesai` varchar(255) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `nama_dokter` varchar(255) DEFAULT NULL,
  `nip` varchar(255) DEFAULT NULL,
  `spesialis_dokter` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_jadwal`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `viewjadwal` */

/*Table structure for table `pinap` */

DROP TABLE IF EXISTS `pinap`;

/*!50001 DROP VIEW IF EXISTS `pinap` */;
/*!50001 DROP TABLE IF EXISTS `pinap` */;

/*!50001 CREATE TABLE  `pinap`(
 `id` int(11) ,
 `penyakit` text ,
 `total` bigint(21) ,
 `bulan` int(2) ,
 `tahun` int(4) 
)*/;

/*Table structure for table `pjalan` */

DROP TABLE IF EXISTS `pjalan`;

/*!50001 DROP VIEW IF EXISTS `pjalan` */;
/*!50001 DROP TABLE IF EXISTS `pjalan` */;

/*!50001 CREATE TABLE  `pjalan`(
 `id` int(11) ,
 `penyakit` varchar(25) ,
 `total` bigint(21) ,
 `bulan` int(2) ,
 `tahun` int(4) 
)*/;

/*Table structure for table `viewgrafikjumlah` */

DROP TABLE IF EXISTS `viewgrafikjumlah`;

/*!50001 DROP VIEW IF EXISTS `viewgrafikjumlah` */;
/*!50001 DROP TABLE IF EXISTS `viewgrafikjumlah` */;

/*!50001 CREATE TABLE  `viewgrafikjumlah`(
 `id` int(11) ,
 `tahun` int(4) ,
 `jumlah` bigint(21) ,
 `Pria` bigint(21) ,
 `Wanita` bigint(21) 
)*/;

/*Table structure for table `viewgrafikjumlahinap` */

DROP TABLE IF EXISTS `viewgrafikjumlahinap`;

/*!50001 DROP VIEW IF EXISTS `viewgrafikjumlahinap` */;
/*!50001 DROP TABLE IF EXISTS `viewgrafikjumlahinap` */;

/*!50001 CREATE TABLE  `viewgrafikjumlahinap`(
 `id` int(11) ,
 `tahun` int(4) ,
 `jumlah` bigint(21) ,
 `Pria` bigint(21) ,
 `Wanita` bigint(21) 
)*/;

/*Table structure for table `viewjadwaldokter` */

DROP TABLE IF EXISTS `viewjadwaldokter`;

/*!50001 DROP VIEW IF EXISTS `viewjadwaldokter` */;
/*!50001 DROP TABLE IF EXISTS `viewjadwaldokter` */;

/*!50001 CREATE TABLE  `viewjadwaldokter`(
 `id_jadwal` int(11) ,
 `mulai` varchar(10) ,
 `selesai` varchar(10) ,
 `senin` int(11) ,
 `selasa` int(11) ,
 `rabu` int(11) ,
 `kamis` int(11) ,
 `jumat` int(11) ,
 `sabtu` int(11) ,
 `minggu` int(11) ,
 `keterangan` varchar(100) ,
 `nama_dokter` varchar(40) ,
 `status` varchar(25) ,
 `spesialis` varchar(40) ,
 `id_dokter` int(11) ,
 `nip` varchar(25) 
)*/;

/*Table structure for table `viewjkinap` */

DROP TABLE IF EXISTS `viewjkinap`;

/*!50001 DROP VIEW IF EXISTS `viewjkinap` */;
/*!50001 DROP TABLE IF EXISTS `viewjkinap` */;

/*!50001 CREATE TABLE  `viewjkinap`(
 `id` int(11) ,
 `jumlah` bigint(21) ,
 `Pria` bigint(21) ,
 `Wanita` bigint(21) 
)*/;

/*Table structure for table `viewjkjalan` */

DROP TABLE IF EXISTS `viewjkjalan`;

/*!50001 DROP VIEW IF EXISTS `viewjkjalan` */;
/*!50001 DROP TABLE IF EXISTS `viewjkjalan` */;

/*!50001 CREATE TABLE  `viewjkjalan`(
 `id` int(11) ,
 `jumlah` bigint(21) ,
 `Pria` bigint(21) ,
 `Wanita` bigint(21) 
)*/;

/*Table structure for table `viewjlhpenyakitinap` */

DROP TABLE IF EXISTS `viewjlhpenyakitinap`;

/*!50001 DROP VIEW IF EXISTS `viewjlhpenyakitinap` */;
/*!50001 DROP TABLE IF EXISTS `viewjlhpenyakitinap` */;

/*!50001 CREATE TABLE  `viewjlhpenyakitinap`(
 `id` int(11) ,
 `diagnosa` text ,
 `jumlah` bigint(21) 
)*/;

/*Table structure for table `viewjlhpenyakitjalan` */

DROP TABLE IF EXISTS `viewjlhpenyakitjalan`;

/*!50001 DROP VIEW IF EXISTS `viewjlhpenyakitjalan` */;
/*!50001 DROP TABLE IF EXISTS `viewjlhpenyakitjalan` */;

/*!50001 CREATE TABLE  `viewjlhpenyakitjalan`(
 `id` int(11) ,
 `diagnosa` varchar(25) ,
 `jumlah` bigint(21) 
)*/;

/*Table structure for table `viewlaporanumum` */

DROP TABLE IF EXISTS `viewlaporanumum`;

/*!50001 DROP VIEW IF EXISTS `viewlaporanumum` */;
/*!50001 DROP TABLE IF EXISTS `viewlaporanumum` */;

/*!50001 CREATE TABLE  `viewlaporanumum`(
 `id` int(11) ,
 `tahun` int(4) ,
 `bulan` int(2) ,
 `jumlah` bigint(21) ,
 `Pria` bigint(21) ,
 `Wanita` bigint(21) 
)*/;

/*Table structure for table `viewlaporanumuminap` */

DROP TABLE IF EXISTS `viewlaporanumuminap`;

/*!50001 DROP VIEW IF EXISTS `viewlaporanumuminap` */;
/*!50001 DROP TABLE IF EXISTS `viewlaporanumuminap` */;

/*!50001 CREATE TABLE  `viewlaporanumuminap`(
 `id` int(11) ,
 `tahun` int(4) ,
 `bulan` int(2) ,
 `jumlah` bigint(21) ,
 `Pria` bigint(21) ,
 `Wanita` bigint(21) 
)*/;

/*Table structure for table `viewpengganti` */

DROP TABLE IF EXISTS `viewpengganti`;

/*!50001 DROP VIEW IF EXISTS `viewpengganti` */;
/*!50001 DROP TABLE IF EXISTS `viewpengganti` */;

/*!50001 CREATE TABLE  `viewpengganti`(
 `id` int(11) ,
 `berhalangan` varchar(40) ,
 `pengganti` varchar(40) ,
 `spesialis` varchar(40) ,
 `mulai` date ,
 `selesai` date ,
 `keterangan` varchar(255) ,
 `status` varchar(20) 
)*/;

/*Table structure for table `viewpengobataninap` */

DROP TABLE IF EXISTS `viewpengobataninap`;

/*!50001 DROP VIEW IF EXISTS `viewpengobataninap` */;
/*!50001 DROP TABLE IF EXISTS `viewpengobataninap` */;

/*!50001 CREATE TABLE  `viewpengobataninap`(
 `id_inap` int(11) ,
 `berat` int(11) ,
 `detail` varchar(100) ,
 `diagnosa` text ,
 `dokter` varchar(40) ,
 `id_pasien` int(11) ,
 `jenis_perawatan` varchar(25) ,
 `keterangan` varchar(100) ,
 `proses_keluar` varchar(50) ,
 `suhu` int(11) ,
 `masuk` date ,
 `darah` int(11) ,
 `status_pasien` varchar(25) 
)*/;

/*Table structure for table `viewpengobatanjalan` */

DROP TABLE IF EXISTS `viewpengobatanjalan`;

/*!50001 DROP VIEW IF EXISTS `viewpengobatanjalan` */;
/*!50001 DROP TABLE IF EXISTS `viewpengobatanjalan` */;

/*!50001 CREATE TABLE  `viewpengobatanjalan`(
 `id` int(11) ,
 `berat` int(11) ,
 `hasil` varchar(100) ,
 `diagnosa` varchar(25) ,
 `dokter` varchar(40) ,
 `poli` varchar(25) ,
 `keterangan` varchar(100) ,
 `obat` varchar(25) ,
 `suhu` int(11) ,
 `tanggal` date ,
 `tekanan` int(11) ,
 `perawatan` varchar(25) ,
 `id_pasien` int(11) 
)*/;

/*Table structure for table `viewrekappenyakitinap` */

DROP TABLE IF EXISTS `viewrekappenyakitinap`;

/*!50001 DROP VIEW IF EXISTS `viewrekappenyakitinap` */;
/*!50001 DROP TABLE IF EXISTS `viewrekappenyakitinap` */;

/*!50001 CREATE TABLE  `viewrekappenyakitinap`(
 `id` int(11) ,
 `diagnosa` text ,
 `jumlah` bigint(21) ,
 `tahun` int(4) 
)*/;

/*Table structure for table `viewrekappenyakitjalan` */

DROP TABLE IF EXISTS `viewrekappenyakitjalan`;

/*!50001 DROP VIEW IF EXISTS `viewrekappenyakitjalan` */;
/*!50001 DROP TABLE IF EXISTS `viewrekappenyakitjalan` */;

/*!50001 CREATE TABLE  `viewrekappenyakitjalan`(
 `id` int(11) ,
 `diagnosa` varchar(25) ,
 `jumlah` bigint(21) ,
 `tahun` int(4) 
)*/;

/*Table structure for table `viewtotalpasien` */

DROP TABLE IF EXISTS `viewtotalpasien`;

/*!50001 DROP VIEW IF EXISTS `viewtotalpasien` */;
/*!50001 DROP TABLE IF EXISTS `viewtotalpasien` */;

/*!50001 CREATE TABLE  `viewtotalpasien`(
 `id` int(11) ,
 `jumlah` bigint(21) ,
 `Pria` decimal(23,0) ,
 `Wanita` decimal(23,0) 
)*/;

/*View structure for view pinap */

/*!50001 DROP TABLE IF EXISTS `pinap` */;
/*!50001 DROP VIEW IF EXISTS `pinap` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pinap` AS (select `a`.`id_pengobatan_rawat_inap` AS `id`,`a`.`diagnosa` AS `penyakit`,count(distinct `a`.`id_pasien`) AS `total`,month(`a`.`tanggal_masuk`) AS `bulan`,year(`a`.`tanggal_masuk`) AS `tahun` from `t_pengobatan_pasien_rawat_inap` `a` where (`a`.`status` = 'Aktif') group by month(`a`.`tanggal_masuk`),year(`a`.`tanggal_masuk`),`a`.`diagnosa`) */;

/*View structure for view pjalan */

/*!50001 DROP TABLE IF EXISTS `pjalan` */;
/*!50001 DROP VIEW IF EXISTS `pjalan` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pjalan` AS (select `a`.`id_pengobatan_pasien_rawat_jalan` AS `id`,`a`.`diagnosa` AS `penyakit`,count(distinct `a`.`id_pasien`) AS `total`,month(`a`.`tanggal_pemeriksaan`) AS `bulan`,year(`a`.`tanggal_pemeriksaan`) AS `tahun` from `t_pengobatan_pasien_rawat_jalan` `a` where (`a`.`status` = 'Aktif') group by month(`a`.`tanggal_pemeriksaan`),year(`a`.`tanggal_pemeriksaan`),`a`.`diagnosa`) */;

/*View structure for view viewgrafikjumlah */

/*!50001 DROP TABLE IF EXISTS `viewgrafikjumlah` */;
/*!50001 DROP VIEW IF EXISTS `viewgrafikjumlah` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewgrafikjumlah` AS (select `a`.`id` AS `id`,year(`a`.`tanggal`) AS `tahun`,count(distinct `a`.`id_pasien`) AS `jumlah`,count(distinct (case when (`b`.`jenis_kelamin` = 'Pria') then `a`.`id_pasien` else NULL end)) AS `Pria`,count(distinct (case when (`b`.`jenis_kelamin` = 'Wanita') then `a`.`id_pasien` else NULL end)) AS `Wanita` from (`viewpengobatanjalan` `a` join `t_pasien` `b` on((`a`.`id_pasien` = `b`.`id_pasien`))) group by year(`a`.`tanggal`) order by year(`a`.`tanggal`)) */;

/*View structure for view viewgrafikjumlahinap */

/*!50001 DROP TABLE IF EXISTS `viewgrafikjumlahinap` */;
/*!50001 DROP VIEW IF EXISTS `viewgrafikjumlahinap` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewgrafikjumlahinap` AS (select `a`.`id_inap` AS `id`,year(`a`.`masuk`) AS `tahun`,count(distinct `a`.`id_pasien`) AS `jumlah`,count(distinct (case when (`b`.`jenis_kelamin` = 'Pria') then `a`.`id_pasien` else NULL end)) AS `Pria`,count(distinct (case when (`b`.`jenis_kelamin` = 'Wanita') then `a`.`id_pasien` else NULL end)) AS `Wanita` from (`viewpengobataninap` `a` join `t_pasien` `b` on((`a`.`id_pasien` = `b`.`id_pasien`))) group by year(`a`.`masuk`) order by year(`a`.`masuk`)) */;

/*View structure for view viewjadwaldokter */

/*!50001 DROP TABLE IF EXISTS `viewjadwaldokter` */;
/*!50001 DROP VIEW IF EXISTS `viewjadwaldokter` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewjadwaldokter` AS (select `a`.`id_jadwal` AS `id_jadwal`,`a`.`jam_mulai` AS `mulai`,`a`.`jam_selesai` AS `selesai`,`a`.`senin` AS `senin`,`a`.`selasa` AS `selasa`,`a`.`rabu` AS `rabu`,`a`.`kamis` AS `kamis`,`a`.`jumat` AS `jumat`,`a`.`sabtu` AS `sabtu`,`a`.`minggu` AS `minggu`,`a`.`keterangan` AS `keterangan`,`b`.`nama_dokter` AS `nama_dokter`,`a`.`status` AS `status`,`b`.`spesialis_dokter` AS `spesialis`,`b`.`id_dokter` AS `id_dokter`,`b`.`nip` AS `nip` from (`jadwal_dokter` `a` join `t_dokter` `b` on((`a`.`nama_dokter` = `b`.`id_dokter`))) where ((`a`.`status` = 'Aktif') and (`b`.`status` = 'Aktif'))) */;

/*View structure for view viewjkinap */

/*!50001 DROP TABLE IF EXISTS `viewjkinap` */;
/*!50001 DROP VIEW IF EXISTS `viewjkinap` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewjkinap` AS (select `a`.`id_inap` AS `id`,count(distinct `a`.`id_pasien`) AS `jumlah`,count(distinct (case when (`b`.`jenis_kelamin` = 'Pria') then `a`.`id_pasien` else NULL end)) AS `Pria`,count(distinct (case when (`b`.`jenis_kelamin` = 'Wanita') then `a`.`id_pasien` else NULL end)) AS `Wanita` from (`viewpengobataninap` `a` join `t_pasien` `b` on((`a`.`id_pasien` = `b`.`id_pasien`)))) */;

/*View structure for view viewjkjalan */

/*!50001 DROP TABLE IF EXISTS `viewjkjalan` */;
/*!50001 DROP VIEW IF EXISTS `viewjkjalan` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewjkjalan` AS (select `a`.`id` AS `id`,count(distinct `a`.`id_pasien`) AS `jumlah`,count(distinct (case when (`b`.`jenis_kelamin` = 'Pria') then `a`.`id_pasien` else NULL end)) AS `Pria`,count(distinct (case when (`b`.`jenis_kelamin` = 'Wanita') then `a`.`id_pasien` else NULL end)) AS `Wanita` from (`viewpengobatanjalan` `a` join `t_pasien` `b` on((`a`.`id_pasien` = `b`.`id_pasien`)))) */;

/*View structure for view viewjlhpenyakitinap */

/*!50001 DROP TABLE IF EXISTS `viewjlhpenyakitinap` */;
/*!50001 DROP VIEW IF EXISTS `viewjlhpenyakitinap` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewjlhpenyakitinap` AS (select `a`.`id_pengobatan_rawat_inap` AS `id`,`a`.`diagnosa` AS `diagnosa`,count(distinct `a`.`id_pasien`) AS `jumlah` from `t_pengobatan_pasien_rawat_inap` `a` where (`a`.`status` = 'Aktif') group by `a`.`diagnosa`) */;

/*View structure for view viewjlhpenyakitjalan */

/*!50001 DROP TABLE IF EXISTS `viewjlhpenyakitjalan` */;
/*!50001 DROP VIEW IF EXISTS `viewjlhpenyakitjalan` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewjlhpenyakitjalan` AS (select `b`.`id_pengobatan_pasien_rawat_jalan` AS `id`,`b`.`diagnosa` AS `diagnosa`,count(distinct `b`.`id_pasien`) AS `jumlah` from `t_pengobatan_pasien_rawat_jalan` `b` where (`b`.`status` = 'Aktif') group by `b`.`diagnosa`) */;

/*View structure for view viewlaporanumum */

/*!50001 DROP TABLE IF EXISTS `viewlaporanumum` */;
/*!50001 DROP VIEW IF EXISTS `viewlaporanumum` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewlaporanumum` AS (select `a`.`id` AS `id`,year(`a`.`tanggal`) AS `tahun`,month(`a`.`tanggal`) AS `bulan`,count(distinct `a`.`id_pasien`) AS `jumlah`,count(distinct (case when (`b`.`jenis_kelamin` = 'Pria') then `a`.`id_pasien` else NULL end)) AS `Pria`,count(distinct (case when (`b`.`jenis_kelamin` = 'Wanita') then `a`.`id_pasien` else NULL end)) AS `Wanita` from (`viewpengobatanjalan` `a` join `t_pasien` `b` on((`a`.`id_pasien` = `b`.`id_pasien`))) group by month(`a`.`tanggal`),year(`a`.`tanggal`)) */;

/*View structure for view viewlaporanumuminap */

/*!50001 DROP TABLE IF EXISTS `viewlaporanumuminap` */;
/*!50001 DROP VIEW IF EXISTS `viewlaporanumuminap` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewlaporanumuminap` AS (select `a`.`id_inap` AS `id`,year(`a`.`masuk`) AS `tahun`,month(`a`.`masuk`) AS `bulan`,count(distinct `a`.`id_pasien`) AS `jumlah`,count(distinct (case when (`b`.`jenis_kelamin` = 'Pria') then `a`.`id_pasien` else NULL end)) AS `Pria`,count(distinct (case when (`b`.`jenis_kelamin` = 'Wanita') then `a`.`id_pasien` else NULL end)) AS `Wanita` from (`viewpengobataninap` `a` join `t_pasien` `b` on((`a`.`id_pasien` = `b`.`id_pasien`))) group by month(`a`.`masuk`),year(`a`.`masuk`)) */;

/*View structure for view viewpengganti */

/*!50001 DROP TABLE IF EXISTS `viewpengganti` */;
/*!50001 DROP VIEW IF EXISTS `viewpengganti` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewpengganti` AS (select `a`.`id_jadwal_pengganti` AS `id`,`b`.`nama_dokter` AS `berhalangan`,`c`.`nama_dokter` AS `pengganti`,`b`.`spesialis_dokter` AS `spesialis`,`a`.`tanggal_pergantian_mulai` AS `mulai`,`a`.`tanggal_pergantian_selesai` AS `selesai`,`a`.`keterangan` AS `keterangan`,`a`.`status` AS `status` from ((`t_jadwal_dokter_pengganti` `a` join `t_dokter` `b` on((`b`.`id_dokter` = `a`.`nama_dokter_berhalangan`))) join `t_dokter` `c` on((`c`.`id_dokter` = `a`.`nama_dokter_pengganti`))) where ((`b`.`status` = 'Aktif') and (`c`.`status` = 'Aktif') and (`a`.`status` = 'Aktif'))) */;

/*View structure for view viewpengobataninap */

/*!50001 DROP TABLE IF EXISTS `viewpengobataninap` */;
/*!50001 DROP VIEW IF EXISTS `viewpengobataninap` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewpengobataninap` AS (select `a`.`id_pengobatan_rawat_inap` AS `id_inap`,`a`.`berat_inap` AS `berat`,`a`.`detail_inap` AS `detail`,`a`.`diagnosa` AS `diagnosa`,`b`.`nama_dokter` AS `dokter`,`a`.`id_pasien` AS `id_pasien`,`a`.`jenis_perawatan_pasien_rawat_inap` AS `jenis_perawatan`,`a`.`keterangan` AS `keterangan`,`a`.`proses_keluar` AS `proses_keluar`,`a`.`suhu_inap` AS `suhu`,`a`.`tanggal_masuk` AS `masuk`,`a`.`tekanan_darah_inap` AS `darah`,`c`.`status` AS `status_pasien` from ((`t_pengobatan_pasien_rawat_inap` `a` join `t_dokter` `b` on((`a`.`dokter_pemeriksa_rawat_inap` = `b`.`id_dokter`))) join `t_pasien` `c` on((`a`.`id_pasien` = `c`.`id_pasien`))) where ((`a`.`status` = 'Aktif') and (`c`.`status` = 'Aktif'))) */;

/*View structure for view viewpengobatanjalan */

/*!50001 DROP TABLE IF EXISTS `viewpengobatanjalan` */;
/*!50001 DROP VIEW IF EXISTS `viewpengobatanjalan` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewpengobatanjalan` AS (select `a`.`id_pengobatan_pasien_rawat_jalan` AS `id`,`a`.`berat_badan` AS `berat`,`a`.`hasil_pemeriksaan` AS `hasil`,`a`.`diagnosa` AS `diagnosa`,`b`.`nama_dokter` AS `dokter`,`a`.`poli` AS `poli`,`a`.`keterangan` AS `keterangan`,`a`.`obat_jalan` AS `obat`,`a`.`suhu_jalan` AS `suhu`,`a`.`tanggal_pemeriksaan` AS `tanggal`,`a`.`tekanan_darah_jalan` AS `tekanan`,`a`.`jenis_perawatan_pasien_rawat_jalan` AS `perawatan`,`a`.`id_pasien` AS `id_pasien` from ((`t_pengobatan_pasien_rawat_jalan` `a` join `t_dokter` `b` on((`b`.`id_dokter` = `a`.`dokter_pemeriksa`))) join `t_pasien` `c` on((`c`.`id_pasien` = `a`.`id_pasien`))) where ((`a`.`status` = 'Aktif') and (`c`.`status` = 'Aktif'))) */;

/*View structure for view viewrekappenyakitinap */

/*!50001 DROP TABLE IF EXISTS `viewrekappenyakitinap` */;
/*!50001 DROP VIEW IF EXISTS `viewrekappenyakitinap` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewrekappenyakitinap` AS (select `a`.`id_pengobatan_rawat_inap` AS `id`,`a`.`diagnosa` AS `diagnosa`,count(distinct `a`.`id_pasien`) AS `jumlah`,year(`a`.`tanggal_masuk`) AS `tahun` from `t_pengobatan_pasien_rawat_inap` `a` group by `a`.`diagnosa`,year(`a`.`tanggal_masuk`)) */;

/*View structure for view viewrekappenyakitjalan */

/*!50001 DROP TABLE IF EXISTS `viewrekappenyakitjalan` */;
/*!50001 DROP VIEW IF EXISTS `viewrekappenyakitjalan` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewrekappenyakitjalan` AS (select `b`.`id_pengobatan_pasien_rawat_jalan` AS `id`,`b`.`diagnosa` AS `diagnosa`,count(distinct `b`.`id_pasien`) AS `jumlah`,year(`b`.`tanggal_pemeriksaan`) AS `tahun` from `t_pengobatan_pasien_rawat_jalan` `b` group by `b`.`diagnosa`,year(`b`.`tanggal_pemeriksaan`)) */;

/*View structure for view viewtotalpasien */

/*!50001 DROP TABLE IF EXISTS `viewtotalpasien` */;
/*!50001 DROP VIEW IF EXISTS `viewtotalpasien` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewtotalpasien` AS (select `a`.`id_pasien` AS `id`,count(`a`.`id_pasien`) AS `jumlah`,sum((case when (`a`.`jenis_kelamin` = 'Pria') then 1 else 0 end)) AS `Pria`,sum((case when (`a`.`jenis_kelamin` = 'Wanita') then 1 else 0 end)) AS `Wanita` from `t_pasien` `a` where (`a`.`status` = 'Aktif')) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
