package ru.esvetlichny.furniturestore.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.esvetlichny.furniturestore.model.Order;
import ru.esvetlichny.furniturestore.model.dto.CreateOrderDto;

public interface OrderService {
    Order create(CreateOrderDto orderDto, Long customerId);

    Page<Order> findAll(Example<Order> of, Pageable pageable);

    Order findOne(Long id);

    void delete(Long id);
}
