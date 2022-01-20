package ru.esvetlichny.furniturestore.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.esvetlichny.furniturestore.exception.EntityNotExistsException;
import ru.esvetlichny.furniturestore.model.FurnitureType;
import ru.esvetlichny.furniturestore.repo.FurnitureTypeRepository;
import ru.esvetlichny.furniturestore.service.FurnitureTypeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FurnitureTypeServiceImpl implements FurnitureTypeService {
    private final FurnitureTypeRepository furnitureTypeRepository;
    
    @Override
    public FurnitureType create(FurnitureType furnitureType) {
        return furnitureTypeRepository.save(furnitureType);
    }

    @Override
    public List<FurnitureType> findAll() {
        return furnitureTypeRepository.findAll();
    }

    @Override
    public FurnitureType findOne(Long id) {
        return furnitureTypeRepository.findById(id).orElseThrow(() ->
                new EntityNotExistsException(FurnitureType.class, id.toString()));
    }

    @Override
    public FurnitureType update(FurnitureType furnitureType, Long id) {
        FurnitureType furnitureType1 = findOne(id);
        furnitureType1.setName(furnitureType.getName());
        return furnitureTypeRepository.save(furnitureType1);
    }

    @Override
    public void delete(Long id) {
        furnitureTypeRepository.deleteById(id);
    }
}
