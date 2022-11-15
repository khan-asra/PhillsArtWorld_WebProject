package ca.sheridancollege.khanasr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.khanasr.dao.PotentialCustomerDao;
import ca.sheridancollege.khanasr.entity.PotentialCustomer;
import ca.sheridancollege.khanasr.services.PotentialCustomerService;
import ca.sheridancollege.khanasr.services.SendMail;



@CrossOrigin(origins = "http://localhost:4200",exposedHeaders="Access-Control-Allow-Origin")
@RestController
public class MailController {

	

	@Autowired
	private SendMail senderService;
	
	@Autowired
	private PotentialCustomerService potentialCustService;
	
	@Autowired
	private PotentialCustomerDao potentialCustDao;
	


	@GetMapping({"/getPotentialCustomers"})
	public List<PotentialCustomer> getPotentialCustomer(){
		return  potentialCustService.getAllCustomer();
	}
	

	
	@PostMapping({"/sendMail"})
	public PotentialCustomer sendMail(@RequestBody PotentialCustomer potentialCust) {
		
		
		potentialCustDao.save(potentialCust);
		
		System.out.print("--------------------------INSIDE------------------------------");
		String emailAddress="1khan.asra@gmail.com";
		System.out.print("Name"+ potentialCust.firstName);
		String fullName = potentialCust.firstName+"  "+potentialCust.lastName;
		
		potentialCust.message = potentialCust.message+ "\n"+"Please contact me at "+ potentialCust.email+"\n"+fullName;
		senderService.sendMail(emailAddress,potentialCust.subject,potentialCust.message
			
	
				);
		
		return potentialCust;
	}



@PostMapping({"/submitContactEmail/{firstName}/{lastName}/{email}/{subject}/{message}"})
public String submitContactEmail(@RequestParam String firstName, @RequestParam String lastName,
		@RequestParam String email, @RequestParam String subject, @RequestParam String message
//		, @RequestParam("files") MultipartFile[] files 
		) {
System.out.print("--------------------------INSIDE------------------------------");
String emailAddress="1khan.asra@gmail.com";
System.out.print("Name"+firstName);
String fullName = firstName+"  "+lastName;

//FileSystemResource fileSystem= new FileSystemResource(new File(files));
message= message+"\n"+"Please contact me at "+ email+"\n"+fullName;

senderService.sendMail(emailAddress,subject,message
	//	,files
		
		);
return "send";

}






}
