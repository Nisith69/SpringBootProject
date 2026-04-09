package com.jsp.project.SpringBootProject.Dao;




import com.jsp.project.SpringBootProject.Entity.Users;

import com.jsp.project.SpringBootProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    // SAVE USER
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    // FETCH ALL USERS
    public List<Users> fetchUsers() {
        return userRepository.findAll();
    }

    // FETCH SINGLE USER
    public Optional<Users> fetchUser(int id) {
        return userRepository.findById(id);
    }

    // UPDATE USER
    public Optional<Users> updateUser(int id, Users user) {
        Optional<Users> u = userRepository.findById(id);

        if (u.isPresent()) {
            Users use = u.get();
            // use.setBooks(null);   // keep only if needed
            use.setName(user.getName());
            use.setProfile(user.getProfile());

            userRepository.save(use);
        }

        return u;
    }

    // DELETE USER
    public void deleteUser(int id) {
        Optional<Users> u = userRepository.findById(id);

        if (u.isPresent()) {
            userRepository.delete(u.get());
        }
    }
}
