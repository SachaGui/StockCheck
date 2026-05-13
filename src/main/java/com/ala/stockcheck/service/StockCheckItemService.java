package com.ala.stockcheck.service;

import com.ala.stockcheck.entity.StockCheckItem;

public interface StockCheckItemService {

    /**
     * 盘点明细录入
     */
    StockCheckItem addItem(Long checkId, Long productId, Integer realQty, Integer systemQty);
}