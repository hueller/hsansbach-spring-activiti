package de.hsansbach.wif.ebusiness.persistence.evaluator;

import de.hsansbach.wif.ebusiness.persistence.Order;

public class OrderExpressionRoot {

    private Order order;

    public OrderExpressionRoot(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

}