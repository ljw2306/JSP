package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = -1;
		
		if (pw != null) {
			age = Integer.parseInt(pw);
		}
		
		MemberDTO login = new MemberDAO().login(id,age);
		
		request.getSession().setAttribute("login", login);
		
		return new CommandAction(true, "list.do");
	}

}
