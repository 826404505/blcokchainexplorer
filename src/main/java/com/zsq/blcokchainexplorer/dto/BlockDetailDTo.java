package com.zsq.blcokchainexplorer.dto;

import com.zsq.blcokchainexplorer.po.Transaction;

import java.util.Date;
import java.util.List;

public class BlockDetailDTo {
    /**
     * 块的详细信息DTO
     */
    private String blockhash;

    private Integer height;

    private Date time;

    private Integer txSize;

    private Long sizeOnDisk;

    private Double difficulty;

    private String prevBlockhash;

    private String nextBlockhash;

    private Double outputTotal;

    private Double transactionFees;

    private String merkleRoot;

    private List<Transaction> transactions;

    public BlockDetailDTo() {
    }

    public BlockDetailDTo(String blockhash, Integer height, Date time, Integer txSize, Long sizeOnDisk, Double difficulty, String prevBlockhash, String nextBlockhash, Double outputTotal, Double transactionFees, String merkleRoot, List<Transaction> transactions) {
        this.blockhash = blockhash;
        this.height = height;
        this.time = time;
        this.txSize = txSize;
        this.sizeOnDisk = sizeOnDisk;
        this.difficulty = difficulty;
        this.prevBlockhash = prevBlockhash;
        this.nextBlockhash = nextBlockhash;
        this.outputTotal = outputTotal;
        this.transactionFees = transactionFees;
        this.merkleRoot = merkleRoot;
        this.transactions = transactions;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getTxSize() {
        return txSize;
    }

    public void setTxSize(Integer txSize) {
        this.txSize = txSize;
    }

    public Long getSizeOnDisk() {
        return sizeOnDisk;
    }

    public void setSizeOnDisk(Long sizeOnDisk) {
        this.sizeOnDisk = sizeOnDisk;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public String getPrevBlockhash() {
        return prevBlockhash;
    }

    public void setPrevBlockhash(String prevBlockhash) {
        this.prevBlockhash = prevBlockhash;
    }

    public String getNextBlockhash() {
        return nextBlockhash;
    }

    public void setNextBlockhash(String nextBlockhash) {
        this.nextBlockhash = nextBlockhash;
    }

    public Double getOutputTotal() {
        return outputTotal;
    }

    public void setOutputTotal(Double outputTotal) {
        this.outputTotal = outputTotal;
    }

    public Double getTransactionFees() {
        return transactionFees;
    }

    public void setTransactionFees(Double transactionFees) {
        this.transactionFees = transactionFees;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
