package by.htp.jd2.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.jd2.controller.command.Command;
import by.htp.jd2.entity.User;
import by.htp.jd2.service.ClientService;
import by.htp.jd2.service.ServiceException;
import by.htp.jd2.service.ServiceProvider;

public class AuthorizationCommand implements Command{

	private static final String PARAMETER_LOGIN = "login";											
	private static final String PARAMETER_PASSWORD = "password";

	private static final String MAIN_PAGE = "/WEB-INF/jsp/main.jsp";								 
	private static final String ERROR_PAGE = "/WEB-INF/jsp/error.jsp";	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;
		String page;
		
		if(("").equals(request.getParameter(PARAMETER_LOGIN))
				||("").equals(request.getParameter(PARAMETER_PASSWORD))) {
			
			request.setAttribute("error", "Error! Please fill ALL fields!");
			page = ERROR_PAGE;			
		
		}else {
		
			login = request.getParameter(PARAMETER_LOGIN);
			password = request.getParameter(PARAMETER_PASSWORD);
			
			ServiceProvider provider = ServiceProvider.getInstance();						
			ClientService service = provider.getClientService();							

			User user = null;																																	//ссылка для записи URL,на какую страницу переходить
			
			try {
			
				user = service.authorization(login, password);								
			
				if (user == null) {
					request.setAttribute("error", "Error! Incorrect Login or Password!");
					page = ERROR_PAGE;
				}else {
					request.setAttribute("user", user);
					page = MAIN_PAGE;
				}

			} catch (ServiceException e) {
				request.setAttribute("error", "Error, try again!");
				page = ERROR_PAGE;				
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
	}

}

