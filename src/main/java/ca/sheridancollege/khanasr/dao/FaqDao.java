package ca.sheridancollege.khanasr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.khanasr.entity.Faq;



@Repository
public interface FaqDao extends CrudRepository<Faq, Long> { 

	
	public List<Faq> findAll();
}
