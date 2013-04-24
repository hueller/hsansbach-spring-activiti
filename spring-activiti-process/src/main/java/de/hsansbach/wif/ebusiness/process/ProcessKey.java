package de.hsansbach.wif.ebusiness.process;

public enum ProcessKey {
	
	PURCHASE("purchaseProcess");

	String key;
	
	ProcessKey(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
}
