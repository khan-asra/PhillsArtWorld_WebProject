package ca.sheridancollege.khanasr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.khanasr.entity.Product;



@Repository
public interface ProductDao extends CrudRepository<Product, Long> { 
	
	public List<Product> findAll();
	
	
}
