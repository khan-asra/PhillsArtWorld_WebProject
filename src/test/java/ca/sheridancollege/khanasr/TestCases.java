package ca.sheridancollege.khanasr;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import ca.sheridancollege.khanasr.controller.ProductController;
import ca.sheridancollege.khanasr.controller.UserController;
import ca.sheridancollege.khanasr.dao.ProductDao;
import ca.sheridancollege.khanasr.dao.UserDao;
import ca.sheridancollege.khanasr.entity.JwtRequest;
import ca.sheridancollege.khanasr.entity.Product;
import ca.sheridancollege.khanasr.entity.User;

@SpringBootTest
public class TestCases {

	
	@Autowired
	private ProductController prodController;
	
	@Autowired
	private UserController userController;
	
	@Autowired
	private ProductDao productDao;
	

	/**
	 * 
	 * Checking the product should be greater then 0. 
	 * As we already have products added into the database 
	 */
	@Test
	public void checkProducts() {
		List<Product> products = prodController.getAllProducts();
		assertTrue(products.size()>1);
	}
	
	/**
	 * 
	 */
	
	
	@Test
	@WithMockUser(roles="User")
	public void checkUser() {
		assertTrue(userController.forUser().equals("This URL is only accessible to the user"));
	}
	
	
	
	
    @Test

    @WithMockUser(roles="Admin")

    public void checkProductByID() {

        Product product = prodController.getProductById((long)6);

        assertTrue( "Product is not workingas expected",product!=null);

    }
    
   

    
	
	
	

	
	
	
	


	
	
	
	
}
