package ru.esvetlichny.furniturestore.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.esvetlichny.furniturestore.exception.EntityNotExistsException;
import ru.esvetlichny.furniturestore.exception.RelationNotExistsException;
import ru.esvetlichny.furniturestore.model.Furniture;
import ru.esvetlichny.furniturestore.model.Order;
import ru.esvetlichny.furniturestore.model.User;
import ru.esvetlichny.furniturestore.model.dto.CreateOrderDto;
import ru.esvetlichny.furniturestore.repo.FurnitureRepository;
import ru.esvetlichny.furniturestore.repo.OrderRepository;
import ru.esvetlichny.furniturestore.repo.UserRepository;
import ru.esvetlichny.furniturestore.service.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final FurnitureRepository furnitureRepository;

    private final UserRepository userRepository;
    
    private void fetchRelations(Order order, CreateOrderDto orderDto, Long customerId) {
        Furniture furniture = furnitureRepository.findById(orderDto.getFurnitureId())
                .orElseThrow(() ->new RelationNotExistsException(Furniture.class, orderDto.getFurnitureId().toString()));
        User user = userRepository.findById(customerId)
                .orElseThrow(() ->new RelationNotExistsException(User.class, customerId.toString()));
        order.setFurniture(furniture);
        order.setCustomer(user);
    }

    @Override
    public Order create(CreateOrderDto orderDto, Long customerId) {
        Order order = new Order();
        order.setAddress(orderDto.getAddress());
        order.setQuantity(orderDto.getQuantity());
        fetchRelations(order, orderDto, customerId);
        return orderRepository.save(order);
    }

    @Override
    public Page<Order> findAll(Example<Order> example, Pageable pageable) {
        return orderRepository.findAll(example, pageable);
    }

    @Override
    public Order findOne(Long id) {
        return orderRepository.findById(id).orElseThrow(()->
                new EntityNotExistsException(Order.class, id.toString()));
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
