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

    @GetMapping("/search")
    public Object search(@RequestParam String keyword){

        return null;
    }

    @GetMapping("/importFromHigh")
    public void importFromHigh(@RequestParam Integer blockhight,
                               @RequestParam(required = false, defaultValue = "false") Boolean isClean) throws Throwable {

        miscService.importFromHeight(blockhight,isClean);
    }

    @GetMapping("/importFromHash")
    public void importFromHash(@RequestParam String blockhash,
                               @RequestParam(required = false, defaultValue = "false") Boolean isClean) throws Throwable {

        miscService.importFromHash(blockhash,isClean);
    }

    @GetMapping("/getImportState")
    public ImportStateDTO getImportState(){

        return null;
    }


}
