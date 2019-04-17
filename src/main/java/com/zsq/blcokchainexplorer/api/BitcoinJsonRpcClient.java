package com.zsq.blcokchainexplorer.api;

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

    public String getBlockHashByHeight(Integer blcokHeight) throws Throwable {
        String blockhash = jsonRpcHttpClient.invoke("getblockhash",new Integer[]{blcokHeight},String.class);
        return "";
    }

}
