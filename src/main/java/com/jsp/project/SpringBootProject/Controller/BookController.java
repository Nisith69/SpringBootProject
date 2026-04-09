package com.jsp.project.SpringBootProject.Controller;

import com.jsp.project.SpringBootProject.Entity.Book;
import com.jsp.project.SpringBootProject.Service.BookService;
import com.jsp.project.SpringBootProject.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/books")
    public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book1){
        return  bookService.saveBook(book1);
    }


}
