package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.entity.StudentCreatRequest;
import com.crud.repository.StudentRepository;
import com.crud.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository s_repo;
	@Autowired
	private StudentService s_serv;
	
/*	
	@PostMapping("/savestudent")
	public ResponseEntity<Student> saveStudent(@RequestBody StudentCreatRequest request)
	{
		Student student=new Student();
		student.setName(request.getName());
		student.setRoll(request.getRoll());
		s_repo.save(student);
		return ResponseEntity.ok(student);
	}*/
	
	@PostMapping("/savestudent")
	public ResponseEntity<Student> saveStudent(@RequestBody StudentCreatRequest request)
	{
		
		return ResponseEntity.ok(s_serv.save_student(request));
	}
	
	@GetMapping("/studentlist")
	public ResponseEntity<List<Student>> allstudent()
	{
		return  ResponseEntity.ok(s_repo.findAll());
		//return new ResponseEntity<>(s_repo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Student>> findstudent(@RequestParam String query)
	{
		return  ResponseEntity.ok(s_serv.findStudent(query));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam Long id){
		return  ResponseEntity.ok(s_serv.deleteStudent(id));
		
	}
	
	@PutMapping("/student/edit/{id}")
	public ResponseEntity<Student> editStudent(@RequestBody StudentCreatRequest request, @PathVariable Long id)
	{
		return ResponseEntity.ok(s_serv.editStudent(request,id));
	}
}
