package com.daniel.inventory.intentoryudemy.response;

import com.daniel.inventory.intentoryudemy.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {
    private List<Category> category;


}
