package com.ala.stockcheck.mapper;

import com.ala.stockcheck.entity.StockCheck;
import com.ala.stockcheck.entity.StockCheckItem;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
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
    
    /**
     * 差異計算
     *
     * @param checkId 棚卸タスクID
     * @return 棚卸明細リスト
     */
    List<StockCheckItem> selectItemsByCheckId(Long checkId);
}