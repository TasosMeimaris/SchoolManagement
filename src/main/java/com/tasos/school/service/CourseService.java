package com.tasos.school.service;

import com.tasos.school.entity.Course;
import com.tasos.school.entity.User;
import com.tasos.school.entity.WebUser;

public interface CourseService {
    public Course findByTitle(String title);

    void save(Course course);
}
