package ru.esvetlichny.furniturestore.service;

import ru.esvetlichny.furniturestore.model.Placement;

import java.util.List;

public interface PlacementService {
    Placement create(Placement placement);

    List<Placement> findAll();

    Placement findOne(Long id);

    Placement update(Placement placement, Long id);

    void delete(Long id);
}
