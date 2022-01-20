package ru.esvetlichny.furniturestore.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.esvetlichny.furniturestore.model.dto.CreateOrderAdmDto;
import ru.esvetlichny.furniturestore.model.Order;
import ru.esvetlichny.furniturestore.model.dto.CreateOrderDto;
import ru.esvetlichny.furniturestore.service.OrderService;
import ru.esvetlichny.furniturestore.util.SimpleExample;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    private final SimpleExample example;

    @PostMapping
    public Order create(@RequestBody CreateOrderAdmDto orderDto) {
        return orderService.create(orderDto, orderDto.getCustomerid());
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("me")
    public Order createByMyself(@RequestBody CreateOrderAdmDto orderDto, @AuthenticationPrincipal Long customerId) {
        return orderService.create(orderDto, customerId);
    }

    @GetMapping
    public Page<Order> readAll(Order order, Pageable pageable) {
        return orderService.findAll(Example.of(order, example.getMatcher()), pageable);
    }

    @GetMapping("{id}")
    public Order readById(@PathVariable Long id) {
        return orderService.findOne(id);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

