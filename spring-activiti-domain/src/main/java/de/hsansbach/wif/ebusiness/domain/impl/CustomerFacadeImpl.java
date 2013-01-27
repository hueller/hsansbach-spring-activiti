package de.hsansbach.wif.ebusiness.domain.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import de.hsansbach.wif.ebusiness.domain.CustomerFacade;
import de.hsansbach.wif.ebusiness.domain.model.Customer;

@Profile(value = "integration")
@Service(value = "customerFacade")
public class CustomerFacadeImpl implements CustomerFacade {

    @Override
    public Customer loadCustomer(Long id) {
        throw new UnsupportedOperationException("Integration environment not implemented.");
    }

    @Override
    public void updateCustomer(Customer customer) {
        throw new UnsupportedOperationException("Integration environment not implemented.");
    }

}
