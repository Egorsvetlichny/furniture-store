package ru.esvetlichny.furniturestore.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.esvetlichny.furniturestore.model.FurnitureType;
import ru.esvetlichny.furniturestore.service.FurnitureTypeService;

import java.util.List;

@RestController
@RequestMapping("types")
@RequiredArgsConstructor
public class FurnitureTypeController {
    private final FurnitureTypeService furnitureTypeService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public FurnitureType create(@RequestBody FurnitureType furnitureType) {
        return furnitureTypeService.create(furnitureType);
    }

    @GetMapping
    public List<FurnitureType> readAll() {
        return furnitureTypeService.findAll();
    }

    @GetMapping("{id}")
    public FurnitureType readById(@PathVariable Long id) {
        return furnitureTypeService.findOne(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public FurnitureType update(@RequestBody FurnitureType furnitureType, @PathVariable Long id) {
        return furnitureTypeService.update(furnitureType, id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        furnitureTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
