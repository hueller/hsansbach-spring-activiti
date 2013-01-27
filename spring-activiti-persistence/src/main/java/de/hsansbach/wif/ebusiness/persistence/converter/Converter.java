package de.hsansbach.wif.ebusiness.persistence.converter;

public interface Converter<T> {

    String serialize(T t);

    T deserialize(String s);

}
