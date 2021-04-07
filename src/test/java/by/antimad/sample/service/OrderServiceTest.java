package by.antimad.sample.service;

import by.antimad.sample.data.ValidData;
import by.antimad.sample.entity.Order;
import by.antimad.sample.storage.OrderStorage;
import by.antimad.sample.util.OrderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

class OrderServiceTest {
    private OrderService orderService;

    @Mock
    private OrderValidator orderValidator;

    @Mock
    private OrderStorage orderStorage;

    @BeforeEach
    void before() {
        MockitoAnnotations.initMocks(this);

        when(orderStorage.persist(any())).thenReturn(UUID.randomUUID().toString());
        when(orderStorage.loadAllByUserId(any())).thenReturn(Optional.of(ValidData.validOrder()));
        orderService = new OrderService(orderStorage, orderValidator);
    }


    @Test
    void placeOrderTest() {
        final Order order = ValidData.validOrder();

        final String id = orderStorage.persist(order);
        assertThat(id, is(equalTo(order.getId())));
    }

    @Test
    void loadAllByUserIdTest() {
        final String userId = "1234";
        final Order validOrder = ValidData.validOrder();
        final Optional<Order> order = orderService.loadAllByUserId(userId);

        assertThat(validOrder.getId(), is(equalTo(order.get().getId())));
    }
}