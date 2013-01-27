package de.hsansbach.wif.ebusiness.engine;

import de.hsansbach.wif.ebusiness.persistence.Order;

public interface ActivitiSpringEngine {
    
    String startProcess(Order order);

}
