package com.zsq.blcokchainexplorer.controller;

import com.zsq.blcokchainexplorer.api.BitcoinJsonRpcClient;
import com.zsq.blcokchainexplorer.api.BitecoinApi;
import com.zsq.blcokchainexplorer.dao.BlockMapper;
import com.zsq.blcokchainexplorer.dto.BlockDetailDTo;
import com.zsq.blcokchainexplorer.dto.BlockListDTO;
import com.zsq.blcokchainexplorer.po.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/block")
@CrossOrigin
public class BlockController {

    @Autowired
    private BitecoinApi bitecoinApi;

    @Autowired
    private BitcoinJsonRpcClient bitcoinJsonRpcClient;

    @Autowired
    private BlockMapper blockMapper;

    @Value("${blockchain.recentCount}")
    private Integer recentCount;

    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks(){
        //从数据库里面查找数据
        List<Block> blocks = blockMapper.selectRecent();
        List<BlockListDTO> blockListDTOS = blocks.stream().map(block -> {
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setHeight(block.getHeight());
            blockListDTO.setTime(block.getTime());
            blockListDTO.setTxSize(block.getTxSize());
            blockListDTO.setSizeOnDisk(block.getSizeOnDisk());
            return blockListDTO;
        }).collect(Collectors.toList());

        return blockListDTOS;
    }

    //通过ID查找当前的block
    @GetMapping("/getRecentBlocksById")
    public List<BlockListDTO> getRecentBlocksById(@RequestParam Integer blockchainId){

        return null;
    }

    //通过name和type查找当前的block
    @GetMapping("/getRecentBlockByNameType")
    public List<BlockListDTO> getRecentBlockByNameType(@RequestParam String name,
                                                       @RequestParam String type){

        return null;
    }

    //通过hash查找块的详细信息
    @GetMapping("/getBlockDetailByHash")
    public BlockDetailDTo getBlockDetailByHash(@RequestParam String blockhash){
        //调用API的方法进数据库里面查找block
        //Block block = blockMapper.selectByPrimaryKey(blockhash);
        return null;
    }

    //通过height查找指定块的详细信息
    @GetMapping("/getBlockDetailByHeight")
    public BlockDetailDTo getBlockDetailByHeight(@RequestParam String blockheight){
        //调用API的方法进数据库里面查找block

        return null;
    }

}
