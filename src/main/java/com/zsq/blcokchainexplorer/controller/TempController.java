package com.zsq.blcokchainexplorer.controller;

import com.alibaba.fastjson.JSONArray;
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

    @GetMapping("/test")
    public Object test(){
        //JSONObject chainInfo = bitecoinApi.getChainInfo();
        JSONArray blockHeaders = bitecoinApi.getBlockHeaders(10, "000000000ac483a02f993b9f785da7b81ba83af62dcac6ed049e93e9432149fb");

        return blockHeaders;
        /*String txhash = "";
        JSONObject transaction = bitecoinApi.getTransaction(txhash);
*/

    }



}
