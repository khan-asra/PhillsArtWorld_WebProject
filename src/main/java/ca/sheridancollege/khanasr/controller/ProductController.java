package ca.sheridancollege.khanasr.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ca.sheridancollege.khanasr.entity.Product;
import ca.sheridancollege.khanasr.entity.ProductImage;
import ca.sheridancollege.khanasr.services.ProductService;

/**
 * @author asra.k
 * Sep. 9, 2022
 */


@CrossOrigin("*")
//@CrossOrigin(origins= "http://localhost:4200", methods = {RequestMethod.GET,RequestMethod.POST}, 
//exposedHeaders="Access-Control-Allow-Origin")
@RestController
public class ProductController {
	
	/**
	 * To add Admin security to any mapping make sure to 
	 * add annotation
	 * 	@PreAuthorize("hasRole('Admin')")
	 */
	
	
	@Autowired
	private ProductService productService;
	
	/**
	 * This method will be used to Upload the images 
	 * @param product
	 * @param file
	 * @return product 
	 */
	@PreAuthorize("hasRole('Admin')")
	@PostMapping(value ={"/addEditProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Product addUsertoAddPlayList(@RequestPart("product") Product product,
			@RequestPart("imageFile") MultipartFile[] file) {
	
		try {
			Set<ProductImage> images = uploadImage(file);
			product.setProductImages(images);
			return productService.addNewProduct(product);
			
		}
		catch(Exception e){
			System.out.print(e.getMessage());
			return null;
		}
		
	
		
	
		
	}
	
	/**
	 * This methos will process all the images od the product 
	 * @param multipartFiles
	 */
	public Set<ProductImage> uploadImage(MultipartFile[] multipartFiles)throws IOException {
		
		Set<ProductImage> images = new HashSet<>();
		
		
		for (MultipartFile file : multipartFiles) {
			ProductImage productImage = new ProductImage(
			file.getOriginalFilename(),
			file.getContentType(),
			file.getBytes()
			);
			
			images.add(productImage);
		}
		
		return images;
	}
	
	//@CrossOrigin( "")
	@GetMapping({"/getGallery"})
	public List<Product> goGallery() {	 
		return productService.getAllProducts();
	
}

	@GetMapping({"/getAllProducts"})
	public List<Product> getAllProducts() {
		return productService.getAllProducts();

}
	
	
	@GetMapping({"/galleryProducts"})
	public List<Product> galleryProducts(Model model) {
		return productService.galleryProducts();

}
	/**
	 * this method will be used to delete the product 
	 * @param productId
	 */
	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping({"/deleteProduct/{productId}"})
	public void deleteProduct(@PathVariable("productId") Long productId) {
		productService.deleteProduct(productId);
	}
	
	/**
	 * This method will fetch the product from the database by ID
	 * @param productId
	 * @return
	 */
//	@PreAuthorize("hasRole('Admin')") 
	@GetMapping({"/getProductById/{productId}"})
	public Product getProductById(@PathVariable("productId") Long productId) {
		return productService.getProductById(productId);
		
		
	}
	
	
	
	}
