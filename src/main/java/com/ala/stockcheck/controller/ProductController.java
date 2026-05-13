package com.ala.stockcheck.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ala.stockcheck.common.Result;
import com.ala.stockcheck.entity.Product;
import com.ala.stockcheck.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 查询全部商品（含库存数量）
     */
    @GetMapping
    public Result<List<Product>> getAllProducts() {
        return Result.success(productService.getAllProducts());
    }

    /**
     * 按ID查询商品
     */
    @GetMapping("/{id}")
    public Result<Product> getProductById(@PathVariable Long id) {
        return Result.success(productService.getProductById(id));
    }

    /**
     * 新增商品
     */
    @PostMapping
    public Result<Product> addProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
        return Result.success(product); // insert后id已回填
    }

    /**
     * 更新商品
     */
    @PutMapping("/{id}")
    public Result<String> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody Product product) {
        product.setId(id);
        productService.updateProduct(product);
        return Result.success("更新成功");
    }

    /**
     * 删除商品
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return Result.success("删除成功");
    }
}