package ru.esvetlichny.furniturestore.service;

import ru.esvetlichny.furniturestore.model.FurnitureType;

import java.util.List;

public interface FurnitureTypeService {
    FurnitureType create(FurnitureType furnitureType);

    List<FurnitureType> findAll();

    FurnitureType findOne(Long id);

    FurnitureType update(FurnitureType furnitureType, Long id);

    void delete(Long id);
}
