package com.pgr.springhibernate.bean;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EmployeeDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void updateEmployee(Employee employee)
	{
		hibernateTemplate.update(employee);
	}
	
	public void saveEmployee(Employee employee)
	{
		hibernateTemplate.save(employee);
	}
	
	public void deleteEmployee(int id)
	{
		Employee employee = hibernateTemplate.get(Employee.class,id);
		hibernateTemplate.delete(employee);
	}
	
	public Employee getEmployee(int id)
	{
		Employee employee = hibernateTemplate.get(Employee.class, id);
		return employee;
	}
	
	public List<Employee> getAllEmployees()
	{
		return hibernateTemplate.execute(new HibernateCallback<List<Employee>>() {

			//@Override
			public List<Employee> doInHibernate(Session session) throws HibernateException {
				Query<Employee> query = session.createQuery("from Employee");
				List<Employee> list = query.list();
				return list;
			}
		});
	}

}
