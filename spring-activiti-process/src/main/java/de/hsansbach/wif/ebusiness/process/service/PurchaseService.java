package de.hsansbach.wif.ebusiness.process.service;

public interface PurchaseService {
    
    Long execute(Long customerId, Long productId);
    
}
