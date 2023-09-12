package com.lcwd.user.service.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.user.service.UserService.Entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, String>{

}