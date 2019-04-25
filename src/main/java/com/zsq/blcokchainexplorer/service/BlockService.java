package com.zsq.blcokchainexplorer.service;

import com.zsq.blcokchainexplorer.dto.BlockDetailDTo;

public interface BlockService {

    BlockDetailDTo BlockDetailDToByHash(String blockhash);

    BlockDetailDTo getBlockDetailByHeight(Integer blockheight) throws Throwable;
}
