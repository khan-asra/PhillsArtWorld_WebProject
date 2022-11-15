package ca.sheridancollege.khanasr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.sheridancollege.khanasr.entity.PotentialCustomer;
import ca.sheridancollege.khanasr.services.PotentialCustomerService;



@RestController
@CrossOrigin("*")
public class PotentialCustomerController {

	@Autowired
	private PotentialCustomerService potentialCustService;
	
//
//	@GetMapping({"/getPotentialCustomers"})
//	public List<PotentialCustomer> getPotentialCustomer(){
//		return  potentialCustService.getAllCustomer();
//	}

}
