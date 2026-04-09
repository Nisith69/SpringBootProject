package com.jsp.project.SpringBootProject.Dao;

import com.jsp.project.SpringBootProject.Entity.Author;
import com.jsp.project.SpringBootProject.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDao {
    @Autowired
    private AuthorRepository authorRepository;
    public Author saveAuthor(Author author){
       return authorRepository.save(author);
    }
    public List<Author> fetchAuhtor(){
        return authorRepository.findAll();
    }

}
