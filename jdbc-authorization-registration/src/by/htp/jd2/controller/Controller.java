package by.htp.jd2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.jd2.controller.command.Command;
import by.htp.jd2.controller.command.CommandProvider;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PARAMETER_COMMAND = "command";

	private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");				
		
		String pathName = request.getParameter(PARAMETER_COMMAND); 				
		request.getRequestDispatcher(provider.getPath(pathName)).forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String commandName = request.getParameter(PARAMETER_COMMAND);			
		Command command = provider.getCommand(commandName);						

		command.execute(request, response);										
	}

}
