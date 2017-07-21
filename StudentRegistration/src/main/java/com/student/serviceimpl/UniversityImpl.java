package com.student.serviceimpl;


import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.student.dao.CourseDAO;
import com.student.dao.StudentDAO;
import com.student.models.Course;
import com.student.models.Student;
import com.student.models.University;
import com.student.service.Univ;

@Service
public class UniversityImpl implements Univ {
	
	@Autowired
	CourseDAO courseDao;
	
	@Autowired
	StudentDAO studentDao;

	public List<University> getUniversityList() {

		RestTemplate restTemplate = new RestTemplate();

		String str = restTemplate.getForObject("http://universities.hipolabs.com/search?name=middle", String.class);
		Gson gsonReceiver = new Gson();
		Type type = new TypeToken<List<University>>() {
		}.getType();
		List<University> obj = gsonReceiver.fromJson(str, type);

		Iterator<University> itr = obj.iterator();
		while (itr.hasNext()) {
			University university = (University) itr.next();
			System.out.println(university.getAlpha_two_code());
		}
		return obj;

	}
	
	public List<Course> getCourses(){
		List<Course> list =  (List<Course>) courseDao.findAll();
		return list;
	}
	
	public List<Student> getStudents(){
		return (List<Student>) studentDao.findAll();
	}

	public Student addStudent(Student std) {
		return studentDao.save(std);
		
	}

	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		 return courseDao.save(course);
	}

	public void deleteStudent(Student std) {
		 studentDao.delete(std.getRno());;
	}
	 
	public void updateStudent(Integer cno, Integer rno) {
		studentDao.updateStudent(cno, rno);
		
	}

}
