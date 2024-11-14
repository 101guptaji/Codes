package myPackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class JkServlet
 */
@WebServlet("/HgServlet")
public class HgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: Mangaze").append(request.getContextPath());
		String userName = request.getParameter("userName");
		String password = request.getParameter("pass");
		//response.getWriter().append("doGet() is calling for User="+userName+", Password="+password);
		
		//1. data transmitting using URL - Parameters
		//response.sendRedirect("HgServlet2?data1="+userName+"&data2="+password); 
		
		//2. Request Attributes
		/*request.setAttribute("data1", userName);
		request.setAttribute("data2", password);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HgServlet2");
		dispatcher.forward(request, response); */
		
		//3. Session Attributes
		HttpSession session = request.getSession();
		session.setAttribute("data1", userName);
		session.setAttribute("data2", password);
		request.getRequestDispatcher("HgServlet2").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("pass");
		response.getWriter().append("doPost() is calling for User="+userName+", Password="+password);
	}

}
