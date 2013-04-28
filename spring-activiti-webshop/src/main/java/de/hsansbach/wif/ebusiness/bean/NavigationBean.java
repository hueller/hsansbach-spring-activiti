package de.hsansbach.wif.ebusiness.bean;

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
		INDEX,
		PROCESS_RESULT,
		USER_TASKS
	}
	
}