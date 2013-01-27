package de.hsansbach.wif.ebusiness.domain;

import de.hsansbach.wif.ebusiness.domain.model.Customer;

public interface CustomerFacade {
    
    Customer loadCustomer(Long id);
    
    void updateCustomer(Customer customer);

}
