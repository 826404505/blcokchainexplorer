package com.zsq.blcokchainexplorer.controller;

import com.alibaba.fastjson.JSONObject;
import com.zsq.blcokchainexplorer.api.BitcoinJsonRpcClient;
import com.zsq.blcokchainexplorer.api.BitecoinApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
public class TempController {

    @Autowired
    private BitecoinApi bitecoinApi;

    @Autowired
    private BitcoinJsonRpcClient bitcoinJsonRpcClient;

    @GetMapping
    public void test(){
        JSONObject chainInfo = bitecoinApi.getChainInfo();
        /*String txhash = "";
        JSONObject transaction = bitecoinApi.getTransaction(txhash);
*/

    }



}
