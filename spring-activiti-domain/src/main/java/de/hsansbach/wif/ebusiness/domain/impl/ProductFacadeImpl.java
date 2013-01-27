package de.hsansbach.wif.ebusiness.domain.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import de.hsansbach.wif.ebusiness.domain.ProductFacade;
import de.hsansbach.wif.ebusiness.domain.model.Product;

@Profile(value = "integration")
@Service(value = "productFacade")
public class ProductFacadeImpl implements ProductFacade {

    @Override
    public Product loadProduct(Long id) {
        throw new UnsupportedOperationException("Integration environment not implemented.");
    }
}
