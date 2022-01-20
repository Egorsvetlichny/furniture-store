package ru.esvetlichny.furniturestore.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esvetlichny.furniturestore.exception.EntityNotExistsException;
import ru.esvetlichny.furniturestore.model.Placement;
import ru.esvetlichny.furniturestore.repo.PlacementRepository;
import ru.esvetlichny.furniturestore.service.PlacementService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlacementServiceImpl implements PlacementService {
    private final PlacementRepository placementRepository;

    @Override
    public Placement create(Placement placement) {
        return placementRepository.save(placement);
    }

    @Override
    public List<Placement> findAll() {
        return placementRepository.findAll();
    }

    @Override
    public Placement findOne(Long id) {
        return placementRepository.findById(id).orElseThrow(()->
                new EntityNotExistsException(Placement.class, id.toString()));
    }

    @Override
    public Placement update(Placement placement, Long id) {
        Placement placement1 = findOne(id);
        placement1.setName(placement.getName());
        return placementRepository.save(placement1);
    }

    @Override
    public void delete(Long id) {
        placementRepository.deleteById(id);
    }
}
