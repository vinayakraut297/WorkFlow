package com.vinayak.workflow.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vinayak.workflow.entity.Country;
import com.vinayak.workflow.entity.Employee;
import com.vinayak.workflow.entity.Registration;

import aj.org.objectweb.asm.commons.TryCatchBlockSorter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MainDao {
	
	@Autowired
    private EntityManager entityManager;

	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country country) {
	
//		Session session=factory.openSession();
		 Session session=null;
		 Transaction tx=null;
		 String msg=null;
		 
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(country);
			tx.commit();
			msg="Country is Added Successfully";	
		}
		catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session !=null)
			session.close();
		}
		return msg;
	}

	public String updateCountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Country country=session.get(Country.class, c.getCid());
			
			if(c.getCname()!=null) {
				country.setCname(c.getCname());
			}
			session.merge(country);
			tx.commit();
			msg="Country is Updated";
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteCountry(Integer cid) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Country country=session.get(Country.class, cid);
			session.remove(country);
			tx.commit();
			msg="Country is deleted";
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
			
	}

	public Country getParticularCountryById(Integer id) {
		Session session=null;
		Transaction tx=null;
		Country country=null;
		

		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			if(id!=null) {
		    country=session.get(Country.class, id);
			}
			tx.commit();
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return country;
		
	}

	public List<Country> getAllCountry() {
		Session session=null;
		Transaction tx=null;
		List<Country> list=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			String hqlQuery="from Country";
			
		Query<Country> query=session.createQuery(hqlQuery, Country.class);
			list=query.list();
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
		
	}

	public String addEmployee(Employee employee) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
	
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			session.persist(employee);
			tx.commit();
			msg="Employee Added Successfully...";
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
		

	}



	public String updateEmployee(Employee emp) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Employee databaseRecord=null;
	
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
		databaseRecord=session.get(Employee.class, emp.getId());
		
		if(emp.getName()!=null) {
			databaseRecord.setName(emp.getName());
		}
		  if(emp.getStatus()!=null) {
			  databaseRecord.setStatus(emp.getStatus());
		  }
		  if(emp.getDepartment()!=null) {
			  databaseRecord.setDepartment(emp.getDepartment());
		  }
		  
		  if(emp.getMobileno()!=null) {
			  databaseRecord.setMobileno(emp.getMobileno());
		  }
		  
		  if(emp.getEmailid()!=null) {
			  databaseRecord.setEmailid(emp.getEmailid());
		  }
		  
		  if(emp.getCreatedBy()!=null) {
			  databaseRecord.setCreatedBy(emp.getCreatedBy());
		  }
		  
		  if(emp.getCreatedDate()!=null) {
			  databaseRecord.setCreatedDate(emp.getCreatedDate());
		  }
		  
		  if(emp.getUpdateBy()!=null) {
			  databaseRecord.setUpdateBy(emp.getUpdateBy());
		  }
		
		  
		  if(emp.getUpdatedDate()!=null) {
			  databaseRecord.setUpdateBy(emp.getUpdateBy());
		  }
		  
		  if(emp.getSalary()!=0) {
			 databaseRecord.setSalary(emp.getSalary());
		  }
		  
		  session.merge(databaseRecord);
		  tx.commit();
		  msg="Employee is Updated Successfully";
		
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	
	}

	public String deleteEmployee(Integer id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Employee databaseRecord=null;
		
	
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			databaseRecord=session.get(Employee.class, id);
			session.remove(databaseRecord);
			tx.commit();
			msg="Employee Recor is Deleted";
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
			
	}

	public Employee getparticularEmployeeById(Integer id) {
		Session session=null;
		Transaction tx=null;
		Employee databaseRecord=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			databaseRecord=session.get(Employee.class, id);
		        tx.commit();
		        
		    	
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return databaseRecord;
		        
		
	}

	public List<Employee> getAllRecord() {
		Session session=null;
		Transaction tx=null;
		
		List<Employee>list=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			String hqlQuery="from Employee";
			Query<Employee> query=session.createQuery(hqlQuery, Employee.class);
			list=query.list();
			tx.commit();
			
	    	
			} catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
		return list;
	}

	

	public Employee login(Employee emp) {
		Session session=null;
		Transaction tx=null;
		Employee e=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			String hqlQuery="from Employee where emailid=:email and mobileno=:mobile";
			Query<Employee> query=session.createQuery(hqlQuery, Employee.class);
			
			query.setParameter("email", emp.getEmailid());
			query.setParameter("mobile", emp.getMobileno());
			e=query.uniqueResult();
			tx.commit();
			
			} catch (Exception e1) {
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
		return e;
		
	}

	public List<Employee> getEmpBySalaryRange(double startsal, double endsal) {
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			String hqlQuery="from Employee where salary between : startsal and :endsal";
			Query<Employee> query=session.createQuery(hqlQuery, Employee.class);
			
			query.setParameter("startsal",startsal);
			query.setParameter("endsal", endsal);
			list=query.list();
			tx.commit();
			
			} catch (Exception e1) {
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
		return list;
	}

//	public String registerUser(Registration user) {
//		@Transactional
//	   
//		
//	        entityManager.persist(user);
//	        return "User Registered Successfully";
//	    }
		
	public Registration loginUser(String emailId, String password) {
		 jakarta.persistence.Query query = entityManager.createQuery("SELECT r FROM Registration r WHERE r.emailId = :email AND r.password = :password");
	        query.setParameter("email", emailId);
	        query.setParameter("password", password);

	        List<Registration> users = query.getResultList();
	        return users.isEmpty() ? null : users.get(0);
	    
	
	}

//	public String registerUser(Registration user) {
//		@Transactional
//		
//		entityManager.persist(user);
//		return "User Registered Successfully";
//	}
	
	public String registerUser(Registration user) {
		try {
			entityManager.persist(user);
			return "User Registered Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Registration Failed";
		}
	}


}
