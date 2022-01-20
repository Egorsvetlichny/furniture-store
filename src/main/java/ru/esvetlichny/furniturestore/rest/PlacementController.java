package ru.esvetlichny.furniturestore.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.esvetlichny.furniturestore.model.Placement;
import ru.esvetlichny.furniturestore.service.PlacementService;

import java.util.List;

@RestController
@RequestMapping("placements")
@RequiredArgsConstructor
public class PlacementController {
    private final PlacementService placementService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Placement create(@RequestBody Placement placement) {
        return placementService.create(placement);
    }

    @GetMapping
    public List<Placement> readAll() {
        return placementService.findAll();
    }

    @GetMapping("{id}")
    public Placement readById(@PathVariable Long id) {
        return placementService.findOne(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public Placement update(@RequestBody Placement placement, @PathVariable Long id) {
        return placementService.update(placement, id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        placementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
