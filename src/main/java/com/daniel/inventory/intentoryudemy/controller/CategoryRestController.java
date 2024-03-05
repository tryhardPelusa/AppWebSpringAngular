package com.daniel.inventory.intentoryudemy.controller;

import com.daniel.inventory.intentoryudemy.response.CategoryResponseRest;
import com.daniel.inventory.intentoryudemy.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories() {
        return service.search();
    }
}
