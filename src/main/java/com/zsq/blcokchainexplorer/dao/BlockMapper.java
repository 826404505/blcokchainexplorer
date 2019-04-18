package com.zsq.blcokchainexplorer.dao;

import com.zsq.blcokchainexplorer.po.Block;

public interface BlockMapper {

    int truncate();

    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);
}