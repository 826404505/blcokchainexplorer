package com.zsq.blcokchainexplorer.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Service
public class BitcoinJsonRpcClient {
    /**
     * 该client主要功能是和postman里面输入username和password的功能一样
     */

    private JsonRpcHttpClient jsonRpcHttpClient;

    /**
     * 把username和password按照Base64方式加密送到后台bitcoin的客户端
     */
    public BitcoinJsonRpcClient() throws MalformedURLException {
        HashMap<String, String> header = new HashMap<>();
        //把username和password加密
        String authStrOrig = String.format("%s:%s", "zsq", "123456");
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authStrResult = String.format("Basic %s", authStr);

        //把加密过的username和password装到map里面提交
        header.put("Authorization",authStrResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL("http://localhost:18332"),header);
    }

    /**
     * 根据height得到block的hash值
     * @param blcokHeight
     * @return
     * @throws Throwable
     */
    public String getBlockHashByHeight(Integer blcokHeight) throws Throwable {
        String blockHash = jsonRpcHttpClient.invoke("getblockhash",new Integer[]{blcokHeight},String.class);
        return blockHash;
    }

    /**
     * 通过address得到余额
     * @param address
     * @return
     */
    public Double getBalance(String address) throws Throwable {
        //调用方法得到JSONArray类型的余额
        JSONArray balances = jsonRpcHttpClient.invoke("listunspent", new Object[]{6, 9999999, new String[]{address}}, JSONArray.class);
        //把JSONArray类型的balances转换成JSONObject类型的
        JSONObject balance = balances.getJSONObject(0);
        //把JSONObject类型的balance转换成Double
        Double amount = balance.getDouble("amount");
        return amount;
    }

    /**
     * 根据txid查找交易记录
     * @param txid
     * @param n
     * @return
     * @throws Throwable
     */
    public JSONObject getRawTransaxtion(String txid, Integer n) throws Throwable {
        JSONObject rawTransaction = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);

        return rawTransaction;
    }



}
