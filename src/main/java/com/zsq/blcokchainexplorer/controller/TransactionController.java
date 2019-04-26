package com.zsq.blcokchainexplorer.controller;

import com.zsq.blcokchainexplorer.dao.TransactionDetailMapper;
import com.zsq.blcokchainexplorer.dao.TransactionMapper;
import com.zsq.blcokchainexplorer.dto.TransactionInfoDTO;
import com.zsq.blcokchainexplorer.dto.TransactionListDTO;
import com.zsq.blcokchainexplorer.dto.TxDetailInTxInfo;
import com.zsq.blcokchainexplorer.po.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    //通过id得到当前transaction的集合
    @GetMapping("/getRecentTransactionsById")
    public List<TransactionListDTO> getRecentTransactionsById(@RequestParam Integer blockchainId){
        //1、根据blockchainid查找
        return null;
    }

    //通过name和type得到当前的transaction集合
    @GetMapping("/getRecentTransactionsByNameType")
    public List<TransactionListDTO> getRecentTransactionsByNameType(@RequestParam String name,
                                                                    @RequestParam String type){

        return null;
    }

    //通过txid得到transaction的详细信息
    @GetMapping("/getTransactionInfoByTxid")
    public TransactionInfoDTO getTransactionInfoByTxid(@RequestParam String txid){
        //1、首先根据txid查找trasaction信息
        Transaction transaction = transactionMapper.selectByPrimaryKey(txid);

        //2、调用transactionDetailMapper里面的方法查找
        List<TxDetailInTxInfo> txDetailInTxInfos = transactionDetailMapper.selectByTxid(txid);
        //封装查找回来的数据
        TransactionInfoDTO transactionInfoDTO = new TransactionInfoDTO();
        transactionInfoDTO.setTxid(transaction.getTxid());
        transactionInfoDTO.setTxhash(transaction.getTxhash());
        transactionInfoDTO.setSize(transaction.getSize());
        transactionInfoDTO.setWeight(transaction.getWeight());
        transactionInfoDTO.setTime(transaction.getTime());
        transactionInfoDTO.setTotalInput(transaction.getTotalInput());
        transactionInfoDTO.setTotalOutput(transaction.getTotalOutput());
        transactionInfoDTO.setFees(transaction.getFees());

        transactionInfoDTO.setTxDetails(txDetailInTxInfos);

        return transactionInfoDTO;
    }

    //通过txhash得到transaction的信息
    @GetMapping("/getTransactionInfoByTxhash")
    public TransactionInfoDTO getTransactionInfoByTxhash(@RequestParam String txhash){
        //1、首先根据txhash查找transaction信息
        Transaction transaction = transactionMapper.selectByTxhash(txhash);
        //2、然后根据查出的transaction里面的txid查找transaction_detail信息
        List<TxDetailInTxInfo> txDetailInTxInfos = transactionDetailMapper.selectByTxid(transaction.getTxid());

        //封装查找回来的数据
        TransactionInfoDTO transactionInfoDTO = new TransactionInfoDTO();
        transactionInfoDTO.setTxid(transaction.getTxid());
        transactionInfoDTO.setTxhash(transaction.getTxhash());
        transactionInfoDTO.setSize(transaction.getSize());
        transactionInfoDTO.setWeight(transaction.getWeight());
        transactionInfoDTO.setTime(transaction.getTime());
        transactionInfoDTO.setTotalInput(transaction.getTotalInput());
        transactionInfoDTO.setTotalOutput(transaction.getTotalOutput());
        transactionInfoDTO.setFees(transaction.getFees());

        transactionInfoDTO.setTxDetails(txDetailInTxInfos);

        return transactionInfoDTO;
    }

}
