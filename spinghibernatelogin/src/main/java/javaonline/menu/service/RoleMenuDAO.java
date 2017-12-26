package javaonline.menu.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javaonline.login.model.Role;
import javaonline.menu.model.Menus;


@Component
@ComponentScan("javaonline.menu.service.*")
public class RoleMenuDAO {
	

	@PersistenceContext
	private EntityManager em;

	

	public List<Menus> findAll() {
		return em.createQuery("SELECT r FROM Menus r ").getResultList();
	}
	
	

	

	public Set<Menus> findMenus(String roleName) {
		Role m= (Role) em.createQuery( "SELECT c FROM role c WHERE c.name = :roleName ")
			    .setParameter("roleName", roleName).getSingleResult();
		
	//	Set<WsdlReqCred> req_creds_set =  wr.getReqCreds();
		
			
		return  m.getRoleMenus();
	}


	
	
public LinkedHashMap<String, String> menuMap(String roleName) {
		
		Role ro= (Role) em.createQuery( "SELECT c FROM Role c WHERE c.name = :roleName ")
			    .setParameter("roleName", roleName.trim()).getSingleResult();
		
		System.out.println("RO " + ro.getUsers().size());
		System.out.println("RO " + ro.getRoleMenus().size());
		System.out.println("RO " + ro.getId());
		System.out.println("RO " + ro.getName());
		
		
		LinkedHashMap<String,String> menuMapTmp=new LinkedHashMap<String,String>();
 		for ( Menus menu: ro.getRoleMenus())
		{
		System.out.println(" menus in role "+ menu.getMenu_name());
		menuMapTmp.put( menu.getMenu_name(),menu.getMenu_url());
		
		}
		return menuMapTmp;
		
	}
	
	



	

}
