package com.jsp.project.SpringBootProject.Service;

import com.jsp.project.SpringBootProject.Dao.AuthorDao;
import com.jsp.project.SpringBootProject.Entity.Author;
import com.jsp.project.SpringBootProject.Entity.Users;
import com.jsp.project.SpringBootProject.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorDao authorDao;
    public ResponseEntity<ResponseStructure<Author>> saveAuthor(Author author){
          Author a=authorDao.saveAuthor(author);
          ResponseStructure<Author>rs=new ResponseStructure<>();
          rs.setStatuscode(HttpStatus.OK.value());
          rs.setMessage("Author saved successfully");
          rs.setData(a);
          return new  ResponseEntity<>(rs,HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<List<Author>>>fetchAllAuthor(){
        List<Author>authors=authorDao.fetchAuhtor();
        ResponseStructure<List<Author>>rs=new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.OK.value());
        rs.setMessage("Author fetched successfully");
        rs.setData(authors);
        return new  ResponseEntity<>(rs,HttpStatus.OK);
    }

}
