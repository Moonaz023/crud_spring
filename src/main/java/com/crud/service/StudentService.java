package com.crud.service;

import java.util.List;

import com.crud.entity.Student;
import com.crud.entity.StudentCreatRequest;

public interface StudentService {
	
	Student save_student(StudentCreatRequest request);
	List<Student> findStudent(String query);
	String deleteStudent(Long id);
	Student editStudent(StudentCreatRequest request, Long id);
}
