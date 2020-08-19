package com.demo.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userID = request.getParameter("userID");
		int deleteUserID = (Integer.parseInt(userID));
		
		
		request.setAttribute("allUsers", Register.deleteUser(deleteUserID));
		request.getRequestDispatcher("adminResult.jsp").forward(request, response);
		
		
	}

	


}
