package by.antimad.sample;

import by.antimad.sample.entity.Order;
import by.antimad.sample.entity.OrderItem;
import by.antimad.sample.entity.OrderStatus;
import by.antimad.sample.service.OrderService;
import by.antimad.sample.storage.OrderStorage;
import by.antimad.sample.util.OrderValidator;

import java.time.LocalDate;

public class Main {
    public static final String ID = "123";
    public static final String USER_ID = "1234";

    public static void main(String[] args) {
        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();

        orderItem1.setName("Candy");
        orderItem1.setAmount(321);
        orderItem1.setPrice(21);

        orderItem2.setName("Cookies");
        orderItem2.setAmount(234);
        orderItem2.setPrice(34);

        OrderItem[] orderItems = new OrderItem[]{orderItem1, orderItem2};

        Order order = new Order();

        order.setId(ID);
        order.setOrderItems(orderItems);
        order.setDate(LocalDate.now());
        order.setStatus(OrderStatus.PROCESSED);
        order.setUserId(USER_ID);
        order.setDeliveryAddress("address");

        OrderStorage orderStorage = new OrderStorage();
        OrderValidator orderValidator = new OrderValidator();
        OrderService orderService = new OrderService(orderStorage, orderValidator);

        orderService.placeOrder(order);
    }
}
