package com.zsq.blcokchainexplorer.controller;

import com.zsq.blcokchainexplorer.dto.BlockDetailDTo;
import com.zsq.blcokchainexplorer.dto.ImportStateDTO;
import com.zsq.blcokchainexplorer.service.BlockService;
import com.zsq.blcokchainexplorer.service.MiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/misc")
@EnableAutoConfiguration
public class MiscController {

    @Autowired
    private MiscService miscService;

    @Autowired
    private BlockService blockService;

    //搜索首先考虑是否是hash，height，还是address，然后再进行查询
    @GetMapping("/search")
    public Object search(@RequestParam String keyword) throws Throwable {
        //1、首先判断是hash，height，address
        //2、然后根据是hash，height，address调用该方法查找
        if (keyword.length() < 7){//是属于height
            //调用根据height查找
            BlockDetailDTo blockDetailByHeight = blockService.getBlockDetailByHeight(Integer.parseInt(keyword));
            return blockDetailByHeight;
        }else {//是hash
            //根据hash查找
            BlockDetailDTo blockDetailDTo = blockService.BlockDetailDToByHash(keyword);
            return blockDetailDTo;
        }

    }

    //通过height插入
    @GetMapping("/importFromHigh")
    public void importFromHigh(@RequestParam Integer blockhight,
                               @RequestParam(required = false, defaultValue = "false") Boolean isClean) throws Throwable {

        miscService.importFromHeight(blockhight,isClean);
    }

    //通过hash插入
    @GetMapping("/importFromHash")
    public void importFromHash(@RequestParam String blockhash,
                               @RequestParam(required = false, defaultValue = "false") Boolean isClean) throws Throwable {

        miscService.importFromHash(blockhash,isClean);
    }

    //得到插入的状态
    @GetMapping("/getImportState")
    public ImportStateDTO getImportState(){

        return null;
    }


}
