package com.zsq.blcokchainexplorer.service.impl;

import com.zsq.blcokchainexplorer.dao.TransactionDetailMapper;
import com.zsq.blcokchainexplorer.dao.TransactionMapper;
import com.zsq.blcokchainexplorer.dto.TransactionInfoByAddress;
import com.zsq.blcokchainexplorer.dto.TxDetailInTxInfo;
import com.zsq.blcokchainexplorer.po.TransactionDetail;
import com.zsq.blcokchainexplorer.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public List<TransactionInfoByAddress> getTransactionsByAddress(String address) {

        //1、首先根据address查出transactionDedail集合的信息
        List<TransactionInfoByAddress> list = transactionDetailMapper.selectTxDetailByAddress(address);

        //2、然后遍历集合根据txid查询transaction集合信息
        for (TransactionInfoByAddress txaddress : list) {
            //根据txid查找txDetail的详细信息
            List<TxDetailInTxInfo> txDetailInTxInfos = transactionDetailMapper.selectByTxid(txaddress.getTxid());

        }

        return null;
    }


}
