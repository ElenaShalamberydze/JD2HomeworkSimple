package by.htp.jd2.service;

import by.htp.jd2.entity.User;

public interface ClientService {
	
	User authorization (String login, String password) throws ServiceException;

	boolean registration (User user) throws ServiceException;

}
