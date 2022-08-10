package br.com.neres.redissample;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    @CacheEvict(cacheNames = "User", allEntries = true)
    public User create(@RequestBody final User user) {
        return userRepository.save(user);
    }

    @PutMapping
    @CachePut(cacheNames = "User", key="#user.getId()")
    public User update(@RequestBody final User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(cacheNames = "User", key="#id")
    public void delete(@PathVariable("id") final Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping
    @Cacheable(cacheNames = "User", key = "#id")
    public User findById(@PathVariable("id") final Long id) {
        return userRepository.findById(id).orElseGet(User::new);
    }
}
