package de.hsansbach.wif.ebusiness.engine;

import java.util.Map;

public interface ActivitiSpringEngine {
    
    String startProcess(String processKey, Map<String, Object> variables);

}
