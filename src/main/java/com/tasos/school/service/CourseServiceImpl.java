package com.tasos.school.service;

import com.tasos.school.dao.CourseDAO;
import com.tasos.school.entity.Course;

public class CourseServiceImpl implements CourseService {

    private CourseDAO courseDAO;
    @Override
    public Course findByTitle(String title) {
        return null;
    }

    @Override
    public void save(Course course) {

        Course course1 = new Course();
        course1.setTitle(course.getTitle());

        courseDAO.save(course1);


    }
}
