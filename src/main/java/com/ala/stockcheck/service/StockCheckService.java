package com.ala.stockcheck.service;

import com.ala.stockcheck.dto.DiffResponse;
import com.ala.stockcheck.entity.StockCheck;
import java.util.List;

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

    /**
     * 差異計算
     *
     * @param id 棚卸タスクID
     * @return 差異リスト
     */
    List<DiffResponse> getDiff(Long id);
}