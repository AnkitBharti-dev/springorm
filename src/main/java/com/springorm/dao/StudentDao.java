package com.springorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		return (Integer)this.hibernateTemplate.save(student);
	}
	
	@Transactional
	public Student getStudent(int id) {
		return this.hibernateTemplate.get(Student.class, id);
	}
	
	@Transactional
	public List<Student> getAllStudents() {
		return this.hibernateTemplate.loadAll(Student.class);
	}
	
	@Transactional
	public void update(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	@Transactional
	public void delete(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
