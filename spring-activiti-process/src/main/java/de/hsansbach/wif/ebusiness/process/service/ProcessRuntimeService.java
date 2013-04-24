package de.hsansbach.wif.ebusiness.process.service;

public interface ProcessRuntimeService {
    
    String startPurchaseProcess(Long customerId, Long productId);
    
    String startUserConfirmationProcess();
    
}
