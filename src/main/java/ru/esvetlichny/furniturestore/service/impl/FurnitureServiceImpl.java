package ru.esvetlichny.furniturestore.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.esvetlichny.furniturestore.exception.EntityNotExistsException;
import ru.esvetlichny.furniturestore.exception.RelationNotExistsException;
import ru.esvetlichny.furniturestore.model.Furniture;
import ru.esvetlichny.furniturestore.model.FurnitureType;
import ru.esvetlichny.furniturestore.model.Placement;
import ru.esvetlichny.furniturestore.model.dto.CreateFurnitureDto;
import ru.esvetlichny.furniturestore.repo.FurnitureRepository;
import ru.esvetlichny.furniturestore.repo.FurnitureTypeRepository;
import ru.esvetlichny.furniturestore.repo.PlacementRepository;
import ru.esvetlichny.furniturestore.service.FurnitureService;

@Service
@RequiredArgsConstructor
public class FurnitureServiceImpl implements FurnitureService {
    private final FurnitureRepository furnitureRepository;
    private final PlacementRepository placementRepository;
    private final FurnitureTypeRepository furnitureTypeRepository;

    private void fetchRelations(Furniture furniture, CreateFurnitureDto furnitureDto) {
        Placement placement = placementRepository.findById(furnitureDto.getPlacementId())
                .orElseThrow(() ->new RelationNotExistsException(Placement.class, furnitureDto.getPlacementId().toString()));
        FurnitureType type = furnitureTypeRepository.findById(furnitureDto.getTypeId())
                .orElseThrow(() ->new RelationNotExistsException(FurnitureType.class, furnitureDto.getTypeId().toString()));
        furniture.setPlacement(placement);
        furniture.setType(type);
    }

    @Override
    public Furniture create(CreateFurnitureDto furnitureDto) {
        Furniture furniture = new Furniture();
        furniture.setName(furnitureDto.getName());
        furniture.setPrice(furnitureDto.getPrice());
        fetchRelations(furniture, furnitureDto);
        return furnitureRepository.save(furniture);
    }

    @Override
    public Page<Furniture> findAll(Example<Furniture> example, Pageable pageable) {
        return furnitureRepository.findAll(example, pageable);
    }

    @Override
    public Furniture findOne(Long id) {
        return furnitureRepository.findById(id).orElseThrow(()->
                new EntityNotExistsException(Furniture.class, id.toString()));
    }

    @Override
    public Furniture update(CreateFurnitureDto furnitureDto, Long id) {
        Furniture furniture1 = findOne(id);
        furniture1.setName(furnitureDto.getName());
        furniture1.setPrice(furnitureDto.getPrice());
        fetchRelations(furniture1, furnitureDto);
        return furnitureRepository.save(furniture1);
    }

    @Override
    public void delete(Long id) {
        furnitureRepository.deleteById(id);
    }
}
