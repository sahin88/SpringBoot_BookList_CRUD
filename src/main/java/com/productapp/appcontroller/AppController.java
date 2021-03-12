package com.productapp.appcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.productapp.product.entity.Product;
import com.productapp.productservice.ProductService;

@Controller
public class AppController {
	@Autowired
	ProductService productservice;
	
	@RequestMapping("/")
	public String HomePageView(Model model) {
		List<Product> allproduct=productservice.getAllProduct();
		model.addAttribute("allproduct",allproduct);
		return "index";
	}
	
	
	@RequestMapping("/new")
	public String NewProductForm(Model model) {
		Product product= new Product();
		model.addAttribute("product",product);	
		return "NewBookForm";
	}
	
	
	@PostMapping("/save")
	public String SaveProduct(@ModelAttribute("product")Product product) {
		productservice.saveProduct(product);
			
		return "redirect:/";
	}
	

	@RequestMapping("/edit/{id}")
	public ModelAndView UpdateProduct(@PathVariable(name="id") Long Id) {
		ModelAndView mav = new ModelAndView("UpdateForm");
		Product product=productservice.getProductById(Id);
		mav.addObject("product",product);
		return mav;
	}
	
	
	@PostMapping("/delete/{id}")
	public String DeleteProduct(@PathVariable(name="id") Long Id) {
		
		productservice.deleteProductById(Id);
		
	
		return "redirect:/";
	}

}
