package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.models.Course;
import com.student.models.Student;
import com.student.models.University;
import com.student.serviceimpl.UniversityImpl;

/**
 * @author anup.jawale
 *
 */
@RestController
public class StudentController {
	
	@Autowired
	UniversityImpl universityImpl;
	
	
	 /**
	 * @return
	 * Return University data
	 */
	@GetMapping("/university")
	    public List<University> getUniversites(){
	        return universityImpl.getUniversityList();
	    }
	 
	 /**
	 * @return Avilable Courses
	 */
	@GetMapping("/courses")
	 public List<Course> getCourses(){
		return universityImpl.getCourses();
	 }
	 
	 /**
	 * @return Students
	 */
	@GetMapping("/students")
	 public List<Student> getStudents(){
		 return universityImpl.getStudents();
	 }
	 
	 /**
	 * @param std
	 *  Insert new the student
	 */
	@PostMapping("/students")
	 public ResponseEntity<Student> addStudent(@RequestBody Student std){
		 Student student =   universityImpl.addStudent(std);
		 if(student != null)
			 return new ResponseEntity<>(student, HttpStatus.OK);
		 else
			 return new ResponseEntity<>(student, HttpStatus.NOT_ACCEPTABLE);
		 
	 }
	 
	 /**
	 * @param course
	 *  Inserts New Courses
	 */
	@PostMapping("/courses")
	 public ResponseEntity<Course> addCourses(@RequestBody Course course){
		 Course cour =   universityImpl.addCourse(course);
		 if(course != null)
			 return new ResponseEntity<>(cour, HttpStatus.OK);
		 else
			 return new ResponseEntity<>(cour, HttpStatus.NOT_ACCEPTABLE);
		 
	 }
	 
	 /**
	 * @param std
	 * @return
	 * Delete the student from db
	 */
	@DeleteMapping("/students")
	 public ResponseEntity<Integer> deleteStudent(@RequestBody Student std){
		 universityImpl.deleteStudent(std);
		 return new ResponseEntity<>(std.getRno(), HttpStatus.OK);
		
	 }
	 
	 /**
	 * @param std
	 * @return
	 * Register the student for the course
	 */
	@PutMapping("/register")
	 public ResponseEntity<Student> registerStudent(@RequestBody Student std){
		 universityImpl.updateStudent(std.getCno(),std.getRno());
		 return new ResponseEntity<>(std, HttpStatus.OK);
	 }
		 
}
