package ca.sheridancollege.khanasr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.khanasr.dao.PotentialCustomerDao;
import ca.sheridancollege.khanasr.entity.PotentialCustomer;

@Service
public class PotentialCustomerService {

	
	@Autowired
	private PotentialCustomerDao potentialCustDao;

	
	
	public List<PotentialCustomer> getAllCustomer() {
		
		return (List<PotentialCustomer>) potentialCustDao.findAll();
	}
	
}