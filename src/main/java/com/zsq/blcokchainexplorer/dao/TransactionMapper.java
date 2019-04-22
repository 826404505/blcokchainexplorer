package com.zsq.blcokchainexplorer.dao;

import com.zsq.blcokchainexplorer.po.Transaction;

public interface TransactionMapper {

    int truncate();

    int deleteByPrimaryKey(String txid);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txid);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
}