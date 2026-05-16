package com.ala.stockcheck.dto;

public class CheckItemRequest {

    // 商品ID
    private Long productId;

    // 实际盘点数量
    private Integer realQty;

    // 系统库存数量
    private Integer systemQty;

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Integer getRealQty() { return realQty; }
    public void setRealQty(Integer realQty) { this.realQty = realQty; }

    public Integer getSystemQty() { return systemQty; }
    public void setSystemQty(Integer systemQty) { this.systemQty = systemQty; }
}