package de.hsansbach.wif.ebusiness.domain;

import java.util.Random;

import javax.inject.Named;

@Named
public class DummyFacade {

	public Integer getRandomNumber(Integer range) {
		Random random = new Random();
		return random.nextInt(range) + 1;
	}

}