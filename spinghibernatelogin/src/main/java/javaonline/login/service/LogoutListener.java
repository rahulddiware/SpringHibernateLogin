package javaonline.login.service;

import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javaonline.login.model.MyUserDetails;

@Controller
@RequestMapping(value = "/error")
public class LogoutListener implements ApplicationListener<SessionDestroyedEvent> {

    @Override
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public void onApplicationEvent(SessionDestroyedEvent event)
    {
        List<SecurityContext> lstSecurityContext = event.getSecurityContexts();
        UserDetails ud;
        MyUserDetails mud;
        for (SecurityContext securityContext : lstSecurityContext)
        {
            ud = (UserDetails) securityContext.getAuthentication().getPrincipal();
            
            mud = (MyUserDetails) securityContext.getAuthentication().getPrincipal();
            
            System.out.println("Session details " + mud.getMessage() + mud.getUsername() + mud.getPassword());
            
            if (ud==null)
            {
            	
            	System.out.println("Session Expired Redirect to ");
            	
            }
            
            // ...
        }
    }

}