package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = -1;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}
		
		MemberDTO dto = new MemberDAO().update(new MemberDTO(id, name, age));
		
		return new CommandAction(true, "read.do?id="+id);
	}

}
