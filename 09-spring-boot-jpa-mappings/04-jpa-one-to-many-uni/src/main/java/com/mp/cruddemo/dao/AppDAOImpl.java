package com.mp.cruddemo.dao;

import com.mp.cruddemo.entity.Course;
import com.mp.cruddemo.entity.Instructor;
import com.mp.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        this.entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return this.entityManager.find(Instructor.class, id);
    }

    @Override
    public InstructorDetail findInstructorDetail(int id) {
        return this.entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructionDetailById(int id) {
        InstructorDetail instructorDetail = this.entityManager.find(InstructorDetail.class, id);

        // remove the associated object reference
        instructorDetail.getInstructor().setInstructorDetail(null);

        this.entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = this.entityManager.createQuery("from Course where instructor.id=:id", Course.class);
        query.setParameter("id", id);
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = this.entityManager.createQuery("select i from Instructor i join fetch i.courses join fetch i.instructorDetail where i.id = :id", Instructor.class);
        query.setParameter("id", id);
        Instructor instructor  = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        this.entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void deleteInstructorById2(int id) {
        Instructor instructor = this.entityManager.find(Instructor.class, id);
        List<Course> courses = instructor.getCourses();

        for (Course c : courses) {
            c.setInstructor(null);
        }

        this.entityManager.remove(instructor);
    }

    @Override
    public Course findCourseById(int id) {
        return this.entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        this.entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = this.entityManager.find(Course.class, id);
        this.entityManager.remove(course);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        this.entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> query = this.entityManager.createQuery("select c from Course c join fetch c.reviews where c.id = :id", Course.class);
        query.setParameter("id", id);

        Course course = query.getSingleResult();
        return course;
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = this.entityManager.find(Instructor.class, id);
        this.entityManager.remove(instructor);
    }
}
