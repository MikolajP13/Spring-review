package com.mp.cruddemo.dao;

import com.mp.cruddemo.entity.Course;
import com.mp.cruddemo.entity.Instructor;
import com.mp.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void saveInstructor(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetail(int id);
    void deleteInstructionDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void updateInstructor(Instructor instructor);
    void deleteInstructorById2(int id);
    Course findCourseById(int id);
    void updateCourse(Course course);
    void deleteCourseById(int id);
    void saveCourse(Course course);
    Course findCourseAndReviewsByCourseId(int id);
}
