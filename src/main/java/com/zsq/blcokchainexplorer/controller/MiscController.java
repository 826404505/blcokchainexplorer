package com.zsq.blcokchainexplorer.controller;

import com.zsq.blcokchainexplorer.dto.ImportStateDTO;
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

    //搜索首先考虑是否是hash，height，还是address，然后再进行查询
    @GetMapping("/search")
    public Object search(@RequestParam String keyword){
        //1、首先判断是hash，height，address
        //2、然后根据
        return null;
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
