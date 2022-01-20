package ru.esvetlichny.furniturestore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.esvetlichny.furniturestore.model.Furniture;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
}