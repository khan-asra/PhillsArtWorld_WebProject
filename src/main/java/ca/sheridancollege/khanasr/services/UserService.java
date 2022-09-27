package ca.sheridancollege.khanasr.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ca.sheridancollege.khanasr.dao.RoleDao;
import ca.sheridancollege.khanasr.dao.UserDao;
import ca.sheridancollege.khanasr.entity.Role;
import ca.sheridancollege.khanasr.entity.User;

import java.util.HashSet;
import java.util.Set;
/**
 * @author asra.k
 * Sep. 5, 2022
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);
        
        
        //introducting guest 
        Role guestRole = new Role();
        guestRole.setRoleName("Guest");
        guestRole.setRoleDescription("Guest");
        roleDao.save(guestRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
     //   adminUser.setUserPassword("admin@123");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserName("asra123");
        user.setUserPassword(getEncodedPassword("asra@123"));
        user.setUserFirstName("asra");
        user.setUserLastName("khan");
     //   user.setUserPassword("asra@123");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
        
        

        User guest = new User();
        guest.setUserName("none");
        guest.setUserPassword(getEncodedPassword("none"));
        guest.setUserFirstName("none");
        guest.setUserLastName("none");
     //   user.setUserPassword("asra@123");
        Set<Role> guestRoles = new HashSet<>();
        guestRoles.add(guestRole);
        guest.setRole(guestRoles);
        userDao.save(guest);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}