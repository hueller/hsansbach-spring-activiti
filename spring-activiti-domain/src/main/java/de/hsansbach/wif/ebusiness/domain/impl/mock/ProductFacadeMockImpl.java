package de.hsansbach.wif.ebusiness.domain.impl.mock;

import java.util.Calendar;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import de.hsansbach.wif.ebusiness.domain.ProductFacade;
import de.hsansbach.wif.ebusiness.domain.model.Product;

@Profile(value = "standalone")
@Service(value = "productFacade")
public class ProductFacadeMockImpl implements ProductFacade {

    @Override
    public Product loadProduct(Long id) {
    	Product product = new Product();
        product.setId(1L);
        product.setName("TShirt mit HS-Ansbach Logo");
        product.setPrice(19.8);
        
        Calendar validFrom = Calendar.getInstance();
        validFrom.set(Calendar.YEAR, 2013);
        validFrom.set(Calendar.MONTH, 0);
        validFrom.set(Calendar.DAY_OF_MONTH, 1);
        product.setValidFrom(validFrom.getTime());
        
        Calendar validTo = Calendar.getInstance();
        validTo.set(Calendar.YEAR, 2013);
        validTo.set(Calendar.MONTH, 11);
        validTo.set(Calendar.DAY_OF_MONTH, 31);
        product.setValidTo(validTo.getTime());
        
        return product;
    }

}
