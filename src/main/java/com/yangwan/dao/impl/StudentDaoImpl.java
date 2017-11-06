package com.yangwan.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yangwan.dao.StudentDao;
import com.yangwan.domain.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 718173897790459170L;

	@Autowired
	private EntityManager entityManager;
	
	@Transactional("primaryTransactionManager")
	@Override
	public void addStudent() {
//		String sqlString = "insert into student(id,name,age) values(4,'yangxiao',22)";
		Student student = new Student();
		student.setName("yangwan");
		student.setAge(22);
		student.setId(42);
		entityManager.merge(student);
		entityManager.flush();
	}
	
	public void sayTest(){
		System.out.println("studentDao test!!!");
	}
}
