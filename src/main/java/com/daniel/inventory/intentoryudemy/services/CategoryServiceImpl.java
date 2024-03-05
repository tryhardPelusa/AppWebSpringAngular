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

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

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
        }catch (Exception e){
            response.setMetadata("Algo salió mal", "-1", "Error a consultar");

            return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }
}
