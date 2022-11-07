package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Students;
import java.util.List;
//import antlr.collections.List;


public interface StudentsRepo extends JpaRepository<Students, Integer> {
	List<Students> findBysDepartment(String sDepartment);
}
