package ca.sheridancollege.khanasr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.khanasr.entity.Faq;

import ca.sheridancollege.khanasr.services.FaqService;

@CrossOrigin("*")

@RestController
public class FaqController {
	
	
	@Autowired
	private FaqService faqService; 
	
	
	@GetMapping({"/getAllFaq"})
	public List<Faq> getAllFaq(){
		return faqService.getAllFaq() ;
	}
	
	@PreAuthorize("hasRole('Admin')")
	@PostMapping({"/addEditFaq"})
	public void addNewFaq(@RequestBody Faq faq) {
		faqService.addNewFaq(faq);
	}
	
	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping({"/deleteFaq/{id}"})
	public void deleteFaq(@PathVariable("id") Long id) {
		faqService.deleteFaq(id)	;}

	@GetMapping({"/getFaqById/{id}"})
	public Faq getFaqById(@PathVariable("id") Long id) {
		return faqService.getFaqById(id);
		
		
	}
}
