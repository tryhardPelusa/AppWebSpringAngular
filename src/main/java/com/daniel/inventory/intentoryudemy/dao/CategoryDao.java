package com.daniel.inventory.intentoryudemy.dao;

import com.daniel.inventory.intentoryudemy.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, Long> {

}
