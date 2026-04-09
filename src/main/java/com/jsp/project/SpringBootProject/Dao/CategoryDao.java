package com.jsp.project.SpringBootProject.Dao;

import com.jsp.project.SpringBootProject.Entity.Category;
import com.jsp.project.SpringBootProject.Repository.CategoryRepository;
import com.jsp.project.SpringBootProject.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category saveCategory(Category category){
       return categoryRepository.save(category);
    }
    public List<Category> fetchAllCategory(){
        return categoryRepository.findAll();
    }

}
