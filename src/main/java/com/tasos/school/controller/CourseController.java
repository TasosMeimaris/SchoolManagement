package com.tasos.school.controller;

import com.tasos.school.dao.CourseDAO;
import com.tasos.school.dao.CourseRepository;
import com.tasos.school.dao.UserDAO;
import com.tasos.school.dao.UserRepository;
import com.tasos.school.entity.Course;
import com.tasos.school.entity.User;
import com.tasos.school.entity.WebUser;
import com.tasos.school.service.CourseService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class CourseController {
    private Logger logger = Logger.getLogger(getClass().getName());
    private  CourseRepository courseRepository;
    private  UserRepository userRepository;
    private CourseService courseService;
    private CourseDAO courseDAO;
    private UserDAO userDAO;


    public CourseController(UserDAO userDAO, CourseService courseService, CourseRepository courseRepository, UserRepository userRepository, CourseDAO courseDAO) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.courseDAO= courseDAO;
        this.courseService= courseService;
        this.userDAO = userDAO;

    }
    @PostMapping("/add-course")
    public String addCourseToUser(@RequestParam int userId, @RequestParam int courseId, Model model) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Course not found"));
        course.setUser(user);
        courseRepository.save(course);

        model.addAttribute("courses", user.getCourses());
        System.out.println(courseId);
        System.out.println(userId);
        return "redirect:/tutors/course-list";
    }

    @PostMapping("/courses/remove")
    public String removeCourseToUser(@RequestParam("courseId") int courseId) {
        Course course = courseService.findById(courseId);
        course.setUser(null);
        courseRepository.save(course);
        return "redirect:/tutors/course-list";
    }

    @GetMapping("/tutors/course-list")
    public String showCourseListForTutors(HttpServletRequest request, HttpSession session, Model theModel){
        session = request.getSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        System.out.println("================");
        System.out.println(userDetails);
        User user = userDAO.findByUserName(username);
        int id = user.getId();

        theModel.addAttribute("courses", courseRepository.findAll());
        theModel.addAttribute("userCourses", courseDAO.findCoursesByUserId(id));
        return "courseList";
    }


    @GetMapping("/courses/delete")
    public String deleteCourse(@RequestParam("courseId") int id) {
        System.out.println("================");
        System.out.println("Course Deleted: "+ id);
        System.out.println("================");
        courseRepository.deleteById(id);
        return "redirect:/tutors/course-list";
    }

    @GetMapping("/showCreateCourse")
    public String showCreateCourse(Model theModel) {
        theModel.addAttribute("course", new Course());
        return "create-course-form";
    }

    @PostMapping("/create-course")
    public String createNewCourse(@ModelAttribute("course") Course theCourse, Model theModel) {
        String title = theCourse.getTitle();
        Course existing = courseService.findByTitle(title);
        if (existing != null){
            theModel.addAttribute("course", new Course());
            theModel.addAttribute("registrationError", "Course already exists.");
            logger.warning("User name already exists.");
            return "create-course-form";
        }
        // create user account and store in the databse
        courseService.save(theCourse);
        logger.info("Successfully created course: " + title);
        return "redirect:/tutors/course-list";
    }




    }
