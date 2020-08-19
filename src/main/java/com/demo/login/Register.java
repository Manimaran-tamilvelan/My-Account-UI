package com.demo.login;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

	// private static List<List<String>> finalList = new ArrayList();
	private static Map<Integer, List<String>> finalUsers = new LinkedHashMap();
	private static int userID = 101;

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String mailID = request.getParameter("mailID");
		String dOB = request.getParameter("dob");
		String mobileNo = request.getParameter("mobileNo");

		List<String> tempList = new ArrayList();

		tempList.add(userName);
		tempList.add(password);
		tempList.add(mailID);
		tempList.add(dOB);
		tempList.add(mobileNo);

		// finalList.add(tempList);
		finalUsers.put(userID, tempList);
		userID++;
		// response.getWriter().println(l);
		response.getWriter().print("<script>alert(\"Registered Successfully! Please Login\")</script>");

		// response.sendRedirect("index.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

		rd.include(request, response);
	}

	public static Map admin() {
		return finalUsers;
	}

	public static List userNamePasswordFilter() {

		List<List> userNamesPassword = new ArrayList();

		for (Map.Entry<Integer, List<String>> entry : finalUsers.entrySet()) {
			List<String> tempList = new ArrayList();
			tempList.add(entry.getValue().get(0));
			tempList.add(entry.getValue().get(1));
			userNamesPassword.add(tempList);

		}

		return userNamesPassword;

	}

	public static Map deleteUser(int user_ID) {

		finalUsers.remove(user_ID);
		return finalUsers;
	}

}
