package kr.co.ca;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet3
 */
@WebServlet("/MyServlet3")
public class MyServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] hbs = request.getParameterValues("hb");
		for (int i = 0; i < hbs.length; i++) {
			hbs[i] = toKor(hbs[i]);
		}
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		
		for(String hb : hbs) {
			out.print(hb);
			out.print("<br>");
		}
		
		out.print("</body>");
		out.print("</html>");
	}

	private String toKor(String hb) {
		String msg = null;
		try {
			msg = new String(hb.getBytes("8859_1"), "euc-kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	
		return msg;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
