package com.axsos.productandcatagories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.productandcatagories.models.Category;
import com.axsos.productandcatagories.models.Product;
import com.axsos.productandcatagories.repositories.CategoryRepository;
import com.axsos.productandcatagories.repositories.ProductRepository;


@Service
public class ProdCatServices {
	private final ProductRepository proRepo;
	private final CategoryRepository catRepo;
	public ProdCatServices(ProductRepository proRepo, CategoryRepository catRepo) {
		
		this.proRepo = proRepo;
		this.catRepo = catRepo;
	}
	
	public Product createProduct(Product p) {
		return proRepo.save(p);
	}
	
	public Category createCategory(Category c) {
		return catRepo.save(c);
	}
	
	public List<Product> findAllProduct(){
		return proRepo.findAll();
	}
	
	public List<Category> findAllCategory(){
		return catRepo.findAll();
	}
	
	public Product findProductById(Long id) {
		Optional<Product> optionalProduct = proRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}
	
	public Category findCategorytById(Long id) {
		Optional<Category> optionalCategory = catRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	
	public List<Category> allCategoriesExept(Product product){
		return catRepo.findByProductsNotContains(product);
	}
	
    public List<Product> allProductsExept(Category category){
    	return proRepo.findByCategoriesNotContains(category);
    }

    public Product add(Long pro_id,Long cat_id) {
    	Product product = proRepo.findById(pro_id).orElse(null);
    	Category category = catRepo.findById(cat_id).orElse(null);
    	List<Category> cat = product.getCategories();
    	 cat.add(category);
    	 product.setCategories(cat);
    	 return proRepo.save(product);
    }
    
    public Category addPro(Long id,Long idpro) {
    	Category category = catRepo.findById(id).orElse(null);
    	Product product = proRepo.findById(idpro).orElse(null);
    	List<Product> pro = category.getProducts();
    	 pro.add(product);
    	 category.setProducts(pro);
    	 return catRepo.save(category);
    }
}

