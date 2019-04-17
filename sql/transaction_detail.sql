SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for transaction_detail
-- ----------------------------
DROP TABLE IF EXISTS `transaction_detail`;
CREATE TABLE `transaction_detail` (
  `txid` char(64) NOT NULL,
  `address` varchar(70) NOT NULL ,
  `type` tinyint NOT NULL,
  `amount` double,
  PRIMARY KEY (`txid`,`address`),
  index `idx_address`(`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;
