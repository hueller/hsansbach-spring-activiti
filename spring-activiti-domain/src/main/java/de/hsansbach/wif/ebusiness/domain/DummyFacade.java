package de.hsansbach.wif.ebusiness.domain;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service(value = "dummyFacade")
public class DummyFacade {

	public Integer getRandomNumber(Integer range) {
		Random random = new Random();
		return random.nextInt(range) + 1;
	}

}