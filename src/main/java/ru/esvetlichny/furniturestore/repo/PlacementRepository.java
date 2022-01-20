package ru.esvetlichny.furniturestore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.esvetlichny.furniturestore.model.Placement;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, Long> {
}