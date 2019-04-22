package com.zsq.blcokchainexplorer.controller;

import com.zsq.blcokchainexplorer.dto.BlockDetailDTo;
import com.zsq.blcokchainexplorer.dto.BlockListDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {

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
        return null;
    }

    //通过height查找指定块的详细信息
    @GetMapping("/getBlockDetailByHeight")
    public BlockDetailDTo getBlockDetailByHeight(@RequestParam String blockheight){
        return null;
    }

}
