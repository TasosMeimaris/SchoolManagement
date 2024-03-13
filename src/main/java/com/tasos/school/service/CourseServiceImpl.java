package com.tasos.school.service;

import com.tasos.school.dao.CourseDAO;
import com.tasos.school.dao.CourseRepository;
import com.tasos.school.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findByTitle(String title) {
        return null;
    }

    @Override
    public void save(Course course) {

        Course course1 = new Course();
        course1.setTitle(course.getTitle());

        courseRepository.save(course1);


    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course findById(int id) {
        Optional<Course> result = courseRepository.findById(id);

        Course theCourse = null;

        if (result.isPresent()) {
            theCourse = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);

        }

        return theCourse;
    }

    @Override
    public List<Course> findAll() {

            return courseRepository.findAll();

    }
}
