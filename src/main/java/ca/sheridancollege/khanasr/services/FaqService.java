package ca.sheridancollege.khanasr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.khanasr.dao.FaqDao;
import ca.sheridancollege.khanasr.dao.ProductDao;
import ca.sheridancollege.khanasr.entity.Faq;
import ca.sheridancollege.khanasr.entity.Product;

@Service
public class FaqService {
	
	
	@Autowired
	private FaqDao faqDao;
	
	
	/**
	 * Adding a Faq 
	 * @param faq
	 * @return
	 */
	public Faq addNewFaq(Faq faq ) {
		return faqDao.save(faq);
	}
	
	
	/**
	 * Finding All the Faq
	 * @return
	 */
	public List<Faq> getAllFaq(){
		return faqDao.findAll();
		
	}
	/**
	 * This methid will delete by id 
	 * @param faqId
	 */
	
public void deleteFaq(Long faqId) {
		faqDao.deleteById(faqId);
		
	}
	/**
	 * This method will search the database with id 
	 * @param faqId
	 * @return Faq
	 */
	public Faq getFaqById(Long faqId) {
		return faqDao.findById(faqId).get();
	}
	
	

}
