package ru.esvetlichny.furniturestore.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.esvetlichny.furniturestore.model.Furniture;
import ru.esvetlichny.furniturestore.model.dto.CreateFurnitureDto;
import ru.esvetlichny.furniturestore.service.FurnitureService;
import ru.esvetlichny.furniturestore.util.SimpleExample;

@RestController
@RequestMapping("furniture")
@RequiredArgsConstructor
public class FurnitureController {
    private final FurnitureService furnitureService;

    private final SimpleExample example;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Furniture create(@RequestBody CreateFurnitureDto furnitureDto) {
        return furnitureService.create(furnitureDto);
    }

    @GetMapping
    public Page<Furniture> readAll(Furniture furniture, Pageable pageable) {
        return furnitureService.findAll(Example.of(furniture, example.getMatcher()), pageable);
    }

    @GetMapping("{id}")
    public Furniture readById(@PathVariable Long id) {
        return furnitureService.findOne(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public Furniture update(@RequestBody CreateFurnitureDto furnitureDto, @PathVariable Long id) {
        return furnitureService.update(furnitureDto, id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        furnitureService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
