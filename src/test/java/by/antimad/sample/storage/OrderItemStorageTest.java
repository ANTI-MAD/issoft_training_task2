package by.antimad.sample.storage;

import by.antimad.sample.data.ValidData;
import by.antimad.sample.entity.OrderItem;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

class OrderItemStorageTest {
    private final OrderItemStorage orderItemStorage = new OrderItemStorage();

    @Test
    void loadAll() {
        final Optional<OrderItem> orderItems = orderItemStorage.loadAll();

        assertThat(ValidData.validOrderItems(), is(equalTo(orderItems)));
    }

    @Test
    void loadById() {
        final String id = "123";
        final OrderItem orderItem = orderItemStorage.loadById(id);

        assertThat(ValidData.validOrder(), is(equalTo(orderItem)));
    }

    @Test
    void persist() {
        final OrderItem orderItem = ValidData.validOrderItem();

        final String id = orderItemStorage.persist(orderItem);

        assertThat(id, is(not(null)));
        final OrderItem loaded = orderItemStorage.loadById(id);
        assertThat(loaded, is(equalTo(orderItem)));
    }

    @Test
    void findByName() {
        final String orderItemName = "Candy";

        final Optional<OrderItem> orderItems = orderItemStorage.findByName(orderItemName);

        assertThat(orderItems, is(equalTo(orderItems)));
    }
}