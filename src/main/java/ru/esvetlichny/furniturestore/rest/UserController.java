package ru.esvetlichny.furniturestore.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.esvetlichny.furniturestore.model.User;
import ru.esvetlichny.furniturestore.service.UserService;
import ru.esvetlichny.furniturestore.util.SimpleExample;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final SimpleExample example;

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping
    public Page<User> readAll(User user, Pageable pageable) {
        return userService.findAll(Example.of(user, example.getMatcher()), pageable);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("me")
    public User readByMyId(@AuthenticationPrincipal Long id) {
        return userService.findOne(id);
    }

    @GetMapping("{id}")
    public User readById(@PathVariable Long id) {
        return userService.findOne(id);
    }

    @PutMapping("{id}")
    public User update(@RequestBody User user, @PathVariable Long id) {
        return userService.update(user, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
