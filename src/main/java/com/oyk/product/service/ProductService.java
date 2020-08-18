package com.oyk.product.service;

import java.util.List;

import com.oyk.product.entity.Product;

public interface ProductService {
	public int insertProduct(Product product);
	public List<Product> findAllProducts();
	public Product findProductByCode(String code);
	public int updateProduct(Product product);
	public int removeProduct(String code);

}
