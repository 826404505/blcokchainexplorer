SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for block
-- ----------------------------
DROP TABLE IF EXISTS `block`;
CREATE TABLE `block` (
  `blockhash` char(64) NOT NULL,
  `blockchain_id` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `tx_size` int(20) NOT NULL,
  `size_on_disk` bigint(20) NOT NULL,
  `difficulty` double NOT NULL,
  `prev_blockhash` char(64),
  `next_blockhash` char(64),
  `output_total` double,
  `transaction_fees` double,
  `merkle_root` char(64),
  PRIMARY KEY (`blockhash`),
  unique `idx_blockchain_height`(`blockchain_id`,`height`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;
