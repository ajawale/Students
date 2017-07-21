package com.student.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.models.Course;
@Repository
public interface CourseDAO extends CrudRepository<Course, Integer> {

}
