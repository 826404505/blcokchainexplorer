package com.zsq.blcokchainexplorer.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BlockScheduler {

    //导入日志的输出
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 实现定时器的定时功能
     */
    @Scheduled(fixedRate = 3000)
    public void importBlockTransaction(){
        //不调用功能模块，先实现定时的日志输出
        logger.info("start on import block transactions");
    }

}
