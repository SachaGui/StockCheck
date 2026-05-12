package com.ala.stockcheck.service;

import com.ala.stockcheck.entity.StockCheck;

/**
 * 棚卸タスクService
 */
public interface StockCheckService {

    /**
     * 棚卸タスク作成
     *
     * @return 棚卸タスク
     */
    StockCheck createCheck();
}