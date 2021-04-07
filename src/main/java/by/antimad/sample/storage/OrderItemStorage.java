package by.antimad.sample.storage;

import by.antimad.sample.entity.OrderItem;

import java.util.Optional;

public class OrderItemStorage {
    public Optional<OrderItem> loadAll() {
        throw new UnsupportedOperationException("method loadAll() not implemented");
    }

    public OrderItem loadById(String id) {
        throw new UnsupportedOperationException("method loadById(Long id) not implemented");
    }

    public String persist(OrderItem orderItem) {
        throw new UnsupportedOperationException("method persist(OrderItem orderItem) not implemented");
    }

    public Optional<OrderItem> findByName(String orderItemName) {
        throw new UnsupportedOperationException("method findByName(String orderItemName) not implemented");
    }
}
