package com.yangwan.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangwan.SpringBootDemoApplication;
import com.yangwan.dao.StudentDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class DaoTest {

	@Autowired
	private StudentDao studentDao;
	
	@Test
	public void StudentDaoTest(){
		studentDao.addStudent();
	}
	
	
}
