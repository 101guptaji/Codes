package myPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class HgServlet2
 */
@WebServlet("/HgServlet2")
public class HgServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HgServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Hi, from servlet 2 using Dispatcher");
		
		//1. Data transmission using URL as parameter (not Secure)
		/*String userName = request.getParameter("data1");
		String password = request.getParameter("data2");
		response.getWriter().append("doGet() is calling From Servlet2 for User="+userName+", Password="+password);*/

		//2. Request Attributes
		/*String userName = request.getAttribute("data1").toString();
		String password = request.getAttribute("data2").toString();
		response.getWriter().append("<h1>doGet() is calling From Servlet2</h1> for User="+userName+", Password="+password);*/
		
		//3. Session Attributes
		HttpSession session = request.getSession();
		String userName = session.getAttribute("data1").toString();
		String password = session.getAttribute("data2").toString();
		response.getWriter().append("<h1>doGet() Servlet2 Session Attribute</h1> for User="+userName+", Password="+password);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
