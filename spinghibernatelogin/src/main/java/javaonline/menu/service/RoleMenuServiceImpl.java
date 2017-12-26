package javaonline.menu.service;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RoleMenuServiceImpl implements RoleMenuService {

	@Autowired
	private RoleMenuDAO roleMenuDao;

	
	@Transactional(readOnly = true)
	public  LinkedHashMap<String, String> menuMap(String roleName) {
		System.out.println(" in find " + roleName);
	return	 roleMenuDao.menuMap(roleName);

	}


}