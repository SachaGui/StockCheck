package com.ala.stockcheck.service.impl;

import com.ala.stockcheck.dto.DiffResponse;
import com.ala.stockcheck.entity.StockCheck;
import com.ala.stockcheck.entity.StockCheckItem;
import com.ala.stockcheck.mapper.StockCheckMapper;
import com.ala.stockcheck.service.StockCheckService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    /**
     * 差異計算
     */
    @Override
    public List<DiffResponse> getDiff(Long id){
    	List<StockCheckItem> items=stockCheckMapper.selectItemsByCheckId(id);
    	return items.stream().map(item -> {
            DiffResponse response = new DiffResponse();
            response.setCheckId(item.getCheckId());
            response.setProductId(item.getProductId());
            response.setSystemQty(item.getSystemQty());
            response.setRealQty(item.getRealQty());
            response.setDiffQty(item.getRealQty() - item.getSystemQty());
            return response;
        }).collect(Collectors.toList());
    }
}