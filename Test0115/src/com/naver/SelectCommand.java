package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		MemberDAO dao = new MemberDAO();
		
		List<MemberDTO> list = dao.select();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

}
