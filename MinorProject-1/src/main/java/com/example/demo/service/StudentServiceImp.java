package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;


	@Service
	public class StudentServiceImp implements StudentService {
		
			StudentRepository srepo;
			
			

		


			public StudentServiceImp(StudentRepository srepo) {
				super();
				this.srepo = srepo;
			}

			@Override
			public String addStudent(Student s) {
				srepo.save(s);
				return "Student added!";
				}
			
			// update method
			@Override
			public String updateStudent(Student s) {
				srepo.save(s);
				return "Student updated!";
				
			}
			
			// get method
			@Override
					public Student getStudent(String kodId) {
						Student st = srepo.findById(kodId).get();
						return st;
					}
					
					//list method
					
					@Override
					public List<Student> getAllStudents() {
						
						List<Student> slist = srepo.findAll();// TODO Auto-generated method stub
						return slist;
					}
					
					
					
					public String deleteStudent(String kodId) {
						
						srepo.deleteById(kodId);
						
						return "student deleted successfully";
				}
					
	}

