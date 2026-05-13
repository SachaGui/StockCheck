package com.ala.stockcheck.entity;

/**
 * 棚卸明細エンティティ
 */
public class StockCheckItem {

    /** ID */
    private Long id;

    /** 棚卸タスクID */
    private Long checkId;

    /** 商品ID */
    private Long productId;

    /** システム在庫数 */
    private Integer systemQty;

    /** 実際在庫数 */
    private Integer realQty;

    /** 差異数 */
    private Integer diffQty;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCheckId() { return checkId; }
    public void setCheckId(Long checkId) { this.checkId = checkId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Integer getSystemQty() { return systemQty; }
    public void setSystemQty(Integer systemQty) { this.systemQty = systemQty; }

    public Integer getRealQty() { return realQty; }
    public void setRealQty(Integer realQty) { this.realQty = realQty; }

    public Integer getDiffQty() { return diffQty; }
    public void setDiffQty(Integer diffQty) { this.diffQty = diffQty; }
}