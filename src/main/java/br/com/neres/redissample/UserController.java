package br.com.neres.redissample;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    @CacheEvict(cacheNames = "Avatar", allEntries = true)
    public Avatar create(@RequestBody final Avatar avatar) {
        return userRepository.save(avatar);
    }

    @PutMapping
    @CachePut(cacheNames = "Avatar", key="#avatar.getId()")
    public Avatar update(@RequestBody final Avatar avatar) {
        return userRepository.save(avatar);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(cacheNames = "Avatar", key="#id")
    public void delete(@PathVariable("id") final Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    @Cacheable(cacheNames = "Avatar", key = "#id")
    public Avatar findById(@PathVariable("id") final Long id) {
        return userRepository.findById(id).orElseGet(Avatar::new);
    }
}
