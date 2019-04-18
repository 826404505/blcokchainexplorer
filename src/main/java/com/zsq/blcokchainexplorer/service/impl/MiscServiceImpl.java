package com.zsq.blcokchainexplorer.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zsq.blcokchainexplorer.api.BitecoinApi;
import com.zsq.blcokchainexplorer.dao.BlockMapper;
import com.zsq.blcokchainexplorer.po.Block;
import com.zsq.blcokchainexplorer.service.MiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MiscServiceImpl implements MiscService {

    @Autowired
    private BitecoinApi bitecoinApi;

    @Autowired
    private BlockMapper blockMapper;

    @Async
    @Override
    public void importFromHeight(Integer blockHeight, Boolean isClean) {

    }

    @Async
    @Override
    public void importFromHash(String blockHash, Boolean isClean) {
        //判断是否是isClean
        if (isClean){
            blockMapper.truncate();
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
    }
}
