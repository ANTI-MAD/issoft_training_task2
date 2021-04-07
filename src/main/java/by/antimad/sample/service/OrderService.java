package by.antimad.sample.service;

import by.antimad.sample.entity.Order;
import by.antimad.sample.storage.OrderStorage;
import by.antimad.sample.util.OrderValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OrderService {
    private final OrderStorage orderStorage;
    private final OrderValidator orderValidator;
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderService(OrderStorage orderStorage, OrderValidator orderValidator) {
        this.orderStorage = orderStorage;
        this.orderValidator = orderValidator;
    }

    public String placeOrder(Order order) {
        logger.debug("placeOrder(Order order) method called");
        final boolean valid = orderValidator.validateForPlaceOrder(order);
        if (!valid) {
            throw new IllegalArgumentException("order is not valid " + order);
        }

        final String id = orderStorage.persist(order);

        return id;
    }

    public Optional<Order> loadAllByUserId(String userId) {
        logger.debug("loadAllByUserId(String userId) method called");
        return orderStorage.loadAllByUserId(userId);
    }

}
