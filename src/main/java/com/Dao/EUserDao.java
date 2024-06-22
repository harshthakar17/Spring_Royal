package com.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.EUserBean;

//singleton -> new -> @Autowired 
	
@Repository	
public class EUserDao {
	
	

		@Autowired // instance eject
		JdbcTemplate stmt; // update() query()

		public void insertUser(EUserBean userBean) {
			// query ->
			stmt.update("insert into users(firstName,email,password) values (?,?,?) ", userBean.getFirstName(),
					userBean.getEmail(), userBean.getPassword());

		}

	}

