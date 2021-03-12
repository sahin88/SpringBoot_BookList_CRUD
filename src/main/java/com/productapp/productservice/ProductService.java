package com.productapp.productservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.product.entity.Product;
import com.productapp.productrepo.ProductRepository;




@Service
public class ProductService {
	
	@Autowired
	ProductRepository productrepo;
	
	public List<Product> getAllProduct(){
		
		return productrepo.findAll();
	}
	
	public void saveProduct(Product product) {
		productrepo.save(product);
	}
	
	public Product getProductById(Long Id) {
		return productrepo.findById(Id).get();
	}
	
	public void deleteProductById(Long id) {
		productrepo.deleteById(id);
	}

}
