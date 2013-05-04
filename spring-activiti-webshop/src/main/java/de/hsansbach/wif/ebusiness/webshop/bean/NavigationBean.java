package de.hsansbach.wif.ebusiness.webshop.bean;

import javax.inject.Named;

@Named
public class NavigationBean {

	public String navigateTo(String key) {
		return NavigationKey.valueOf(key).name().toLowerCase();
	}

	public String navigateTo(NavigationKey key) {
		return key.name().toLowerCase();
	}

	enum NavigationKey {
		LOGIN, MAIN, PROCESS_RESULT, USER_TASKS
	}

}