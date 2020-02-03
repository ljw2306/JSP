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
		
		String sCurPage = request.getParameter("curPage");
		int curPage = 1;
		if (sCurPage != null) {
			curPage = Integer.parseInt(sCurPage);
		}
		
		BoardDAO dao = new BoardDAO();
		/* List<BoardDTO> list = dao.list(); */
		PageTO to = dao.list(curPage);
		
		request.setAttribute("list", to.getList());
		request.setAttribute("to", to);
		return new CommandAction(false, "list.jsp");
	}

}
