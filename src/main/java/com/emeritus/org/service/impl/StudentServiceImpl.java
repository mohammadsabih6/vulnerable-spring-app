package com.emeritus.org.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.emeritus.org.entity.Student;
import com.emeritus.org.repository.StudentRepository;
import com.emeritus.org.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;

	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	//SQL Injection
	@Override
	public Student getStudentById(Long id)  {
		
		// String queryStr = "SELECT "+id +", email, first_name as firstName, last_name as lastName FROM students WHERE id = " + id;
		// Query query = entityManager.createNativeQuery(queryStr);
		// List results = query.getResultList();
		// if(results.isEmpty()){
		// 	System.out.println(results);
		// }
		// Object result = results.get(0);

		// Student student = new Student();
		// student.setId((Long) ((Object[]) result)[0]);
		// student.setEmail(((Object[]) result)[1].toString());
		// student.setFirstName(((Object[]) result)[2].toString());
		// student.setLastName(((Object[]) result)[3].toString());
		return studentRepository.findById(id).orElse(null);

	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}

}
