package com.jsp.project.SpringBootProject.Controller;

import com.jsp.project.SpringBootProject.Entity.Category;
import com.jsp.project.SpringBootProject.Service.CategoryService;
import com.jsp.project.SpringBootProject.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/category")
    public ResponseEntity<ResponseStructure<Category>>saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }
    @GetMapping("/category")
    public ResponseEntity<ResponseStructure<List<Category>>>fetchAllCategory(){
        return categoryService.FetchAllCategory();
    }
}
