package ca.sheridancollege.khanasr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.khanasr.entity.User;


/**
 * @author asra.k
 * Aug. 27, 2022
 */
@Repository
public interface UserDao extends CrudRepository<User, String> {
}

