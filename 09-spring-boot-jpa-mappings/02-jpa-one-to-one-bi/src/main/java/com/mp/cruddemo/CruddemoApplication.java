package com.mp.cruddemo;

import com.mp.cruddemo.dao.AppDAO;
import com.mp.cruddemo.entity.Instructor;
import com.mp.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);
			 deleteInstructorDetails(appDAO);
		};
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
