package de.hsansbach.wif.ebusiness.domain.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import de.hsansbach.wif.ebusiness.domain.DummyFacade;

@Service(value = "dummyFacade")
public class DummyFacadeImpl implements DummyFacade {

    @Override
    public Integer getRandomNumber(Integer range) {
    	Random random = new Random();
    	return random.nextInt(range) + 1;
    }

}