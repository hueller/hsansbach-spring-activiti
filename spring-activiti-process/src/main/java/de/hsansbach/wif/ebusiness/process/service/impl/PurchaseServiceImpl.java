package de.hsansbach.wif.ebusiness.process.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.hsansbach.wif.ebusiness.domain.CustomerFacade;
import de.hsansbach.wif.ebusiness.domain.model.Customer;
import de.hsansbach.wif.ebusiness.engine.ActivitiSpringEngine;
import de.hsansbach.wif.ebusiness.persistence.Order;
import de.hsansbach.wif.ebusiness.persistence.OrderAttribute;
import de.hsansbach.wif.ebusiness.persistence.OrderDao;
import de.hsansbach.wif.ebusiness.persistence.OrderType;
import de.hsansbach.wif.ebusiness.process.service.PurchaseService;

@Service(value = "purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
    
    @Autowired
    private ActivitiSpringEngine engine;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerFacade customerFacade;

    @Transactional
    @Override
    public Long execute(Long customerId, Long productId) {
        Customer customer = customerFacade.loadCustomer(1L);
        
        Map<OrderAttribute, Object> requestAttributes = new HashMap<OrderAttribute, Object>();
        requestAttributes.put(OrderAttribute.PRODUCT_ID, 1L);
        requestAttributes.put(OrderAttribute.CUSTOMER, customer);
        
        Order order = new Order(OrderType.PURCHASE, requestAttributes);
        order = orderDao.save(order);
       
        engine.startProcess(order);
        
        return order.getId();
    }
}
