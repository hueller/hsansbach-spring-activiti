package de.hsansbach.wif.ebusiness.webshop;

import javax.inject.Named;

@Named
public class NavigationHelper {

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
			return fileName;
		}
	}

}