<<<<<<< Updated upstream
=======
package ca.sheridancollege.khanasr;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;

import ca.sheridancollege.khanasr.controller.FaqController;
import ca.sheridancollege.khanasr.controller.ProductController;
import ca.sheridancollege.khanasr.controller.UserController;
import ca.sheridancollege.khanasr.dao.ProductDao;
import ca.sheridancollege.khanasr.dao.UserDao;
import ca.sheridancollege.khanasr.entity.Faq;
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
	private FaqController faqController;
	
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
		assertTrue(products.size()>1, "");
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
        assertTrue(product!=null, "Product is not workingas expected");

    }
    
    
    /**

     * Test case to make sure that user is not able to check the products

     * @throws AccessDeniedException

     */

    @Test

    @WithMockUser(roles = "User")

    public void checkDelete() throws AccessDeniedException {
        AccessDeniedException thrown = assertThrows(AccessDeniedException.class, () -> {
            prodController.getProductById((long) 6);
        });
        Assertions.assertEquals("Access is denied", thrown.getMessage());



    }

    

    /**

     * Test case to check if anyone can check FAQ without logging in

     */

    @Test
    public void checkFaq() {

        List<Faq> faqs = faqController.getAllFaq();
        assertTrue( faqs.size() > 1,"FAQ not received");

    }

    
   

    
	
	
	

	
	
	
	


	
	
	
	
}
>>>>>>> Stashed changes
