package com.jsp.project.SpringBootProject.Service;

import com.jsp.project.SpringBootProject.Dao.BookDao;
import com.jsp.project.SpringBootProject.Entity.Book;
import com.jsp.project.SpringBootProject.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public ResponseEntity<ResponseStructure<Book>>saveBook(Book book){
        Book receivedBook=bookDao.saveBook(book);
        ResponseStructure<Book> responseStructure=new ResponseStructure<>();
        responseStructure.setStatuscode(HttpStatus.OK.value());
        responseStructure.setMessage("success");
        responseStructure.setData(receivedBook);
        return new ResponseEntity<>(responseStructure,HttpStatus.OK);
    }
}
