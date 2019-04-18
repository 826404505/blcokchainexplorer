package com.zsq.blcokchainexplorer.dto;

import java.util.Date;
import java.util.List;

public class TransactionInfoDTO {
    /**
     * 交易信息的DTO
     */
    private String txid;

    private String txhash;

    private Long size;

    private Integer weight;

    private Date time;

    private Double totalInput;

    private Double totalOutput;

    private Double fees;

    //交易详细信息的集合
    private List<TxDetailInTxInfo> txDetails;
}
