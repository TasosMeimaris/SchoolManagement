package com.tasos.school.controller;

import com.tasos.school.dao.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("tutors/course-list")
    public String showCourseListForTutors(Model theModel){

        theModel.addAttribute("courses", courseRepository.findAll());
        return "courseList";
    }

    @PostMapping("/courses/delete")
    public String deleteCourse(@RequestParam Long id) {
        courseRepository.deleteById(id);
        return "redirect:/tutors/course-list";
    }

}
