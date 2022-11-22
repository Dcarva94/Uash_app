package com.uash.uash.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.uash.uash.model.User;
 
public interface UserRepository extends JpaRepository<User, Integer> {
 
}