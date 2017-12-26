package javaonline.login.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class MyUserDetails extends org.springframework.security.core.userdetails.User {

	private String message;

public String getMessage() {
		return message;
	}


public void setMessage(String message) {
		this.message = message;
	}


public MyUserDetails(String username, String password,
        Collection<? extends GrantedAuthority> authorities, String message ) {
    super(username, password, authorities);
    
    this.message=message;
    // TODO Auto-generated constructor stub
}



}