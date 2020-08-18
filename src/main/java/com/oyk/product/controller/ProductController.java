package com.oyk.product.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oyk.product.entity.Product;
import com.oyk.product.form.ProductForm;
import com.oyk.product.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@GetMapping("show")
	public String show(ModelMap model) {
		model.addAttribute("productForm", new ProductForm());
		return "product/add";
	}
	
	@PostMapping("add")
	//表单验证需要加@Valid、因为需要知道结果所以需要加BindingResult
	public String submitAddProduct(@Valid @ModelAttribute ProductForm productForm,BindingResult bindingResult, ModelMap model) {
		System.out.println("bindingResult.hasErrors() is--"+bindingResult.hasErrors());
		if(bindingResult.hasErrors()) {
			model.addAttribute("productForm", productForm);
			return "product/add";
		}
		Product product = new Product();
		BeanUtils.copyProperties(productForm, product);
		productService.insertProduct(product);
		return "redirect:list";	
	}
	
	@GetMapping("list")
	public String showListPage(ModelMap model) {
		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		return "product/list";
	}
	
	@GetMapping("update/{code}")
	public String showUpdatePage(@PathVariable("code") String code, ModelMap model) {
		//get the product info
		Product product = productService.findProductByCode(code);
		ProductForm productForm = new ProductForm();
		BeanUtils.copyProperties(product, productForm);
		model.addAttribute("productForm", productForm);
		return "product/update";
	}
	
	@PostMapping("update")
	public String updateProduct(@Valid @ModelAttribute ProductForm productForm, 
			BindingResult bindingResult, ModelMap model) {
		//验证未通过
		if(bindingResult.hasErrors()) {
			model.addAttribute("productForm", productForm);
			return "product/update";
		}
		
		//验证通过，更新数据库
		Product product = new Product();
		BeanUtils.copyProperties(productForm, product);
		productService.updateProduct(product);
		
		return "redirect:/product/list";
		
	}
	
	@GetMapping("remove/{code}")
	public String removeProduct(@PathVariable("code") String code, ModelMap model) {
		//根据code，从数据库中移除数据
		productService.removeProduct(code);
		
		return "redirect:/product/list";
		
	}

}
