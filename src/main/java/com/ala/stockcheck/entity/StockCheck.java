package com.ala.stockcheck.entity;

import java.util.Date;

// 棚卸タスクEntity
public class StockCheck {

    // ID
    private Long id;

    // 作成時間
    private Date createTime;

    // ステータス
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}