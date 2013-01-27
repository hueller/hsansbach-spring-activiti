package de.hsansbach.wif.ebusiness.engine.impl;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.hsansbach.wif.ebusiness.engine.ActivitiSpringEngine;
import de.hsansbach.wif.ebusiness.persistence.Order;

@Component
public class ActivitiSpringEngineImpl implements ActivitiSpringEngine {

    @Autowired
    private ProcessEngine processEngine;

    @Override
    public String startProcess(Order order) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("order", order);

        String processDefinitionKey = order.getType().getProcessName();
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey, vars);
        String processInstanceId = processInstance.getId();

        order.setProcessInstanceId(processInstanceId);
        return processInstanceId;
    }

}
