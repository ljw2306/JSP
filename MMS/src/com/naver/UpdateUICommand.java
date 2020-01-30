package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		MemberDTO dto = new MemberDAO().updateui(id);
		
		request.setAttribute("dto", dto);
		
		return new CommandAction(false, "update.jsp");
	}

}
