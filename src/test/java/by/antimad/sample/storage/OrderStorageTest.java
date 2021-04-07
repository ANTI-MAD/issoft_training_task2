package by.antimad.sample.storage;

import by.antimad.sample.data.ValidData;
import by.antimad.sample.entity.Order;
import by.antimad.sample.entity.OrderStatus;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.CoreMatchers.is;

class OrderStorageTest {
    private final OrderStorage orderStorage = new OrderStorage();

    @Test
    void testPersist() {
        final Order order = ValidData.validOrder();

        final String id = orderStorage.persist(order);

        assertThat(id, is(not(null)));
        final Order loaded = orderStorage.loadById(id);
        assertThat(loaded, is(equalTo(order)));
    }

    @Test
    void loadByIdTest() {
        final String id = "123";
        final Order order = orderStorage.loadById(id);

        assertThat(ValidData.validOrder(), is(equalTo(order)));
    }

    @Test
    void loadAllTest() {
        final Optional<Order> orders = orderStorage.loadAll();

        assertThat(ValidData.validOrder(), is(equalTo(orders)));
    }

    @Test
    void findByStatusTest() {
        final OrderStatus orderStatus = OrderStatus.PROCESSED;
        final Order validOrder = ValidData.validOrder();
        final Optional<Order> order = orderStorage.findByStatus(orderStatus);

        assertThat(validOrder.getId(), is(equalTo(order.get().getId())));
    }
}