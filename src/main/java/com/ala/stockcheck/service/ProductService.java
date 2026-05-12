package com.ala.stockcheck.service;

import java.util.List;

import com.ala.stockcheck.entity.Product;

public interface ProductService {

    /** 查询全部商品（含库存） */
    List<Product> getAllProducts();

    /** 按ID查询 */
    Product getProductById(Long id);

    /** 新增商品 */
    void addProduct(Product product);

    /** 更新商品 */
    void updateProduct(Product product);

    /** 删除商品 */
    void deleteProduct(Long id);
}