package com.tasos.school;

import com.tasos.school.dao.CourseDAO;
import com.tasos.school.dao.CourseRepository;
import com.tasos.school.entity.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CourseDAO courseDAO ){
		return runner -> {
		};
	}

	private void findCourse(CourseDAO courseDAO) {
		int id = 5;
		System.out.println("Find Course: "+ id);

		courseDAO.deleteCourseById(id);
	}

	private void deleteCourse(CourseRepository courseRepository) {

		int id = 4;
		System.out.println("Deleting Course: "+ id);
		courseRepository.deleteById(4);
	}

}
