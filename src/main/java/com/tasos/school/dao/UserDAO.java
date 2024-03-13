package com.tasos.school.dao;


import com.tasos.school.entity.User;

public interface UserDAO {

    User findByUserName(String userName);

    void save(User theUser);

    int findIdByUsername(String username);
}