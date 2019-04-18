package com.zsq.blcokchainexplorer.dto;

import java.util.Date;

public class BlockListDTO {
    /**
     * 存装block集合的DTO
     */
    private Integer height;
    private Date time;
    private Integer txSize;
    private Long sizeOnDisk;

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
}
