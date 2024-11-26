<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jakarta.servlet.http.HttpSession"%>
    
<html>
<body>
	<%
		//retrive the session
	    HttpSession curr_session = request.getSession(false);
	
	    // Check if the session is not null 
	    if (curr_session != null) {
	    	curr_session.invalidate();
	    }
	    
        // Redirect to index page
        response.sendRedirect("index.html");
	%>

</body>
</html>