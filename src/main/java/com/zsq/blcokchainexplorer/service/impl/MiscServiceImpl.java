package com.zsq.blcokchainexplorer.service.impl;

import com.zsq.blcokchainexplorer.api.BitecoinApi;
import com.zsq.blcokchainexplorer.dao.BlockMapper;
import com.zsq.blcokchainexplorer.service.MiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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
    }
}
