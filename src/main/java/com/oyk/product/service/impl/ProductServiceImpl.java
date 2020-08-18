package com.oyk.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyk.product.entity.Product;
import com.oyk.product.mapper.ProductMapper;
import com.oyk.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    
	@Autowired
	private ProductMapper productMapper;
	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.insertProduct(product);
	}
	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productMapper.findAllProducts();
	}
	@Override
	public Product findProductByCode(String code) {
		// TODO Auto-generated method stub
		return productMapper.findProductByCode(code);
	}
	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.updateProduct(product);
	}
	@Override
	public int removeProduct(String code) {
		// TODO Auto-generated method stub
		return productMapper.removeProduct(code);
	}

}
