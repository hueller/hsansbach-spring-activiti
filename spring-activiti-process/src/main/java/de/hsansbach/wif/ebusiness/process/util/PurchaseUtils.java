package de.hsansbach.wif.ebusiness.process.util;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.hsansbach.wif.ebusiness.domain.CustomerFacade;
import de.hsansbach.wif.ebusiness.domain.ProductFacade;
import de.hsansbach.wif.ebusiness.domain.model.Customer;
import de.hsansbach.wif.ebusiness.domain.model.Product;

@Component(value = "purchaseUtils")
public class PurchaseUtils {

    @Autowired
    private CustomerFacade customerFacade;

    @Autowired
    private ProductFacade productFacade;

    public boolean validatePurchase(Long customerId, Long productId) throws Exception {
        // Validate customer
        Customer customer = customerFacade.loadCustomer(customerId);
        if (customer.getFraudFlag()) {
            return false;
        }
        
        // Validate product
        Product product = productFacade.loadProduct(productId);
        if (new DateTime(product.getValidFrom()).isAfterNow() || new DateTime(product.getValidTo()).isBeforeNow()) {
            return false;
        }
        
        return true;
    }

}
