package de.hsansbach.wif.ebusiness.process.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.hsansbach.wif.ebusiness.domain.CustomerFacade;
import de.hsansbach.wif.ebusiness.domain.model.Customer;
import de.hsansbach.wif.ebusiness.engine.ActivitiSpringEngine;
import de.hsansbach.wif.ebusiness.process.ProcessKey;
import de.hsansbach.wif.ebusiness.process.VariableKey;
import de.hsansbach.wif.ebusiness.process.service.PurchaseService;

@Service(value = "purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
    
    @Autowired
    private ActivitiSpringEngine engine;

    @Autowired
    private CustomerFacade customerFacade;

    @Transactional
    @Override
    public String execute(Long customerId, Long productId) {
        Customer customer = customerFacade.loadCustomer(1L);
        
        Map<String, Object> processVariables = new HashMap<String, Object>();
        processVariables.put(VariableKey.PRODUCT_ID.name(), productId);
        processVariables.put(VariableKey.CUSTOMER.name(), customer);
       
        return engine.startProcess(ProcessKey.PURCHASE.name(), processVariables);
    }
}
