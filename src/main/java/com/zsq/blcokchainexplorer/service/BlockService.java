package com.zsq.blcokchainexplorer.service;

import com.zsq.blcokchainexplorer.dto.BlockDetailDTo;
import com.zsq.blcokchainexplorer.dto.BlockListDTO;

import java.util.List;

public interface BlockService {

    BlockDetailDTo BlockDetailDToByHash(String blockhash);

    BlockDetailDTo getBlockDetailByHeight(Integer blockheight) throws Throwable;

    List<BlockListDTO> getBlockListByBlockchainId(Integer blockchainId);
}
