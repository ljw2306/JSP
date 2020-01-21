package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
//		1.client에서 보내준 데이터 가공
//		2.DAO 객체 및 해당 method 호출
		MemberDAO dao = new MemberDAO();
//		3.바인딩
		List<MemberDTO> list = dao.list();
		request.setAttribute("list", list);
//		4포워딩
		
		return new CommandAction(false, "list.jsp");
	}
}
