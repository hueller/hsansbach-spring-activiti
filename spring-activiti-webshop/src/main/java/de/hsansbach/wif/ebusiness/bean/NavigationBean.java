package de.hsansbach.wif.ebusiness.bean;

import javax.inject.Named;

@Named
public class NavigationBean {
	
	public String get(NavigationKey key) {
		return key.name().toLowerCase();
	}
	
	public String get(String key) {
		return NavigationKey.valueOf(key).name().toLowerCase();
	}
	
	enum NavigationKey {
		PROCESS_RESULT,
		USER_TASKS
	}
	
}