package com.axsos.productandcatagories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.productandcatagories.models.Category;
import com.axsos.productandcatagories.models.Product;
import com.axsos.productandcatagories.services.ProdCatServices;

@Controller
public class StoreController {
	private final ProdCatServices proCatServices;

	public StoreController(ProdCatServices proCatServices) {
	
		this.proCatServices = proCatServices;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}
	
	@RequestMapping (value = "/product", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return"product.jsp";
		}else {
			Product product1 = proCatServices.createProduct(product);
			return "redirect:/products/new";
		}
		
	}
	
	@RequestMapping("/category/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	
	@RequestMapping (value = "/category", method = RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return"category.jsp";
		}else {
			Category category1 = proCatServices.createCategory(category);
			return "redirect:/category/new";
		}
		
	}

	@RequestMapping("/products/{id}")
	public String showProduct(Model model, @PathVariable("id") Long id) {
		Product product1 = proCatServices.findProductById(id);
		model.addAttribute("product",product1);
		List<Category> unlisted = proCatServices.allCategoriesExept(product1);
		model.addAttribute("unlisted",unlisted);
		return "showProduct.jsp";
	}
	@RequestMapping("/addCategory/{id}")
	public String addCategories(@PathVariable("id") Long pro_id, @RequestParam("category") Long cat_id) {
		proCatServices.add(pro_id,cat_id);
		return"redirect:/products/"+pro_id;
		
	}
	
	@RequestMapping("/category/{id}")
	public String showCategory(Model model, @PathVariable("id") Long id) {
		Category category = proCatServices.findCategorytById(id);
		model.addAttribute("category",category);
		List<Product> unlisted = proCatServices.allProductsExept(category);
		model.addAttribute("unlisted",unlisted);
		return "showCategory.jsp";
	}
	
	@RequestMapping("/addProduct/{id}")
	public String addProducts(@PathVariable("id") Long id, @RequestParam("product") Long idpro) {
		proCatServices.addPro(id, idpro);
		return"redirect:/category/"+id;
		
	}
}
