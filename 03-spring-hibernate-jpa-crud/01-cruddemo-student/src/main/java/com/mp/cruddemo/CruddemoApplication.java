package com.mp.cruddemo;

import com.mp.cruddemo.dao.StudentDAO;
import com.mp.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int numberOfDeletedStudents = studentDAO.deleteAll();
		System.out.println("Deleted " + numberOfDeletedStudents + " student/s");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Deleting student...");
		studentDAO.delete(2L);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(2L);
		student.setFirstName("Scooby");
		studentDAO.update(student);
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("Doe");

		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();

		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(3L);
		System.out.println(student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1 = new Student("John", "Doe", "john.doe@abc.com");
		Student student2 = new Student("Mary", "Public", "mary.public@abc.com");
		Student student3 = new Student("Paul", "Dee", "paul.dee@abc.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("John", "Doe", "john.doe@abc.com");
		studentDAO.save(student);

		//display id of the saved student
		System.out.println("Saved student generated id " + student.getId());
	}
}
