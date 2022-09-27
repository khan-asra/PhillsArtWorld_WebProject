package ca.sheridancollege.khanasr.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.khanasr.entity.Role;

/**
 * @author asra.k
 * Aug. 27, 2022
 */
@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
