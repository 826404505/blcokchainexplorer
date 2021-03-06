package com.zsq.blcokchainexplorer.dao;

import com.zsq.blcokchainexplorer.po.BlockChain;
import org.apache.ibatis.annotations.Param;

public interface BlockChainMapper {
    int deleteByPrimaryKey(Integer blockchainId);

    int insert(BlockChain record);

    int insertSelective(BlockChain record);

    BlockChain selectByPrimaryKey(Integer blockchainId);

    int updateByPrimaryKeySelective(BlockChain record);

    int updateByPrimaryKey(BlockChain record);

    Integer getBlockchainIdByNameAndType(@Param("name") String name, @Param("type") String type);
}