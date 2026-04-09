package com.jsp.project.SpringBootProject.Repository;

import com.jsp.project.SpringBootProject.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
