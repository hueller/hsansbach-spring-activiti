package de.hsansbach.wif.ebusiness.engine.impl;

import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.hsansbach.wif.ebusiness.engine.ActivitiSpringEngine;

@Component
public class ActivitiSpringEngineImpl implements ActivitiSpringEngine {

    @Autowired
    private ProcessEngine processEngine;

    @Override
    public String startProcess(String processKey, Map<String, Object> variables) {
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(processKey, variables);
        return processInstance.getId();
    }

}
