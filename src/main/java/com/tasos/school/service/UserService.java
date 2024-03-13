package com.tasos.school.service;

import com.tasos.school.entity.User;
import com.tasos.school.entity.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

    void save(WebUser webUser);

    void addCourse(User user);

    List<User> findAll();

    void deleteById(int id);

}
