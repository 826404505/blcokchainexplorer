package com.zsq.blcokchainexplorer.dao;

import com.zsq.blcokchainexplorer.dto.TransactionInfoByAddress;
import com.zsq.blcokchainexplorer.dto.TxDetailInTxInfo;
import com.zsq.blcokchainexplorer.po.TransactionDetail;
import com.zsq.blcokchainexplorer.po.TransactionDetailKey;

import java.util.List;

public interface TransactionDetailMapper {

    int truncate();

    List<TxDetailInTxInfo> selectByTxid(String txid);

    int deleteByPrimaryKey(TransactionDetailKey key);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(TransactionDetailKey key);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);

    /*根据address查找一笔交易细节*/
    List<TransactionInfoByAddress> selectTxDetailByAddress(String address);
}