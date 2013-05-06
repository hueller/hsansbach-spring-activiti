package de.hsansbach.wif.ebusiness.webshop.bean;

import javax.inject.Named;

@Named
public class NavigationBean {

	public String navigateTo(String key) {
		return NavigationKey.valueOf(key).getFileName();
	}

	public String navigateTo(NavigationKey key) {
		return key.getFileName();
	}

	public enum NavigationKey {
		LOGIN("/login"), 
		MAIN("/protected/main"), 
		PROCESS_RESULT("/protected/process_result"), 
		USER_TASKS("/protected/user_tasks");
		
		private String fileName;
		private NavigationKey(String fileName) {
			this.fileName = fileName;
		}
		public String getFileName() {
			// Navigation by redirect to display the correct page in the browser URL input field.
			return fileName + "?faces-redirect=true";
		}
	}

}