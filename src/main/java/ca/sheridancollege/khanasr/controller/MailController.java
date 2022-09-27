package ca.sheridancollege.khanasr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ca.sheridancollege.khanasr.services.SendMail;



@CrossOrigin(origins = "http://localhost:4200",exposedHeaders="Access-Control-Allow-Origin")
@RestController
public class MailController {

	
	
	@Autowired
	private SendMail senderService;
	
	/**
	 * This method is called when submit button is pressed on contact me
	 * Email will be send with all the details.
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param subject
	 * @param message
	 * @return
	 */
//	@PostMapping({"/submitContactEmail/{firstName}/{lastName}/{email}/{subject}/{message}"})
//		public String submitContactEmail(@PathVariable("firstName") String firstName, @PathVariable("lastName")String lastName,
//				@PathVariable("email") String email, @PathVariable("subject") String subject, @PathVariable("message") String message
////				, @RequestParam("files") MultipartFile[] files 
//				) {
//		System.out.print("--------------------------INSIDE------------------------------");
//		String emailAddress="1khan.asra@gmail.com";
//		System.out.print("Name"+firstName);
//		String fullName = firstName+"  "+lastName;
//		
//		//FileSystemResource fileSystem= new FileSystemResource(new File(files));
//		message= message+"\n"+"Please contact me at "+ email+"\n"+fullName;
//		
//		senderService.sendMail(emailAddress,subject,message
//			//	,files
//				
//				);
//		return "send";
//		
//	}
//	
//	
//	
//	
//}




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
