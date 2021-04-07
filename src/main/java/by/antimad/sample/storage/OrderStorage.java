package by.antimad.sample.storage;

import by.antimad.sample.entity.Order;
import by.antimad.sample.entity.OrderStatus;

import java.util.Optional;

public class OrderStorage {

    public Optional<Order> loadAll() {
        throw new UnsupportedOperationException("method loadAll() not implemented");
    }

    public Order loadById(String id) {
        throw new UnsupportedOperationException("method loadById(Long id) not implemented");
    }

    public Optional<Order> loadAllByUserId(String userId) {
        throw new UnsupportedOperationException("method loadAllByUserId(Long userId) not implemented");
    }

    public String persist(Order order) {
        throw new UnsupportedOperationException("method persist(Order order) not implemented");
    }

    public Optional<Order> findByStatus(OrderStatus orderStatus) {
        throw new UnsupportedOperationException("method findByStatus(OrderStatus orderStatus) not implemented");
    }
}
