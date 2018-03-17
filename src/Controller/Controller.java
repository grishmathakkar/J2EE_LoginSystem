	package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;
import Account.Account;
import Beans.User;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/login";
		String user = "root";
		String password = "";
		PrintWriter out = response.getWriter();
		
		request.setAttribute("email", "");
		request.setAttribute("message", "");

		try {
			Class.forName("com.mysql.jdbc.Driver"); // Driver Loading
		} catch (ClassNotFoundException e) {
			out.println("Cant load the Driver!");
		}

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			out.println("Cant establish the Connetion!");

		}
		
		String action = request.getParameter("action");
		
		if (action == null) 
		{
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
		else
		{
			doPost(request,response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session=request.getSession();
		if (action == null) 
		{
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
		else
			if(action.equals("dologin")){
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				
				Account account=new Account(con);
				
				try {
					
					boolean status=account.login(email, password);
					if(status){
						
						 Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
					      request.setCharacterEncoding("UTF-8"); // Do this so we can capture non-Latin chars
					    String answer = request.getParameter("answer");
					    
					    if (captcha.isCorrect(answer)){
					    	request.getRequestDispatcher("/user.jsp").forward(request,
									response);
					    }
					    else{
					    	request.setAttribute("message", "Image Text Incorrect!! Try Again");
					    	request.setAttribute("email", email);
					    	request.getRequestDispatcher("/login.jsp").forward(request,
									response);
					    }
						
					}
					else{
						request.setAttribute("message", "User Does not Exists.Try Again");
						request.setAttribute("email", email);
						request.getRequestDispatcher("/login.jsp").forward(request,
								response);
					}
						
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else 
				if(action.equals("signup")){
					request.setAttribute("name", "");
					request.setAttribute("email", "");
					request.setAttribute("message", "");
					request.getRequestDispatcher("/signup.jsp").forward(request,
							response);
				}
		
				else
					if(action.equals("doregister")){
						
						String name=request.getParameter("name");
						String email=request.getParameter("email");
						String password=request.getParameter("password");
						String repass=request.getParameter("repassword");
						
						User user = new User(name,email,password);
						
						if(user.validate()){
							if(password.equals(repass)){
								Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
								request.setCharacterEncoding("UTF-8"); // Do this so we can capture non-Latin chars
								String answer = request.getParameter("answer");
									if (captcha.isCorrect(answer)){
										
										request.setAttribute("message", "Registration Success!! <BR /> Please Login");
										Account acct=new Account(con);
										try {
											acct.insert(name, email, password);
										} catch (SQLException e) {
											e.printStackTrace();
										}
										request.setAttribute("email", "");
										request.getRequestDispatcher("/login.jsp").forward(request,
												response);
									}
									else{
										request.setAttribute("name", name);
										request.setAttribute("email", email);
										request.setAttribute("password", password);
										request.setAttribute("message", "Image Text Incorrect!! Try Again");
								    	request.getRequestDispatcher("/signup.jsp").forward(request,
												response);
									}
							}
							else{
								request.setAttribute("name", name);
								request.setAttribute("email", email);
								request.setAttribute("password", password);
								request.setAttribute("message", "Passwords do not match!! Try Again");
						    	request.getRequestDispatcher("/signup.jsp").forward(request,
										response);		
							}
							
						}
						else{
							request.setAttribute("name", name);
							request.setAttribute("email", email);
							request.setAttribute("message", user.getMessage());
							request.getRequestDispatcher("/signup.jsp").forward(request,
									response);		
							}	
						}
						
					}
					
			}
	


