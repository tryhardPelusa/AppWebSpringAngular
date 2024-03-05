package com.daniel.inventory.intentoryudemy.services;

import com.daniel.inventory.intentoryudemy.model.Category;
import com.daniel.inventory.intentoryudemy.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    public ResponseEntity<CategoryResponseRest> search();
    public ResponseEntity<CategoryResponseRest> searchByID(Long id);
    public ResponseEntity<CategoryResponseRest> save(Category category);
    public ResponseEntity<CategoryResponseRest> update(Category category, long id);

}
