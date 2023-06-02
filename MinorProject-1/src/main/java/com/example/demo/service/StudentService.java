package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
   String addStudent(Student s); //Creating
   Student getStudent(String kodId); //Reading
	List<Student> getAllStudents();	//Listing
    String updateStudent(Student s ); //Updating
	
   String deleteStudent(String kodId);//deleting
	
}
