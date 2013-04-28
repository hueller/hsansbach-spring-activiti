package de.hsansbach.wif.ebusiness.process.service.impl;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsansbach.wif.ebusiness.process.ProcessKey;
import de.hsansbach.wif.ebusiness.process.service.ProcessRuntimeService;

@Service(value = "processRuntimeService")
public class ProcessRuntimeServiceImpl implements ProcessRuntimeService {
    
    @Autowired
    private RuntimeService runtimeService;

    @Override
    public String startSimpleTestProcess() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(ProcessKey.SIMPLE_TEST.name());
        return processInstance.getId();
    }

	@Override
	public String startUserConfirmationTestProcess() {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(ProcessKey.USER_CONFIRMATION_TEST.name());
        return processInstance.getId();
	}
}
