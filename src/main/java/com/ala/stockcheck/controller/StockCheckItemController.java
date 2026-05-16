package com.ala.stockcheck.controller;

import com.ala.stockcheck.common.Result;
import com.ala.stockcheck.dto.CheckItemRequest;
import com.ala.stockcheck.entity.StockCheckItem;
import com.ala.stockcheck.service.StockCheckItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checks")
public class StockCheckItemController {

    private final StockCheckItemService stockCheckItemService;

    public StockCheckItemController(StockCheckItemService stockCheckItemService) {
        this.stockCheckItemService = stockCheckItemService;
    }

    /**
     * 盘点明细录入
     * POST /api/checks/{id}/items
     */
    @PostMapping("/{id}/items")
    public Result<StockCheckItem> addItem(
            @PathVariable Long id,
            @RequestBody CheckItemRequest request) {

        StockCheckItem item = stockCheckItemService.addItem(
                id,
                request.getProductId(),
                request.getRealQty(),
                request.getSystemQty()
        );
        return Result.success(item);
    }
}