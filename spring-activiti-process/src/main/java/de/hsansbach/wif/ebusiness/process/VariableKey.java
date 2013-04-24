package de.hsansbach.wif.ebusiness.process;

public enum VariableKey {

	CUSTOMER("customer"), 
	PRODUCT_ID("productId");

	String key;

	VariableKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
