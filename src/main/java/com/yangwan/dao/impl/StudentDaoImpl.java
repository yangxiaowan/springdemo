package com.yangwan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;
	
	@Override
	@Transactional("primaryTransactionManager")
	public void addStudent() {
//		String sqlString = "insert into student(id,name,age) values(4,'yangxiao',22)";
		Student student = new Student();
		student.setName("yangwan");
		student.setAge(22);
		entityManager.persist(student);
		entityManager.flush();
//		entityManager.createNativeQuery(sqlString).executeUpdate();
	}
	
	
	@Override 
	public void selectStudent() {
		String sqlString = "select * from student";
		List<Object> list = entityManager.createNativeQuery(sqlString).getResultList();
		System.out.println(list.get(0));
		
	}
	
	
	
	public void sayTest(){
		System.out.println("studentDao test!!!");
	}
}
