package com.ala.stockcheck.controller;

import com.ala.stockcheck.common.Result;
import com.ala.stockcheck.dto.DiffResponse;
import com.ala.stockcheck.entity.StockCheck;
import com.ala.stockcheck.service.StockCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 棚卸タスクController
 */
@RestController
@RequestMapping("/api/checks")
public class StockCheckController {

    private final StockCheckService stockCheckService;

    public StockCheckController(StockCheckService stockCheckService) {
        this.stockCheckService = stockCheckService;
    }

    /**
     * 棚卸タスク作成
     *
     * @return 作成結果
     */
    @PostMapping
    public Result<StockCheck> createCheck() {

        StockCheck stockCheck = stockCheckService.createCheck();

        return Result.success(stockCheck);
    }
    
    /**
     * 差異計算
     *
     * @param id 棚卸タスクID
     * @return 差異リスト
     */
    @GetMapping("/{id}/diff")
    public Result<List<DiffResponse>> getDiffResult(@PathVariable Long id){
    List<DiffResponse> diffList = stockCheckService.getDiff(id);
    return Result.success(diffList);
    }
}