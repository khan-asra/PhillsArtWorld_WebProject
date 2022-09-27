package ca.sheridancollege.khanasr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.khanasr.dao.RoleDao;
import ca.sheridancollege.khanasr.entity.Role;

/**
 * @author asra.k
 * Sep. 3, 2022
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
