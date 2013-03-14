package de.hsansbach.wif.ebusiness.bean;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import de.hsansbach.wif.ebusiness.process.service.PurchaseService;

@Named
@RequestScoped
public class PurchaseBean {

	@Autowired
	private PurchaseService purchaseService;
	
	public String submit() {
		purchaseService.execute(1L, 1L);
		return "ok";
	}

}