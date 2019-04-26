package com.zsq.blcokchainexplorer.controller;

import com.zsq.blcokchainexplorer.api.BitcoinJsonRpcClient;
import com.zsq.blcokchainexplorer.api.BitecoinApi;
import com.zsq.blcokchainexplorer.dao.BlockChainMapper;
import com.zsq.blcokchainexplorer.dao.BlockMapper;
import com.zsq.blcokchainexplorer.dto.BlockDetailDTo;
import com.zsq.blcokchainexplorer.dto.BlockListDTO;
import com.zsq.blcokchainexplorer.po.Block;
import com.zsq.blcokchainexplorer.service.BlockService;
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

    @Autowired
    private BlockService blockService;

    @Autowired
    private BlockChainMapper blockChainMapper;

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

    //通过blockChinID查找当前的block
    @GetMapping("/getRecentBlocksById")
    public List<BlockListDTO> getRecentBlocksById(@RequestParam Integer blockchainId){
        List<BlockListDTO> blockListDTOByBlockchainId = blockMapper.getBlockListDTOByBlockchainId(blockchainId);

        return blockListDTOByBlockchainId;
    }

    //通过name和type查找当前的block
    @GetMapping("/getRecentBlockByNameType")
    public List<BlockListDTO> getRecentBlockByNameType(@RequestParam(required = false, defaultValue = "") String name,
                                                       @RequestParam(required = false, defaultValue = "") String type){
        //首先根据name和type找到该blockchain，然后根据查到的blockchain的blockchain_id查找block
        Integer blockchainId = blockChainMapper.getBlockchainIdByNameAndType(name, type);

        //然后根据blockchainId在block表里面查找List<BlockListDTO>
        List<BlockListDTO> blockListDTOS = blockService.getBlockListByBlockchainId(blockchainId);

        return blockListDTOS;
    }

    //通过hash查找块的详细信息，其中包括交易信息的list
    @GetMapping("/getBlockDetailByHash")
    public BlockDetailDTo getBlockDetailByHash(@RequestParam String blockhash){
        //调用service
        BlockDetailDTo blockDetailDTo = blockService.BlockDetailDToByHash(blockhash);
        return blockDetailDTo;
    }

    //通过height查找指定块的详细信息
    @GetMapping("/getBlockDetailByHeight")
    public BlockDetailDTo getBlockDetailByHeight(@RequestParam Integer blockheight) throws Throwable {
        //调用API的方法进数据库里面查找block
        BlockDetailDTo blockDetailDTo = blockService.getBlockDetailByHeight(blockheight);
        return blockDetailDTo;
    }

}
