package com.jsp.project.SpringBootProject.Repository;

import com.jsp.project.SpringBootProject.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
