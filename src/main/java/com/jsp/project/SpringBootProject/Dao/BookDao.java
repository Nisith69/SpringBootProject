package com.jsp.project.SpringBootProject.Dao;

import com.jsp.project.SpringBootProject.Entity.Author;
import com.jsp.project.SpringBootProject.Entity.Book;
import com.jsp.project.SpringBootProject.Entity.Category;
import com.jsp.project.SpringBootProject.Entity.Users;
import com.jsp.project.SpringBootProject.Repository.AuthorRepository;
import com.jsp.project.SpringBootProject.Repository.BookRepository;
import com.jsp.project.SpringBootProject.Repository.CategoryRepository;
import com.jsp.project.SpringBootProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDao {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Book saveBook(Book book){
        int authorId=book.getAuthorId();
        Optional<Author> optionalAuthor=authorRepository.findById(authorId);
        List<Category> categories=categoryRepository.findAllById(book.getCategoryId());
        if(optionalAuthor.isEmpty()){
            return null;
        }
//        if(categories.isEmpty()){
//            return null;
//        }
        Author author= optionalAuthor.get();

        book.setAuthor(author);
        book.setCategories(categories);
        book.setAvailability(true);

        return bookRepository.save(book);
    }
    public Users borrowBook(int bookId,int userId){
        Optional<Users> optionalUsers=userRepository.findById(userId);
        Optional<Book> optionalBook=bookRepository.findById(bookId);
        if(optionalUsers.isEmpty() || optionalBook.isEmpty())
            return null;
        if(!optionalBook.get().isAvailability()){
            return null;
        }
        Users user=optionalUsers.get();
        Book book =optionalBook.get();
        book.setAvailability(false);
        user.getBooks().add(book);
        return userRepository.save(user);
    }
    public Users returnBook(int bookId,int userId){
        Optional<Users> optionalUsers=userRepository.findById(userId);
        Optional<Book> optionalBook=bookRepository.findById(bookId);
        if(optionalUsers.isEmpty() || optionalBook.isEmpty()){
            return null;
        }
        Users users=optionalUsers.get();
        Book book=optionalBook.get();
        book.setAvailability(true);
        users.getBooks().remove(book);
        return userRepository.save(users);
    }

}
