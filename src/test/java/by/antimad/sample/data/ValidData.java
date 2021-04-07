package by.antimad.sample.data;

import by.antimad.sample.entity.Order;
import by.antimad.sample.entity.OrderItem;
import by.antimad.sample.entity.OrderStatus;

import java.time.LocalDate;

public class ValidData {

    public static OrderItem validOrderItem() {
        final OrderItem orderItem = new OrderItem();

        orderItem.setName("Candy");
        orderItem.setAmount(321);
        orderItem.setPrice(21);

        return orderItem;
    }

    public static OrderItem[] validOrderItems() {
        final OrderItem orderItem1 = new OrderItem();
        final OrderItem orderItem2 = new OrderItem();

        orderItem1.setName("Candy");
        orderItem1.setAmount(321);
        orderItem1.setPrice(21);

        orderItem2.setName("Cookies");
        orderItem2.setAmount(234);
        orderItem2.setPrice(34);

        final OrderItem[] orderItems = new OrderItem[]{orderItem1, orderItem2};
        return orderItems;
    }

    public static Order validOrder() {
        final OrderItem[] orderItems = validOrderItems();

        final Order order = new Order();

        order.setId("123");
        order.setOrderItems(orderItems);
        order.setDate(LocalDate.now());
        order.setStatus(OrderStatus.PROCESSED);
        order.setUserId("1234");
        order.setDeliveryAddress("address");

        return order;
    }
}
