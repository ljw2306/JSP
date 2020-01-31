package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String sNum = request.getParameter("num");
		int orinum = -1;
		if (sNum != null) {
			orinum = Integer.valueOf(sNum);
		}
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		dao.reply(orinum, author, title, content);
		
		return new CommandAction(true, "list.do");
	}

}
