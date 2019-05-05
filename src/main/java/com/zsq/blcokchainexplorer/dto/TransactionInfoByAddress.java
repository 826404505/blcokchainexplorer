package com.zsq.blcokchainexplorer.dto;

import com.zsq.blcokchainexplorer.po.Transaction;

import java.util.List;

public class TransactionInfoByAddress {

    private String txid;

    private String address;

    private Byte type;

    private Double amount;

    private List<Transaction> transactions;

    public TransactionInfoByAddress(String txid, String address, Byte type, Double amount, List<Transaction> transactions) {
        this.txid = txid;
        this.address = address;
        this.type = type;
        this.amount = amount;
        this.transactions = transactions;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
