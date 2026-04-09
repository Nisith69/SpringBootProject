package com.jsp.project.SpringBootProject.Controller;

import com.jsp.project.SpringBootProject.Entity.Author;
import com.jsp.project.SpringBootProject.Service.AuthorService;
import com.jsp.project.SpringBootProject.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
private AuthorService authorService;
@PostMapping("/author")
public ResponseEntity<ResponseStructure<Author>> saveAuthor(@RequestBody Author author){
    return authorService.saveAuthor(author);
}
@GetMapping("/author")
public ResponseEntity<ResponseStructure<List<Author>>> fetchAll(){
    return authorService.fetchAllAuthor();
}
}
