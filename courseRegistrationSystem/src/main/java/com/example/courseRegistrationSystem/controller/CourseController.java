package com.example.courseRegistrationSystem.controller;

import com.example.courseRegistrationSystem.model.Course;
import com.example.courseRegistrationSystem.model.CourseRegistry;
import com.example.courseRegistrationSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController

public class CourseController {


    @Autowired
    CourseService courseService_obj;

    @GetMapping("courses")
    public List<Course> availableCourses(){
    return courseService_obj.availableCourses();
    }

    @GetMapping("/courses/enrolled")
    public List<CourseRegistry> enrolledCourses(){
        return courseService_obj.enrolledCourses();
    }

    @PostMapping("/courses/register")
    public String enrollCourse(@RequestParam ("name") String name,
                               @RequestParam ("emailId") String emailId,
                               @RequestParam ("courseName") String courseName){
    courseService_obj.enrollCourse(name,emailId,courseName);
    return "Congratulations! "+name+"Enrollment Successful for "+courseName;
    }

}
