package com.ala.stockcheck.service.impl;

import com.ala.stockcheck.entity.StockCheckItem;
import com.ala.stockcheck.mapper.StockCheckItemMapper;
import com.ala.stockcheck.service.StockCheckItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockCheckItemServiceImpl implements StockCheckItemService {

    private final StockCheckItemMapper stockCheckItemMapper;

    public StockCheckItemServiceImpl(StockCheckItemMapper stockCheckItemMapper) {
        this.stockCheckItemMapper = stockCheckItemMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public StockCheckItem addItem(Long checkId, Long productId, Integer realQty, Integer systemQty) {
        StockCheckItem item = new StockCheckItem();
        item.setCheckId(checkId);
        item.setProductId(productId);
        item.setSystemQty(systemQty);
        item.setRealQty(realQty);
        // 差异计算：实际数量 - 系统数量
        item.setDiffQty(realQty - systemQty);
        stockCheckItemMapper.insertItem(item);
        return item;
    }
}