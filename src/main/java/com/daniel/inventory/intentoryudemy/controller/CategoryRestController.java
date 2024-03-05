package com.daniel.inventory.intentoryudemy.controller;

import com.daniel.inventory.intentoryudemy.model.Category;
import com.daniel.inventory.intentoryudemy.response.CategoryResponseRest;
import com.daniel.inventory.intentoryudemy.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private CategoryService service;

    /**
     * Get all Categories
     * @return
     */
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories() {
        return service.search();
    }

    /**
     * Get category by ID
     * @param id
     * @return
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoryByID(@PathVariable long id) {
        return service.searchByID(id);
    }

    /**
     *
     * @param category
     * @return
     */
    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category) {
        return service.save(category);
    }

    /**
     *
     * @param id
     * @param category
     * @return
     */
    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> updateCategoryByID(@PathVariable long id, @RequestBody Category category) {
        return service.update(category, id);
    }
}
