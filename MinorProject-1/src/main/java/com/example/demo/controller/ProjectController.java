package com.example.demo.controller;

import java.util.List;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class ProjectController {
	
	StudentService ss;
	public ProjectController(StudentService ss) {
		super();
		this.ss = ss;
	}


	@GetMapping("register.html")
	  public String mapRegister() {
	    return "register";
	}
	    
	    
	    @GetMapping("remove.html")
		  public String mapremove() {
		    return "remove";
}
	    
	    
	    @GetMapping("updateInfo.html")
		  public String mapUpdateInfo() {
		    return "updateInfo";
}
	    
	    
	    @GetMapping("viewInfo.html")
		  public String mapViewInfo() {
		    return "viewInfo";
	    }
		    
		    @GetMapping("showInfo.html")
			  public String showInfo() {
			    return "showInfo";
}
		    
		    @GetMapping("index.html")
			  public String index() {
			    return "index.html";
}
		    
		    
		    @GetMapping("/getAllStud")
		    public List<Student> getAllStudents(Model model) {
		    	
		    	List<Student>stList= ss.getAllStudents();
		    	
		    	model.addAttribute("list", stList);
		    	System.out.println(stList);
		    	return stList;
		    }
		    
		    @PostMapping("/addStud")
		    public String addStudent(@RequestParam("name") String name,
		    										@RequestParam("kodId") String kodId,
		    						 @RequestParam("branch") String branch)
		    {
		    	
		    
		   Student s = new Student(kodId,name,branch);
		   System.out.println(s);
		    ss.addStudent(s);
		    return "index";
		    
}
		    
		    
		    @PutMapping("/updStud")
		    public String updateStudent(@RequestParam("kodId") String kodId,
		    						 @RequestParam("name") String name,
		    						 @RequestParam("branch") String branch)
		    {
		    	
		    
		  
		   Student st = ss.getStudent(kodId);
		   st.setKodId(kodId);
		   st.setName(name);
		   st.setBranch(branch);
		   ss.updateStudent(st);
		    return "redirect:/"; 
		    }
		    
		    @GetMapping("/getStud")
		    public String getStudent(@RequestParam ("kodId") String kodId,Model model) {
		    Student st = ss.getStudent(kodId);
		    model.addAttribute("student",st);
		    System.out.println(st);
			return "showInfo";
		    }
			
			@DeleteMapping("/delstud")
			public String deleteStudent(@RequestParam("kodId") String kodId)
			{
				ss.deleteStudent(kodId);
				return"redirect:/";
			}
}

