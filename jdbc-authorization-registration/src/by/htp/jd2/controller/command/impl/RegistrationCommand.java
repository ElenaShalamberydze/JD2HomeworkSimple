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

public class RegistrationCommand implements Command{

	private static final String PARAMETER_LOGIN = "login";
	private static final String PARAMETER_PASSWORD = "password";
	private static final String PARAMETER_NAME = "name";
	private static final String PARAMETER_SURNAME = "surname";
	private static final String PARAMETER_AGE = "age";
		
	private static final String MAIN_PAGE = "/WEB-INF/jsp/main.jsp";
	private static final String ERROR_PAGE = "/WEB-INF/jsp/error.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login;
		String password;
		String name;
		String surname;
		int age;
		
		String page;
		
		if(("").equals(request.getParameter(PARAMETER_LOGIN))
				||("").equals(request.getParameter(PARAMETER_PASSWORD))
				||("").equals(request.getParameter(PARAMETER_NAME))								
				||("").equals(request.getParameter(PARAMETER_SURNAME))
				||("").equals(request.getParameter(PARAMETER_AGE))){
			
			request.setAttribute("error", "Error! Please fill ALL fields!");
			page = ERROR_PAGE;
			
		}else {
			
			login = request.getParameter(PARAMETER_LOGIN);
			password = request.getParameter(PARAMETER_PASSWORD);
			name = request.getParameter(PARAMETER_NAME);
			surname = request.getParameter(PARAMETER_SURNAME);
			age = Integer.parseInt(request.getParameter(PARAMETER_AGE));
			
			ServiceProvider provider = ServiceProvider.getInstance();
			ClientService service = provider.getClientService();

			User user = new User();
			
			user.setLogin(login);
			user.setPassword(password);
			user.setName(name);
			user.setSurname(surname);
			user.setAge(age);
		
			try {
			
				boolean result = service.registration(user);
				if(result) {
					request.setAttribute("user", user);
					page = MAIN_PAGE;
				}else {
					request.setAttribute("error", "User already exists!");
					page = ERROR_PAGE;
				}															    

			} catch (ServiceException e) {
				request.setAttribute("error", "Error. Try again!");
				page = ERROR_PAGE;
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

}
