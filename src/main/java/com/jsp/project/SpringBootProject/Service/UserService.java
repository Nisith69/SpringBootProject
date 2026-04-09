package com.jsp.project.SpringBootProject.Service;



import com.jsp.project.SpringBootProject.Dao.UserDao;
import com.jsp.project.SpringBootProject.Entity.Users;
import com.jsp.project.SpringBootProject.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    // SAVE USER
    public ResponseEntity<ResponseStructure<Users>> saveUser(Users user) {
        Users u = userDao.saveUser(user);

        ResponseStructure<Users> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.OK.value());
        rs.setMessage("Data Inserted Successfully");
        rs.setData(u);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // FETCH ALL USERS
    public ResponseEntity<ResponseStructure<List<Users>>> fetchUsers() {
        List<Users> users = userDao.fetchUsers();

        ResponseStructure<List<Users>> rs = new ResponseStructure<>();
        rs.setStatuscode(HttpStatus.OK.value());
        rs.setMessage("All Users Fetched Successfully");
        rs.setData(users);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // FETCH SINGLE USER
    public ResponseEntity<ResponseStructure<Users>> fetchUser(int id) {
        Optional<Users> u = userDao.fetchUser(id);

        ResponseStructure<Users> rs = new ResponseStructure<>();

        if (u.isPresent()) {
            rs.setStatuscode(HttpStatus.OK.value());
            rs.setMessage("User Found Successfully");
            rs.setData(u.get());

            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            rs.setStatuscode(HttpStatus.NOT_FOUND.value());
            rs.setMessage("User Not Found");
            rs.setData(null);

            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE USER
    public ResponseEntity<ResponseStructure<Users>> updateUser(int id, Users user) {
        Optional<Users> u = userDao.updateUser(id, user);

        ResponseStructure<Users> rs = new ResponseStructure<>();

        if (u.isPresent()) {
            rs.setStatuscode(HttpStatus.OK.value());
            rs.setMessage("User Updated Successfully");
            rs.setData(u.get());

            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            rs.setStatuscode(HttpStatus.NOT_FOUND.value());
            rs.setMessage("User Not Found");
            rs.setData(null);

            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
        }
    }

    // DELETE USER
    public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
        Optional<Users> u = userDao.fetchUser(id);

        ResponseStructure<String> rs = new ResponseStructure<>();

        if (u.isPresent()) {
            userDao.deleteUser(id);

            rs.setStatuscode(HttpStatus.OK.value());
            rs.setMessage("User Deleted Successfully");
            rs.setData("Deleted User with ID: " + id);

            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            rs.setStatuscode(HttpStatus.NOT_FOUND.value());
            rs.setMessage("User Not Found");
            rs.setData(null);

            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
        }
    }
}
