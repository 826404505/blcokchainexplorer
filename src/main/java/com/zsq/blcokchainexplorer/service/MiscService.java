package com.zsq.blcokchainexplorer.service;

public interface MiscService {
    //通过height插入
    void importFromHeight(Integer blockHeight, Boolean isClean);
    //通过hash插入
    void importFromHash(String blockHash, Boolean isClean);
}
