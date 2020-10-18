package by.htp.jd2.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.jd2.controller.command.impl.AuthorizationCommand;
import by.htp.jd2.controller.command.impl.RegistrationCommand;

public class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();
	private Map<String, String> path = new HashMap<>();
	
	public CommandProvider() {
		commands.put("authorization", new AuthorizationCommand());
		commands.put("registration", new RegistrationCommand());		
		
		path.put("authorization", "/WEB-INF/jsp/authorization.jsp");	
		path.put("registration", "/WEB-INF/jsp/registration.jsp");	
	}
	
	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}
	
	public String getPath(String pathName) {
		return path.get(pathName);
	}

}
