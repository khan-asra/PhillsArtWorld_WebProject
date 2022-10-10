package ca.sheridancollege.khanasr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.khanasr.entity.JwtRequest;
import ca.sheridancollege.khanasr.entity.JwtResponse;
import ca.sheridancollege.khanasr.services.JwtService;

/**
 * @author asra.k
 * Aug. 27, 2022
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200",exposedHeaders="Access-Control-Allow-Origin")
@CrossOrigin(origins= "http://localhost:4200", methods = {RequestMethod.GET}, exposedHeaders="Access-Control-Allow-Origin")

public class JwtController {

    @Autowired
    private JwtService jwtService;

    /**
     * This method is called from the front end to check the jwt request 
     * @param jwtRequest
     * @return
     * @throws Exception
     */
    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}

