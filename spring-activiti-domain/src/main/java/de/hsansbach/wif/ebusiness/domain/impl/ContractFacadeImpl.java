package de.hsansbach.wif.ebusiness.domain.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import de.hsansbach.wif.ebusiness.domain.ContractFacade;
import de.hsansbach.wif.ebusiness.domain.model.Contract;

@Profile(value = "integration")
@Service(value = "contractFacade")
public class ContractFacadeImpl implements ContractFacade {

    @Override
    public Long createContract(Long customerId, Long productId) {
        throw new UnsupportedOperationException("Integration environment not implemented.");
    }

    @Override
    public Contract loadContract(Long id) {
        throw new UnsupportedOperationException("Integration environment not implemented.");
    }

}
