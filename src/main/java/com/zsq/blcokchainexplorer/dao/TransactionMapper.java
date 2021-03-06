package com.zsq.blcokchainexplorer.dao;

import com.zsq.blcokchainexplorer.dto.TransactionInBlockDTO;
import com.zsq.blcokchainexplorer.po.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionMapper {



    int truncate();

    int deleteByPrimaryKey(String txid);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txid);

    Transaction selectByBlockhash(@Param("blcokhash") String blcokhash);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    TransactionInBlockDTO selectTransactionInBlockDTOByHash(@Param("blockhash") String blockhash);

    Transaction selectByTxhash(String txid);

    List<Transaction> selectByTxidList(String txid);
}