package ru.esvetlichny.furniturestore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.esvetlichny.furniturestore.model.FurnitureType;

@Repository
public interface FurnitureTypeRepository extends JpaRepository<FurnitureType, Long> {
}