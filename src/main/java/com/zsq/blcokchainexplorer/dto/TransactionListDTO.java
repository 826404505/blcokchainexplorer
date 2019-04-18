package com.zsq.blcokchainexplorer.dto;

import java.util.Date;

public class TransactionListDTO {
    /**
     * 交易集合的DTO
     */
    private String txid;

    private String txhash;

    private Date time;

    private Double amount;

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
