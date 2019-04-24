package com.zsq.blcokchainexplorer.dao;

import com.zsq.blcokchainexplorer.po.Block;

import java.util.List;

public interface BlockMapper {

    int truncate();

    List<Block> selectRecent();

    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);
}