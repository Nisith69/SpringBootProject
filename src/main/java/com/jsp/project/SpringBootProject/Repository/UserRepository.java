package com.jsp.project.SpringBootProject.Repository;

import com.jsp.project.SpringBootProject.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

}
