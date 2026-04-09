package com.jsp.project.SpringBootProject.Service;

import com.jsp.project.SpringBootProject.Dao.CategoryDao;
import com.jsp.project.SpringBootProject.Entity.Category;
import com.jsp.project.SpringBootProject.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    public ResponseEntity<ResponseStructure<Category>>saveCategory(Category category){
        Category category1=categoryDao.saveCategory(category);
        ResponseStructure<Category>rs=new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.OK.value());
        rs.setMessage("category saved successfully");
        rs.setData(category1);
        return new ResponseEntity<>(rs,HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<List<Category>>> FetchAllCategory(){
       List<Category>categories= categoryDao.fetchAllCategory();
        ResponseStructure<List<Category>>rs=new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.OK.value());
        rs.setMessage("category fetched successfully");
        rs.setData(categories);
        return new ResponseEntity<>(rs,HttpStatus.OK);
    }


}
