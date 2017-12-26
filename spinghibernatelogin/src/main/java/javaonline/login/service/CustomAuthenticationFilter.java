package javaonline.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    protected String obtainUsername(HttpServletRequest request) {
        String username = super.obtainUsername(request);
        String extraparam = request.getParameter("extraparam");
        System.out.println("User name in authentication filter "+ username + " extra param "+ extraparam);
        return username+"|"+extraparam;
    }
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    	
    			 System.out.println("in attempt authentication");
    	         String username = obtainUsername(request);
    	         String password = obtainPassword(request);
    	 
    	         if (username == null) {
    	             username = "";
    	         }
    	 
    	         if (password == null) {
    	             password = "";
    	         }
    	 
    	         username = username.trim();
    	         
    	         System.out.println("user name in attempt auth " + username);
    	 
    	         UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
    
    	         setDetails(request, authRequest);
    	 
    	         return this.getAuthenticationManager().authenticate(authRequest);
    	     }

}