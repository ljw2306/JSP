package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckIdCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		
		MemberDTO dto = new MemberDAO().read(id);
		if (dto != null) {
			response.getWriter().print("사용 불가능한 ID");
		}else {
			response.getWriter().print("사용 가능한 ID");
		}
		
		return null;
	}

}
