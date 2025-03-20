 package com.vinayak.workflow.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinayak.workflow.entity.Country;
import com.vinayak.workflow.entity.Employee;
import com.vinayak.workflow.entity.Registration;
import com.vinayak.workflow.service.MainService;


@RestController
@RequestMapping("api")
@CrossOrigin
public class MainController {

	 @Autowired
	 MainService service;
	 
	 @PostMapping("addcountry")
	 public ResponseEntity<String> addCountry(@RequestBody Country country) { 
		 String msg=service.addCountry(country);
		 return ResponseEntity.ok(msg);
	 }
	 
	 @PutMapping("updatecountry")
	 public ResponseEntity<String> updateCountry(@RequestBody Country country){
		 String msg=service.updateCountry(country);
		 return ResponseEntity.ok(msg);
	 }
	 
	 @DeleteMapping("deletecountry/{cid}")
	 public ResponseEntity<String>deleteCountry(@PathVariable Integer cid){
		 String msg=service.deleteCountry(cid);
		 return ResponseEntity.ok(msg);
	 }
		 
	 @GetMapping("getdata/{id}")
	 public ResponseEntity<Country> getParticularCountryById(@PathVariable Integer id){
		 Country country=service.getParticularCountryById(id);
		 return ResponseEntity.ok(country);
	 }
	 
	 @GetMapping("getallcountry")
	 public ResponseEntity<List<Country>> getAllCountry(){
		 List<Country> list=service.getAllCountry();
		 return ResponseEntity.ok(list);
	 }
	 
	 @PostMapping("addEmployee")
	 public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
	String msg=service.addEmployee(employee);
	   return ResponseEntity.ok(msg);
	 }
	 
	@PutMapping("updateEmployee")
	public ResponseEntity<String> udateEmployee(@RequestBody Employee emp){
		String msg= service.updateEmployee(emp);
		return ResponseEntity.ok(msg);
	}
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		String msg= service.deleteEmployee(id);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getparticular-record/{id}")
	public ResponseEntity<Employee> getparticularEmployeeById(@PathVariable Integer id){
	Employee emp=service.getparticularEmployeeById(id);
	return ResponseEntity.ok(emp);
	}
	
	@GetMapping("getAllEmployee")
	 public ResponseEntity<List<Employee>> getAllRecord(){
		 List<Employee> list=service.getAllRecord();
		 return ResponseEntity.ok(list);
	}
	
	 @PostMapping("login")
     public ResponseEntity<HashMap<String, Object>> login(@RequestBody Employee emp) {
    	 HashMap<String, Object> map=service.login(emp);
    	  return ResponseEntity.ok(map);
      }
	  
	 @GetMapping("get-all-salary/{startsal}/{endsal}")
	 public ResponseEntity<List<Employee>>getEmpBySalaryRange(@PathVariable double startsal, @PathVariable double endsal){
		 List<Employee>listSalary =service.getEmpBySalaryRange(startsal,endsal);
		 return ResponseEntity.ok(listSalary);
	 }
	    @PostMapping("loginUser")
	    public ResponseEntity<HashMap<String, Object>> loginUser(@RequestBody Registration reg) {
	        HashMap<String, Object> response = service.loginUser(reg.getEmailId(), reg.getPassword());
	        return ResponseEntity.ok(response);
	    }
	    @PostMapping("signup")
	    public ResponseEntity<String> registerUser(@RequestBody Registration user) {
	        String msg = service.registerUser(user);
	        return ResponseEntity.ok(msg);
	    }
	
}
