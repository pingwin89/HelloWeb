package com.tutorialspoint;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

public void setDataSource(DataSource dataSource){
	this.dataSource = dataSource;
	this.jdbcTemplateObject = new JdbcTemplate(dataSource);
}

@Override
public Student getStudent(int id){
	String SQL = "Select * from Students where id = ?";
	Student student = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new StudentMapper());
	return student;
}

}
