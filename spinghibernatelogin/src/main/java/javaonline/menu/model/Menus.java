package javaonline.menu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javaonline.login.model.Role;

@Entity
@Table(name = "menus")
public class Menus {

	private Long menu_id;
	private String menu_name;
	private String menu_url;
	private short menu_order;

	private Role role;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Long menu_id) {
		this.menu_id = menu_id;
	}

	@ManyToOne
	@JoinColumn(name = "id")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public short getMenu_order() {
		return menu_order;
	}

	public void setMenu_order(short menu_order) {
		this.menu_order = menu_order;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_url() {
		return menu_url;
	}

	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}

}
