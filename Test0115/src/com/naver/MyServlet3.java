package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet3
 */
@WebServlet("*.do")
public class MyServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String what = request.getServletPath();
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		String cPath = request.getContextPath();
		System.out.println(cPath);
		
		String what = uri.substring(cPath.length());
		
		Command com = null;
		
		
		if (what.equalsIgnoreCase("/insert.do")) {
			com = new InsertCommand();
		}else if (what.equalsIgnoreCase("/list.do")) {
			com = new SelectCommand();
		}else if (what.contentEquals("/insertui.do")) {
			com = new InsertUICommand();
		}
				
		if (com != null) {
			com.execute(request, response);
		}
		
//		System.out.println(what);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
