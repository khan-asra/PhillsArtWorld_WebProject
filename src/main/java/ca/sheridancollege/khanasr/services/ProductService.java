package ca.sheridancollege.khanasr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.khanasr.dao.ProductDao;
import ca.sheridancollege.khanasr.entity.Product;

/**
 * @author asra.k
 * Sep. 9, 2022
 */

@Service
public class ProductService {

	@Autowired
	private ProductDao productRepository;
	
	public Product addNewProduct(Product product ) {
		
		return productRepository.save(product);
		
		
		
	}
	
	
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}
	
	
	
public List<Product> galleryProducts() {
		
		return productRepository.findAll();
	}
	
	public void deleteProduct(Long productId) {
		
		//delete by ID - PLEASE WORKKKKK
		productRepository.deleteById(productId);
		
	}
	
	public Product getProductById(Long productId) {
		return productRepository.findById(productId).get();
	}
}
