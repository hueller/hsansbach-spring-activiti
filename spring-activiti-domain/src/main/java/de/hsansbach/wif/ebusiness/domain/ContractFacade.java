package de.hsansbach.wif.ebusiness.domain;

import de.hsansbach.wif.ebusiness.domain.model.Contract;

public interface ContractFacade {
    
    Long createContract(Long customerId, Long productId);
    
    Contract loadContract(Long id);

}
