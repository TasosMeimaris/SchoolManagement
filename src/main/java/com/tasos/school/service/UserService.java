package com.tasos.school.service;

import com.tasos.school.entity.User;
import com.tasos.school.entity.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

    void save(WebUser webUser);

}
