package com.ala.stockcheck.service.impl;

import com.ala.stockcheck.entity.StockCheck;
import com.ala.stockcheck.mapper.StockCheckMapper;
import com.ala.stockcheck.service.StockCheckService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 棚卸タスクService実装
 */
@Service
public class StockCheckServiceImpl implements StockCheckService {

    private final StockCheckMapper stockCheckMapper;

    public StockCheckServiceImpl(StockCheckMapper stockCheckMapper) {
        this.stockCheckMapper = stockCheckMapper;
    }

    /**
     * 棚卸タスク作成
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public StockCheck createCheck() {

        StockCheck stockCheck = new StockCheck();

        stockCheck.setCreateTime(new Date());

        stockCheck.setStatus("NEW");

        stockCheckMapper.insertCheck(stockCheck);

        return stockCheck;
    }
}