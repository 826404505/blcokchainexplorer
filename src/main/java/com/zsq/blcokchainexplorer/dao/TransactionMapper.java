package com.zsq.blcokchainexplorer.dao;

import com.zsq.blcokchainexplorer.dto.TransactionInBlockDTO;
import com.zsq.blcokchainexplorer.po.Transaction;
import org.apache.ibatis.annotations.Param;

public interface TransactionMapper {

    int truncate();

    int deleteByPrimaryKey(String txid);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txid);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    TransactionInBlockDTO selectTransactionInBlockDTOByHash(@Param("blockhash") String blockhash);
}