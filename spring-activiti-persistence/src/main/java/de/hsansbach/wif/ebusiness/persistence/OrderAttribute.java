package de.hsansbach.wif.ebusiness.persistence;

import de.hsansbach.wif.ebusiness.persistence.converter.BeanConverter;
import de.hsansbach.wif.ebusiness.persistence.converter.Converter;
import de.hsansbach.wif.ebusiness.persistence.converter.LongConverter;

public enum OrderAttribute {

    CONTRACT_ID(LongConverter.getInstance()), 
    CUSTOMER(BeanConverter.getInstance()), 
    PRODUCT_ID(LongConverter.getInstance());

    @SuppressWarnings("rawtypes")
    private Converter converter;

    @SuppressWarnings("rawtypes")
    OrderAttribute(Converter converter) {
        this.converter = converter;
    }

    @SuppressWarnings("rawtypes")
    public Converter getConverter() {
        return converter;
    }
}
