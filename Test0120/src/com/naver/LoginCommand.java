package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		MemberDAO dao = new MemberDAO();
		MemberDTO login = dao.login(id, age);
		
		HttpSession sess = request.getSession();
		sess.setAttribute("login", login);
		
		return new CommandAction(true, "list.do");

	}

}
