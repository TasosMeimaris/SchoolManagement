package com.tasos.school.service;

import com.tasos.school.entity.Course;
import com.tasos.school.entity.User;
import com.tasos.school.entity.WebUser;

import java.util.List;

public interface CourseService {
    public Course findByTitle(String title);

    void save(Course course);

    void deleteById(int id);

     public Course findById(int id);

     List<Course> findAll();


}
