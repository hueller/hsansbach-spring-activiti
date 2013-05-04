package de.hsansbach.wif.ebusiness.webshop.bean;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import de.hsansbach.wif.ebusiness.webshop.bean.NavigationBean.NavigationKey;

@Named
@SessionScoped
public class UserBean {

	@Autowired
	private NavigationBean navigationBean;

	private String username;

	public String login() {
		return navigationBean.navigateTo(NavigationKey.MAIN);
	}

	public String logout() {
		this.username = "";
		return navigationBean.navigateTo(NavigationKey.LOGIN);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
