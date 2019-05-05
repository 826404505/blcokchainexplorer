package com.zsq.blcokchainexplorer.service;

import com.zsq.blcokchainexplorer.dto.TransactionInfoByAddress;
import com.zsq.blcokchainexplorer.dto.TransactionListDTO;

import java.util.List;

public interface AddressService {
    List<TransactionInfoByAddress> getTransactionsByAddress(String address);
}
