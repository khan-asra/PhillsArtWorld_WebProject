package ca.sheridancollege.khanasr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.khanasr.entity.PotentialCustomer;

@Repository
public interface PotentialCustomerDao extends CrudRepository<PotentialCustomer, Long> {
	
	public List<PotentialCustomer> findAll();

}
