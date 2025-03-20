package com.vinayak.workflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinayak.workflow.dao.MainDao;
import com.vinayak.workflow.entity.Country;
import com.vinayak.workflow.entity.Employee;
import com.vinayak.workflow.entity.Registration;




@Service
public class MainService {

	@Autowired
	MainDao dao;
	
	public String addCountry(Country country) {
		
		String msg=dao.addCountry(country);
		if(Objects.isNull(msg)) {
			msg="Country is Not Addedd";
		}
		return msg;
	}
	
	public String updateCountry(Country country) {
		String msg=dao.updateCountry(country);
		if(Objects.isNull(msg)) {
			msg="Country is Not updated";
		}
		return msg;
	}

	public String deleteCountry(Integer cid ) {
		String msg=dao.deleteCountry(cid);
		if(Objects.isNull(msg)) {
			msg="Country is not deleted";
		}
		return msg;
	}

	public Country getParticularCountryById(Integer id) {
		Country country=dao.getParticularCountryById(id);
		
		return country;
		
	}

	public List<Country> getAllCountry() {
		List<Country> list=dao.getAllCountry(); 
		return list;
	}

	public String addEmployee(Employee employee) {
		String msg=dao.addEmployee(employee);
		return msg;
	}

	public String updateEmployee(Employee emp) {
		String msg=dao.updateEmployee(emp);
		if(Objects.isNull(msg)) {
			msg="Country is not udated";
		}
		return msg;
	}

	public String deleteEmployee(Integer id) {
		String msg= dao.deleteEmployee(id);
		if(Objects.isNull(msg)) {
			msg="Country is not Deleted";
		}
		return msg;
	}

	public Employee getparticularEmployeeById(Integer id) {
		Employee emp=dao.getparticularEmployeeById(id);
		
		return emp;
	}

	public List<Employee> getAllRecord() {
		List<Employee> list=dao.getAllRecord(); 
		return list;
		
	}

	public HashMap<String, Object> login(Employee emp) {
		Employee e= dao.login(emp);
		HashMap<String, Object> map=new HashMap<String, Object>();
		if(e!=null) {
			map.put("msg","valid User");
			map.put("user", e);
		}
		else {
			map.put("msg", "Invalid User");
			map.put("user", e);
		}
		return map;
	}

	public List<Employee> getEmpBySalaryRange(double startsal, double endsal) {
		List<Employee>listEmp=dao.getEmpBySalaryRange(startsal, endsal);
		return listEmp;
	}

	public String registerUser(Registration user) {
		 String msg = dao.registerUser(user);
	        if (Objects.isNull(msg)) {
	            msg = "Registration Failed!";
	        }
	        return msg;
	}


	public HashMap<String, Object> loginUser(String emailId, String password) {
		
		 Registration user = dao.loginUser(emailId, password);
	        HashMap<String, Object> response = new HashMap<>();
	        if (user != null) {
	            response.put("message", "Login Successful");
	            response.put("user", user);
	        } else {
	            response.put("message", "Invalid Email or Password");
	            response.put("user", null);
	        }
	        return response;
	}	
}
