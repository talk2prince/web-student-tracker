package com.sql.web.java;


import java.util.*;
import javax.sql.DataSource;

import javax.annotation.Resource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private StudentDbUtil studentDbUtil;

	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		
		super.init();
		try {
		studentDbUtil = new StudentDbUtil(dataSource);
	}catch(Exception ex){
		throw new ServletException(ex);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			listStudents(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Student> students = studentDbUtil.getStudents();
		
		request.setAttribute("STUDENT_LIST", students);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}


}