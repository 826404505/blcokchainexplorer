package com.zsq.blcokchainexplorer.controller;

import com.zsq.blcokchainexplorer.dto.*;
import com.zsq.blcokchainexplorer.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    /**
     *查询块block的信息，包括getRecentBlocksById通过ID查询当前block
     * getRecentBlocksByNameType通过name和type查询当前block
     * getBlockDetailByHash通过hash查询block的详细信息
     * getBlockDetailByHeight通过height查询block的详细信息
     */

    @Autowired
    private AddressService addressService;

    //查找地址的详细信息
    @GetMapping("/getAddressInfo")
    public AddressInfo getAddressInfo(@RequestParam String address){

        return null;
    }

    //根据交易地址得到交易
    @GetMapping("/getTransactionsByAddress")
    public List<TransactionInfoByAddress> getAddressTransactions(@RequestParam String address,
                                                           @RequestParam(required = false, defaultValue = "false") Boolean isClean, Integer pageNum){
        //根据address查找transaction的信息
        List<TransactionInfoByAddress> transactions = addressService.getTransactionsByAddress(address);
        return transactions;
    }

}
