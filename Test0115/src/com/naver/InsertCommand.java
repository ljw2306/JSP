package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		
		int age = -1;
		
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}
		
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age));
		
		response.sendRedirect("list.do");
		

	}

}
