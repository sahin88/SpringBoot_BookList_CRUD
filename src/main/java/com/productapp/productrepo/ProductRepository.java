package com.productapp.productrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productapp.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
