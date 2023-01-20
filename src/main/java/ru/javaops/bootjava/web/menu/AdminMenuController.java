package ru.javaops.bootjava.web.menu;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javaops.bootjava.model.Menu;
import ru.javaops.bootjava.repository.MenuRepository;

import java.net.URI;
import java.util.List;

import static ru.javaops.bootjava.util.validation.ValidationUtil.assureIdConsistent;
import static ru.javaops.bootjava.util.validation.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = AdminMenuController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class AdminMenuController {
    static final String REST_URL = "/admin/menus";
    private final MenuRepository repository;

    @GetMapping("/{id}")
    public Menu get(@PathVariable int id) {
        log.info("get menu with id {}", id);
        return repository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Menu> getAll() {
        log.info("menu getAll");
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete menu with id {}", id);
        repository.deleteExisted(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> createWithLocation(@Valid @RequestBody Menu menu) {
        log.info("create menu {}", menu);
        checkNew(menu);
        Menu created = repository.save(menu);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Menu menu, @PathVariable int id) {
        log.info("update menu {} with id={}", menu, id);
        assureIdConsistent(menu, id);
        repository.save(menu);
    }

    @GetMapping("/by-restaurant-id/{id}")
    public List<Menu> getByRestaurantId(@PathVariable int id) {
        log.info("get menu by restaurant-id = {}", id);
        return repository.findMenuByRestaurantId(id);
    }
}
