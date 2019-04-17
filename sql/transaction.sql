SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `txid` char(64) NOT NULL,
  `txhash` char(64) NOT NULL,
  `blockhash` char(64) NOT NULL,
  `size` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `total_input` double,
  `total_output` double,
  `fees` double,
  PRIMARY KEY (`txid`),
  unique `idx_txhash`(`txhash`),
  index `idx_blockhash`(`blockhash`),
  index `idx_time`(`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;
