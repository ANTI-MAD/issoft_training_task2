package by.antimad.sample.util;

import by.antimad.sample.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderValidator {
    private final Logger logger = LoggerFactory.getLogger(OrderValidator.class);
    public boolean validateForPlaceOrder(Order order) {
        if (order.getOrderItems() == null) {
            logger.debug("OrderItems is null");
            return false;
        }

        if (order.getDate() == null) {
            logger.debug("Date is null");
            return false;
        }

        if (order.getDeliveryAddress() == null) {
            logger.debug("DeliveryAddress is null");
            return false;
        }

        if (order.getStatus() == null) {
            logger.debug("Status is null");
            return false;
        }

        if (order.getUserId() == null) {
            logger.debug("UserId is null");
            return false;
        }

        logger.debug("Order is OK");
        return true;
    }
}
