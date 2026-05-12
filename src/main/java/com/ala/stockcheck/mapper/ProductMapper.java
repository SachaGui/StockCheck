package com.ala.stockcheck.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ala.stockcheck.entity.Product;

@Mapper
public interface ProductMapper {
    List<Product> findAll();
    Product findById(Long id);
    int insert(Product product);
    int update(Product product);
    int delete(Long id);
}