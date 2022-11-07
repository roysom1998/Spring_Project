package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Students;
import com.example.demo.services.StudentsRepo;

@Controller
public class StudentsController {

  @Autowired	
  StudentsRepo studentsrepo;
  
  @RequestMapping("/")
  public String home() {
	  return "home.jsp";
  }
  @RequestMapping("/addStudents")
  public String addStudent(Students students) {
	  studentsrepo.save(students);
	  return "home.jsp";
  }
  @RequestMapping("/getStudents")
  public ModelAndView getStudent(@RequestParam int sId) {
	  ModelAndView mv=new ModelAndView("Show.jsp");
	  Students students=studentsrepo.findById(sId).orElse(new Students());
	  System.out.println(studentsrepo.findBysDepartment("ece"));
	  mv.addObject(students);
	  return mv;
  }
  
  //DELETE students by deleting students by id
  
  @DeleteMapping("/deleteStudents/{sId}")
  @ResponseBody
  public String deleteStudent(@PathVariable int sId) {
//	  ModelAndView mv=new ModelAndView("Show.jsp");
//	  Students students=studentsrepo.findById(sId).orElse(new Students());
//	  mv.addObject(students);
	  studentsrepo.deleteById(sId);
	  return "deleted successfully...";
  }
  
  //GET request for fetching whole students
  
  @RequestMapping(path="/students",produces= {"application/xml"})
  @ResponseBody
  public List<Students> displayStudents() {
	  return studentsrepo.findAll();
  }
  
  @PostMapping(path="/student",consumes="application/json")
  @ResponseBody
  public Students addStudents(@RequestBody Students students) {
	  studentsrepo.save(students);
	  return students;
  }
  
  //GET request for fetching student with id
  
  //below after /students/ wildcard is used
  @RequestMapping("/students/{sId}")
  @ResponseBody
  public Optional<Students> displayStudentsById(@PathVariable("sId") int sId) {
	  return studentsrepo.findById(sId);
  }
  
  //Updating The Data In Database
  
  @PutMapping(path="/updateStudent",consumes="application/json")
  @ResponseBody
  public Students addOrUpdateStudents(@RequestBody Students students) {
	  studentsrepo.save(students);
	  return students;
  }
}
