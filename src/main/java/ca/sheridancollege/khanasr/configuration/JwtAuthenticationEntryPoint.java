
package ca.sheridancollege.khanasr.configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author asra.k
 * Sep. 9, 2022
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	
	/**
	 * Commences an authentication scheme.
	 * 
	 */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, 
    		AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }

}
