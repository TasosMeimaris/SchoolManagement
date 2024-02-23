package com.tasos.school.dao;

import com.tasos.school.entity.Course;

import java.util.List;

public interface CourseDAO {


    void deleteCourseById(int theId);

    void save(Course course);

}
