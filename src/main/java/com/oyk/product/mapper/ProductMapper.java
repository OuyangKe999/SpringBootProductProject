package com.oyk.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.oyk.product.entity.Product;

@Mapper
public interface ProductMapper {
	
	@Insert("insert into product values(#{code},#{name},#{summary},#{description})")
	public int insertProduct(Product product);
	
	@Select("select * from product")
	public List<Product> findAllProducts();
	
	@Select("select * from product where code=#{code}")
	public Product findProductByCode(String code);
	
	@Update("update product set name=#{name}, summary=#{summary}, description=#{description} where code=#{code}")
	public int updateProduct(Product product);
	
	@Delete("delete from product where code=#{code}")
	public int removeProduct(String code);
}
