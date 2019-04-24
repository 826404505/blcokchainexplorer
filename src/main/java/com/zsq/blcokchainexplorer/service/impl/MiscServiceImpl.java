package com.zsq.blcokchainexplorer.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zsq.blcokchainexplorer.api.BitcoinJsonRpcClient;
import com.zsq.blcokchainexplorer.api.BitecoinApi;
import com.zsq.blcokchainexplorer.dao.BlockMapper;
import com.zsq.blcokchainexplorer.dao.TransactionDetailMapper;
import com.zsq.blcokchainexplorer.dao.TransactionMapper;
import com.zsq.blcokchainexplorer.enumeration.TransactionDetailType;
import com.zsq.blcokchainexplorer.po.Block;
import com.zsq.blcokchainexplorer.po.Transaction;
import com.zsq.blcokchainexplorer.po.TransactionDetail;
import com.zsq.blcokchainexplorer.service.MiscService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MiscServiceImpl implements MiscService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitecoinApi bitecoinApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private BitcoinJsonRpcClient bitcoinJsonRpcClient;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    @Async
    @Override
    public void importFromHeight(Integer blockHeight, Boolean isClean) throws Throwable {
        //判断数据库是否clean
        if (isClean) {
            blockMapper.truncate();
            transactionMapper.truncate();
            transactionDetailMapper.truncate();
        }
        //循环从输入的开始到0
        //1、首先把hash值取出来
        //2、根据hash值查找指定的block
        //3、然后把block插入到数据库里面
        //出现的问题是height不按规则的去插入，随机

        int height = blockHeight;
        String temphash ="";
        //Integer firstheight = 0;


        while (height > 0){
            //根据height查找temphash
            temphash = bitcoinJsonRpcClient.getBlockHashByHeight(height);

            //然后根据blockhash把数据插入到数据库
            //进行循环
            //while (temphash != null && !temphash.isEmpty()){

                //通过api得到block的JSONObject数据
                JSONObject blockOrigin = bitecoinApi.getBlock(temphash);
                Block block = new Block();
                //把得到的block赋值给新new的block
                block.setBlockhash(blockOrigin.getString("hash"));

                //设置id，height，time等一些数据
                block.setBlockchainId(2);
                block.setHeight(blockOrigin.getInteger("height"));
                Long time = blockOrigin.getLong("time");
                Date date = new Date(time * 1000);
                block.setTime(date);
                JSONArray tx = blockOrigin.getJSONArray("tx");

                for (int i =0; i<tx.size(); i++){
                    importTx(tx.getJSONObject(i),temphash,date);
                }

                block.setTxSize(tx.size());
                block.setSizeOnDisk(blockOrigin.getLong("size"));
                block.setDifficulty(blockOrigin.getDouble("difficulty"));
                block.setPrevBlockhash(blockOrigin.getString("previousblockhash"));
                block.setNextBlockhash(blockOrigin.getString("nextblockhash"));
                block.setMerkleRoot(blockOrigin.getString("merkleroot"));

                //把已经包装好的block插入到数据里面
                blockMapper.insert(block);
                if (blockOrigin.getInteger("height")==0){
                    break;
                }
                temphash = blockOrigin.getString("previousblockhash");
           }

            //height--;
        }

    @Async
    @Override
    public void importFromHash(String blockHash, Boolean isClean) throws Throwable {
        //判断是否是isClean
        if (isClean){
            blockMapper.truncate();
            transactionMapper.truncate();
            transactionDetailMapper.truncate();
        }

        String temphash = blockHash;

        //进行循环
        while (temphash != null && !temphash.isEmpty()){

            //通过api得到block的JSONObject数据
            JSONObject blockOrigin = bitecoinApi.getBlock(temphash);
            Block block = new Block();
            //把得到的block赋值给新new的block
            block.setBlockhash(blockOrigin.getString("hash"));

            //设置id，height，time等一些数据
            block.setBlockchainId(2);
            block.setHeight(blockOrigin.getInteger("height"));
            Long time = blockOrigin.getLong("time");
            Date date = new Date(time * 1000);
            block.setTime(date);
            JSONArray tx = blockOrigin.getJSONArray("tx");

            for (int i =0; i<tx.size(); i++){
                importTx(tx.getJSONObject(i),temphash,date);
            }

            block.setTxSize(tx.size());
            block.setSizeOnDisk(blockOrigin.getLong("size"));
            block.setDifficulty(blockOrigin.getDouble("difficulty"));
            block.setPrevBlockhash(blockOrigin.getString("previousblockhash"));
            block.setNextBlockhash(blockOrigin.getString("nextblockhash"));
            block.setMerkleRoot(blockOrigin.getString("merkleroot"));

            //把已经包装好的block插入到数据里面
            blockMapper.insert(block);

            temphash = blockOrigin.getString("nextblockhash");
        }

        //输出日志
        logger.info("sync finished");

    }

    /**
     * 往数据库里面插入交易记录
     * @param tx
     * @param blockhash
     * @param time
     * @throws Throwable
     */
    public void importTx(JSONObject tx, String blockhash, Date time) throws Throwable {
        Transaction transaction = new Transaction();
        String txid = tx.getString("txid");
        transaction.setTxid(txid);

        transaction.setTxhash(tx.getString("hash"));
        transaction.setBlockhash(blockhash);
        transaction.setSize(tx.getLong("size"));
        transaction.setWeight(tx.getInteger("weight"));
        transaction.setTime(time);
        transactionMapper.insert(transaction);

        JSONArray vouts = tx.getJSONArray("vout");
        //循环调用importVoutDetail方法，插入输出out的交易记录
        for (int i = 0; i < vouts.size(); i++) {
            importVoutDetail(vouts.getJSONObject(i),txid);
        }

        JSONArray vins = tx.getJSONArray("vin");


        //循环调用方法，插入输出out的交易记录
        for (int i = 1; i < vins.size(); i++) {
            importVinDetail(vins.getJSONObject(i),txid);
        }
    }

    /**
     * 插入输出out的交易记录
     * @param vout
     * @param txid
     */
    public void importVoutDetail(JSONObject vout, String txid){
        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setTxid(txid);
        JSONObject scriptPubKey = vout.getJSONObject("scriptPubKey");
        JSONArray addresses = scriptPubKey.getJSONArray("addresses");
        //todo check whether sync addresses
        if (addresses != null && !addresses.isEmpty()){
            String address = addresses.getString(0);
            transactionDetail.setAddress(address);
        }
        Double amount = vout.getDouble("value");
        transactionDetail.setAmount(amount);

        transactionDetail.setType((byte) TransactionDetailType.Receive.ordinal());

        transactionDetailMapper.insert(transactionDetail);

    }

    /**
     * 插入输出的vin交易记录
     * @param vin
     * @param txidOrigin
     * @throws Throwable
     */
    public void importVinDetail(JSONObject vin, String txidOrigin) throws Throwable {

        String txid = vin.getString("txid");
        Integer vout = vin.getInteger("vout");

        JSONObject rawTransaxtion = bitcoinJsonRpcClient.getRawTransaxtion(txid);
        JSONArray vouts = rawTransaxtion.getJSONArray("vout");
        JSONObject jsonObject = vouts.getJSONObject(vout);

        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setTxid(txidOrigin);
        transactionDetail.setType((byte) TransactionDetailType.Send.ordinal());
        Double amount = jsonObject.getDouble("value");
        transactionDetail.setAmount(amount);
        JSONObject scriptPubKey = jsonObject.getJSONObject("scriptPubKey");
        JSONArray addresses = scriptPubKey.getJSONArray("addresses");
        if (addresses != null){
            String address = addresses.getString(0);
            transactionDetail.setAddress(address);
        }

        transactionDetailMapper.insert(transactionDetail);
    }
}
