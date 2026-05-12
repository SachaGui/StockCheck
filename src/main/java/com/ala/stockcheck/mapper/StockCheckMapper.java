package com.ala.stockcheck.mapper;

import com.ala.stockcheck.entity.StockCheck;
import org.apache.ibatis.annotations.Mapper;

// 棚卸タスクMapper

@Mapper
public interface StockCheckMapper {

    /**
     * 棚卸タスク登録
     *
     * @param stockCheck 棚卸タスク
     */
    void insertCheck(StockCheck stockCheck);
}