package com.demo.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoggingIn", urlPatterns = { "/login" })
public class MyLogin extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String userName = req.getParameter("uname");
		String password = req.getParameter("pwd");

		res.setContentType("text/html");
		// using pw we can write the output to HttpServletResponse & send it
		PrintWriter out = res.getWriter();

		List<List> userAuthDetails = Register.userNamePasswordFilter();

		for (int loop = 0; loop < userAuthDetails.size(); loop++) {

			if (userAuthDetails.get(loop).get(0).equals(userName)
					&& userAuthDetails.get(loop).get(1).equals(password)) {

				HttpSession sess = req.getSession();
				sess.setAttribute("usr", userName);
				// req.setAttribute("userDetails", userAuthDetails.get(loop));

			/**	Map<Integer, List<String>> usersDuplicateCopy = Register.admin();
				//System.out.println(usersDuplicateCopy);
				List<Integer> keyList = new ArrayList<Integer>();
				for(Map.Entry<Integer, List<String>> e:usersDuplicateCopy.entrySet()) {
					//keyList.add(e.getKey());
					int a;

					if (e.getValue().get(0).equals(userName) && e.getValue().get(1).equals(password)) {

						System.out.println(e.getKey());
						int a = e.getKey();
					}

				} 
			*/List<String> finalAuthUser = new ArrayList();
			Map<Integer, List<String>> usersDuplicateCopy = Register.admin();
			
			for(Map.Entry<Integer, List<String>> entry: usersDuplicateCopy.entrySet()) {
				
				if(entry.getValue().get(0).equals(userName) && entry.getValue().get(1).equals(password)) {
					finalAuthUser.addAll(entry.getValue());
				}
			}
				//System.out.println(finalAuthUser);
				req.setAttribute("showUserDetail", finalAuthUser);
				//req.setAttribute("showUserDetail", usersDuplicateCopy.get(101+loop));
				req.getRequestDispatcher("welcome.jsp").forward(req, res);

				// System.out.println(usersDuplicateCopy.get(101+loop));

				// out.println(userAuthDetails.get(loop));
				// res.sendRedirect("welcome.jsp");
				// pw.println("Admin access");

			}
		}

		if (userName.equals("admin") && password.equals("admin")) {

			// out.print(Register.admin());

			Map<Integer, List<String>> usersCopy = Register.admin();

			req.setAttribute("allUsers", usersCopy);
			req.getRequestDispatcher("adminResult.jsp").forward(req, res);

		}

		else {
			// pw.println("Invalid Access");

			// res.sendRedirect("index.jsp");

			out.print("<script>alert(\"Incorrect Credentials\")</script>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");

			rd.include(req, res);

		}

	}

}
