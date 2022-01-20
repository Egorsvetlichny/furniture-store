package ru.esvetlichny.furniturestore.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.esvetlichny.furniturestore.model.User;

public interface UserService {
    User create(User user);

    Page<User> findAll(Example<User> of, Pageable pageable);

    User findOne(Long id);

    User update(User user, Long id);

    void delete(Long id);
}
