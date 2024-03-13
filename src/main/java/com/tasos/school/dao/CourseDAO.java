package com.tasos.school.dao;

import com.tasos.school.entity.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CourseDAO {


    void deleteCourseById(int theId);

    void save(Course course);

    void update(Course course);
     void findById(int id);

     List<Course> findCoursesByUserId(int theId);


}
