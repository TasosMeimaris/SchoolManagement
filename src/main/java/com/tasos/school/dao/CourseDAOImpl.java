package com.tasos.school.dao;

import com.tasos.school.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO{
    public EntityManager entityManager;

    @Autowired
    public CourseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course tempCourse = entityManager.find(Course.class, theId);

        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.merge(course);
    }


    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public void findById(int id) {
        entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> findCoursesByUserId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where user.id = :data", Course.class);
        query.setParameter("data", theId);

        List<Course> courses = query.getResultList();
        return courses;

    }
}
