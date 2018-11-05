package com.sql.web.java;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;




public class StudentDbUtil {

	private DataSource dataSource;
	
	public StudentDbUtil(DataSource theDataSource)
	{
		dataSource = theDataSource;
	}
	public List<Student> getStudents() throws Exception{
		List<Student> students = new ArrayList<>();
		
		java.sql.Connection myConn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			
            myConn = dataSource.getConnection();
			
			String sql = "select * from student order by last_name";
			stmt = myConn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				
				int id = rs.getInt("id");
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				String email = rs.getString("email");
				
				Student tempStudent = new Student(id, firstname, lastname, email);
				students.add(tempStudent);
			}
			
			return students;
		}finally {
			close(myConn,stmt,rs);
		}
	
	}
	
	private void close(java.sql.Connection myConn,Statement stmt,ResultSet rs)
	{
		try {
			
			if(rs !=null)
			{
				rs.close();
			}
			if(stmt !=null)
			{
			     stmt.close();
			}
			if(myConn !=null)
			{
				myConn.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
