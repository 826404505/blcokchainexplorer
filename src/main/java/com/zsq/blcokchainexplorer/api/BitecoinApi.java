package com.zsq.blcokchainexplorer.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bitcoin", url = "http://localhost:18332")
public interface BitecoinApi {

    //得到block链的信息
    @GetMapping("/rest/chaininfo.json")
    JSONObject getChainInfo();

    //通过txhash查找交易信息
    @GetMapping("rest/tx/{txhash}.json")
    JSONObject getTransaction(@PathVariable("txhash") String txhash);

    //通过blockhash来查询blcok
    @GetMapping("/rest/block/{blockhash}.json")
    JSONObject getBlock(@PathVariable("blockhash") String blockhash);

    //根据blockhash查找没有交易的block信息
    @GetMapping("rest/block/notxdetails/{blockhash}.json")
    JSONObject getNotTxBlock(@PathVariable("blockhash") String blockhash);

    //通过交易量和blockhash查找块的header
    @GetMapping("/rest/headers/{count}/{blockhash}.json")
    JSONArray getBlockHeaders(@PathVariable("count") Integer count, @PathVariable("blockhash") String blockhash);

    //查找交易池的信息
    @GetMapping("/rest/mempool/info.json")
    JSONObject getMempoolInfo();

    //查找交易池里面的容量
    @GetMapping("/rest/mempool/contents.json")
    JSONObject getMempoolContents();

}
