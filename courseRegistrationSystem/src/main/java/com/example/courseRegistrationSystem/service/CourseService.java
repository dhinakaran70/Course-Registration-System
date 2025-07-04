package com.example.courseRegistrationSystem.service;

import com.example.courseRegistrationSystem.model.Course;
import com.example.courseRegistrationSystem.model.CourseRegistry;
import com.example.courseRegistrationSystem.repository.CourseRegistryRepo;
import com.example.courseRegistrationSystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository_obj;

    @Autowired
    CourseRegistryRepo courseRegistryRepo_obj;


    public List<Course> availableCourses() {
        return courseRepository_obj.findAll();
    }

    public List<CourseRegistry> enrolledCourses() {
        return courseRegistryRepo_obj.findAll();
    }

    public void enrollCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry_obj= new CourseRegistry(name,emailId,courseName);
        courseRegistryRepo_obj.save(courseRegistry_obj);
    }
}
