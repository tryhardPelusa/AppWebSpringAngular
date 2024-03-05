package com.daniel.inventory.intentoryudemy.services;

import com.daniel.inventory.intentoryudemy.dao.CategoryDao;
import com.daniel.inventory.intentoryudemy.model.Category;
import com.daniel.inventory.intentoryudemy.response.CategoryResponse;
import com.daniel.inventory.intentoryudemy.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> search() {
        CategoryResponseRest response = new CategoryResponseRest();
        try {
            List<Category> category = (List<Category>) categoryDao.findAll();
            response.getCategoryResponse().setCategory(category);
            response.setMetadata("Todo Perfecto", "00", "Respuesta exitosa");
        } catch (Exception e) {
            response.setMetadata("Algo salió mal", "-1", "Error a consultar");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> searchByID(Long id) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();
        try {
            Optional<Category> category = categoryDao.findById(id);
            if (category.isPresent()) {
                list.add(category.get());
                response.getCategoryResponse().setCategory(list);
                response.setMetadata("Todo Perfecto", "00", "Respuesta exitosa");
            } else {
                response.setMetadata("Algo salió mal", "01", "Categooria no encontrada");
                return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            response.setMetadata("Algo salió mal", "-1", "Error a consultar");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<CategoryResponseRest> save(Category category) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();
        try {
            Category categorySaved = categoryDao.save(category);

            list.add(categorySaved);
            response.getCategoryResponse().setCategory(list);
            response.setMetadata("Todo Perfecto", "00", "Respuesta exitosa");

        } catch (Exception e) {
            response.setMetadata("Algo salió mal", "-1", "Error al guardar categoria");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }
}
