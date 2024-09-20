package com.crud.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.crud.entity.Student;
import com.crud.entity.StudentCreatRequest;
import com.crud.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentRepository ss_repo;
	
	@Override
	public Student save_student(StudentCreatRequest request) {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setName(request.getName());
		student.setRoll(request.getRoll());
		
		
		return ss_repo.save(student);
	}
	@Override
	public List<Student> findStudent(String query) {
		// TODO Auto-generated method stub
		return ss_repo.findByName(query);
	}
	@Override
	public String deleteStudent(Long id) {
		// TODO Auto-generated method stub
		ss_repo.deleteById(id);
		return "deleted";
	}
	@Override
	public Student editStudent(StudentCreatRequest request, Long id) {
		// TODO Auto-generated method stub
		Student existing_student=ss_repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
		existing_student.setName(request.getName());
		existing_student.setRoll(request.getRoll());
		return ss_repo.save(existing_student);
	}
}
