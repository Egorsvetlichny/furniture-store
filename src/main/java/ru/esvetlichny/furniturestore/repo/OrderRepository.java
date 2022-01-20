package ru.esvetlichny.furniturestore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.esvetlichny.furniturestore.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}