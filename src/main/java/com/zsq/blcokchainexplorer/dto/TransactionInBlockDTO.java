package com.zsq.blcokchainexplorer.dto;

import java.util.Date;
import java.util.List;

public class TransactionInBlockDTO {
    private String txid;

    private String txhash;

    private Long size;

    private Date time;

    private String blockhash;

    public String getTxid() {
        return txid;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
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

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
