package ru.esvetlichny.furniturestore.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.esvetlichny.furniturestore.exception.EntityNotExistsException;
import ru.esvetlichny.furniturestore.exception.RelationNotExistsException;
import ru.esvetlichny.furniturestore.model.Role;
import ru.esvetlichny.furniturestore.model.User;
import ru.esvetlichny.furniturestore.repo.RoleRepository;
import ru.esvetlichny.furniturestore.repo.UserRepository;
import ru.esvetlichny.furniturestore.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public User create(User user) {
        Role role = roleRepository.findByName("ROLE_CUSTOMER")
                .orElseThrow(() -> new RelationNotExistsException(Role.class, "CUSTOMER"));
        user.getRoles().add(role);
        return userRepository.save(user);
    }

    @Override
    public Page<User> findAll(Example<User> example, Pageable pageable) {
        return userRepository.findAll(example, pageable);
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findById(id).orElseThrow(()->
                new EntityNotExistsException(User.class, id.toString()));
    }

    @Override
    public User update(User user, Long id) {
        User user1 = findOne(id);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setUsername(user.getUsername());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setPassword(user.getPassword());
        return userRepository.save(user1);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
