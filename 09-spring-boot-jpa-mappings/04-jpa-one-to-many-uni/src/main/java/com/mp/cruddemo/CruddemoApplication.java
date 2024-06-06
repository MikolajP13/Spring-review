package com.mp.cruddemo;

import com.mp.cruddemo.dao.AppDAO;
import com.mp.cruddemo.entity.Course;
import com.mp.cruddemo.entity.Instructor;
import com.mp.cruddemo.entity.InstructorDetail;
import com.mp.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			//	createCourseAndReviews(appDAO);
			// retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		// delete course and associated reviews -> CascadeType.ALL
		appDAO.deleteCourseById(id);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(id);

		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Pacman Tutorial");
		course.addReview(new Review("Great course."));
		course.addReview(new Review("Cool, job well done."));
		course.addReview(new Review("What a dumb course!"));

		System.out.println(course);
		System.out.println(course.getReviews());

		appDAO.saveCourse(course);
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		appDAO.deleteCourseById(id);
	}

	private void deleteInstructor2(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteInstructorById2(id);
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseById(id);
		course.setTitle("Test title");

		appDAO.updateCourse(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		instructor.setLastName("Test");

		appDAO.updateInstructor(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println(instructor);

		List<Course> coursesByInstructorId = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(coursesByInstructorId);
		System.out.println(instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("John", "Doe", "john.doe@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/john.doe", "Video Games");
		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar - Guide");
		Course course2 = new Course("The Pinball Masterclass");
		Course course3 = new Course("Pac-Man - Guide");

		// add courses to the instructor
		instructor.add(course1);
		instructor.add(course2);
		instructor.add(course3);

		// save instructor - this will also save courses and instructor details -> CascadeType.PERSIST
		appDAO.saveInstructor(instructor);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void deleteInstructorDetails(AppDAO appDAO) {
		int id = 3;
		appDAO.deleteInstructionDetailById(id);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 1;
		InstructorDetail instructorDetail = appDAO.findInstructorDetail(id);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 2;
		appDAO.deleteInstructorById(id);
		System.out.println("Instructor with id=" + id + " has been deleted!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("John", "Doe", "john.doe@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/john.doe", "Spring");

		instructor.setInstructorDetail(instructorDetail);
		System.out.println("Saving instructor= " + instructor);

		// this will also save the instructor details object because of CascadeType.ALL
		appDAO.saveInstructor(instructor);
		System.out.println("Done!");
	}
}
