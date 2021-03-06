package com.zsq.blcokchainexplorer.dao;

import com.zsq.blcokchainexplorer.dto.BlockListDTO;
import com.zsq.blcokchainexplorer.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockMapper {

    int truncate();

    List<Block> selectRecent();

    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(@Param("blockhash") String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<BlockListDTO> getBlockListDTOByBlockchainId(Integer blockchainId);

}