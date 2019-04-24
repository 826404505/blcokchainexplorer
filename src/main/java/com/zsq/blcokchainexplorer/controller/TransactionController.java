package com.zsq.blcokchainexplorer.controller;

import com.zsq.blcokchainexplorer.dto.TransactionInfoDTO;
import com.zsq.blcokchainexplorer.dto.TransactionListDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    //通过id得到当前transaction的集合
    @GetMapping("/getRecentTransactionsById")
    public List<TransactionListDTO> getRecentTransactionsById(@RequestParam Integer blockchainId){

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

        return null;
    }

    //通过txhash得到transaction的信息
    @GetMapping("/getTransactionInfoByTxhash")
    public TransactionInfoDTO getTransactionInfoByTxhash(@RequestParam String txhash){

        return null;
    }

}
