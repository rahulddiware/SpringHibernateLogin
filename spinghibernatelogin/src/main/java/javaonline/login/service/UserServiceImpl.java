package javaonline.login.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javaonline.login.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Override
	public void save(User user) {
	
		//write code to create user
		
	}

	
	    @Override
	    public String findLoggedInUsername() {
	        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
	        if (userDetails instanceof UserDetails) {
	            return ((UserDetails)userDetails).getUsername();
	        }

	        return null;
	    }


}
