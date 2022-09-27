package ca.sheridancollege.khanasr.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.khanasr.entity.Role;
import ca.sheridancollege.khanasr.services.RoleService;

/**
 * @author asra.k
 * Aug. 27, 2022
 */

@CrossOrigin(origins = "http://localhost:4200",exposedHeaders="Access-Control-Allow-Origin")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}