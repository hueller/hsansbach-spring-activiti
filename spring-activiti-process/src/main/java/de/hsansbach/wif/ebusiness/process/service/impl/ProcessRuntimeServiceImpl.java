package de.hsansbach.wif.ebusiness.process.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsansbach.wif.ebusiness.domain.CustomerFacade;
import de.hsansbach.wif.ebusiness.domain.model.Customer;
import de.hsansbach.wif.ebusiness.process.ProcessKey;
import de.hsansbach.wif.ebusiness.process.VariableKey;
import de.hsansbach.wif.ebusiness.process.service.ProcessRuntimeService;

@Service(value = "processRuntimeService")
public class ProcessRuntimeServiceImpl implements ProcessRuntimeService {
    
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private CustomerFacade customerFacade;

    @Override
    public String startPurchaseProcess(Long customerId, Long productId) {
        Customer customer = customerFacade.loadCustomer(1L);
        
        Map<String, Object> processVariables = new HashMap<String, Object>();
        processVariables.put(VariableKey.PRODUCT_ID.name(), productId);
        processVariables.put(VariableKey.CUSTOMER.name(), customer);
        
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(ProcessKey.PURCHASE.name(), processVariables);
        return processInstance.getId();
    }

	@Override
	public String startUserConfirmationProcess() {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(ProcessKey.USERCONFIRMATION.name());
        return processInstance.getId();
	}
}
