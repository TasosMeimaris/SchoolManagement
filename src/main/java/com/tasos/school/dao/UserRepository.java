package com.tasos.school.dao;

import com.tasos.school.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findAllByOrderByLastNameAsc();

}
