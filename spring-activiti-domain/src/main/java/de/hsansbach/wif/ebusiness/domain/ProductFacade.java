package de.hsansbach.wif.ebusiness.domain;

import de.hsansbach.wif.ebusiness.domain.model.Product;

public interface ProductFacade {
    
    Product loadProduct(Long id);

}
