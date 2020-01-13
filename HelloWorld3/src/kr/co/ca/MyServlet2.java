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
 * Servlet implementation class MyServlet2
 */
@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("hometown");
		city = toKor(city);
		
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(city);
		out.print("</body>");
		out.print("</html>");
	}

	private String toKor(String city) {
		String msg = null;
		try {
			msg = new String(city.getBytes("8859_1"), "euc-kr");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
