package com.student.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.student.models.Student;

@Repository
public interface StudentDAO extends CrudRepository<Student, Integer> {
	
	// Native Query Language
	@Modifying
	@Transactional
	@Query(value = "update STUDENT set CNO=?1 where RNO=?2", nativeQuery = true)
	public void updateStudent(@Param("CNO") Integer cno, @Param("RNO") Integer rno);

}
