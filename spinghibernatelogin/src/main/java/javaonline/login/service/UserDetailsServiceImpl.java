package javaonline.login.service;

import java.util.HashSet;
import java.util.Set;

import javaonline.login.model.MyUserDetails;
import javaonline.login.model.Role;
import javaonline.login.model.User;
import javaonline.login.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	System.out.println("in userdetail service");
    	
    
    	String[] parts = username.split("\\|");
    	String email = parts[0]; 
    	String mobile = parts[1];
    	
    	
        User user = userRepository.findByEmailAndMobile(email, mobile);
        
    	System.out.println("in userdetail service user "+ user.getEmail() +  "  mb " + user.getMobile() + " uder id "+ user.getId());

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
       
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        System.out.println("pass = " + user.getPassword());
        
        MyUserDetails myUserDetails = new MyUserDetails (user.getEmail(), user.getPassword(), grantedAuthorities,user.getMessage());
        return myUserDetails;
    
        
     //   return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
    
    
  
}
