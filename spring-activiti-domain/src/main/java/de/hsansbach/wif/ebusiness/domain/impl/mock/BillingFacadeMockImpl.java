package de.hsansbach.wif.ebusiness.domain.impl.mock;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import de.hsansbach.wif.ebusiness.domain.BillingFacade;

@Profile(value = "standalone")
@Service(value = "billingFacade")
public class BillingFacadeMockImpl implements BillingFacade {

    @Override
    public void createInvoice(Long contractId) {
        // Mock implementation... nothing to do
    }

}
