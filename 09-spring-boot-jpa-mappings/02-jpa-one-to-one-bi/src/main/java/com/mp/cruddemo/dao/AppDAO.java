package com.mp.cruddemo.dao;

import com.mp.cruddemo.entity.Instructor;
import com.mp.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void saveInstructor(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetail(int id);
    void deleteInstructionDetailById(int id);
}
