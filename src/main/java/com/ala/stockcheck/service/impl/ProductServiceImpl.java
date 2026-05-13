package com.ala.stockcheck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ala.stockcheck.entity.Product;
import com.ala.stockcheck.exception.BusinessException;
import com.ala.stockcheck.mapper.ProductMapper;
import com.ala.stockcheck.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAllProducts() {
        return productMapper.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Product product = productMapper.findById(id);
        if (product == null) {
            throw new BusinessException("商品不存在，ID: " + id);
        }
        return product;
    }

    @Override
    public void addProduct(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void updateProduct(Product product) {
        // 先确认商品存在
        getProductById(product.getId());
        int rows = productMapper.update(product);
        if (rows == 0) {
            throw new BusinessException("更新失败");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        // 先确认商品存在
        getProductById(id);
        productMapper.delete(id);
    }
}