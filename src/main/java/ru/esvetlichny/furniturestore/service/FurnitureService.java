package ru.esvetlichny.furniturestore.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.esvetlichny.furniturestore.model.Furniture;
import ru.esvetlichny.furniturestore.model.dto.CreateFurnitureDto;

public interface FurnitureService {
    Furniture create(CreateFurnitureDto furnitureDto);

    Page<Furniture> findAll(Example<Furniture> of, Pageable pageable);

    Furniture findOne(Long id);

    Furniture update(CreateFurnitureDto furnitureDto, Long id);

    void delete(Long id);
}
