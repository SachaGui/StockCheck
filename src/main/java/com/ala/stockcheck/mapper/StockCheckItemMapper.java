package com.ala.stockcheck.mapper;

import com.ala.stockcheck.entity.StockCheckItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockCheckItemMapper {

    /**
     * 盘点明细录入
     */
    void insertItem(StockCheckItem item);
}