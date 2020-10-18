package by.htp.jd2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.jd2.entity.RegParameters;
import by.htp.jd2.entity.RegistrationInfo;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		
		if(("").equals(request.getParameter(RegParameters.NAME))
				||("").equals(request.getParameter(RegParameters.SURNAME))
				||("").equals(request.getParameter(RegParameters.EMAIL))
				||("").equals(request.getParameter(RegParameters.AGE))) {
			
			PrintWriter out = response.getWriter();
			
			out.println("<html><head>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
			out.println("<title>Title</title>");
			out.println("</head><body>");
			out.println("<h2>Please, fill all fields!</h2>");
			out.println("<form action=\"index.jsp\" method=\"get\">");
			out.println("<input type=\"submit\" value=\"Try again\" />");
			out.println("</form>");
			out.println("</body></html>");
			
		} else {
			System.out.println("New user detected! Name: " + request.getParameter(RegParameters.NAME) +
							    ", Surname: " + request.getParameter(RegParameters.SURNAME) + 
							    ", E-mail: " + request.getParameter(RegParameters.EMAIL) + 
							    ", Age: " + request.getParameter(RegParameters.AGE));
			
			RegistrationInfo regInfo = new RegistrationInfo();
			regInfo.setName(request.getParameter(RegParameters.NAME));
			regInfo.setSurname(request.getParameter(RegParameters.SURNAME));
			regInfo.setEmail(request.getParameter(RegParameters.EMAIL));
			regInfo.setAge(Integer.parseInt(request.getParameter(RegParameters.AGE)));
			
			request.setAttribute("regInfo", regInfo);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			requestDispatcher.forward(request, response);
		}

	}
}
