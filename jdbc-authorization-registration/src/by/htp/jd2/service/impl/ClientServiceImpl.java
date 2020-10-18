package by.htp.jd2.service.impl;

import by.htp.jd2.dao.DAOException;
import by.htp.jd2.dao.DAOProvider;
import by.htp.jd2.dao.UserDAO;
import by.htp.jd2.entity.User;
import by.htp.jd2.service.ClientService;
import by.htp.jd2.service.ServiceException;

public class ClientServiceImpl implements ClientService{

	@Override
	public User authorization(String login, String password) throws ServiceException {
		
		DAOProvider daoProvider = DAOProvider.getInstance();					
		UserDAO userDAO = daoProvider.getUserDAO();								

		User user = null;														

		try {
			user = userDAO.authorization(login, password);						
		}catch (DAOException e){
			throw new ServiceException(e);
		}

		return user;
	}

	
	@Override
	public boolean registration(User user) throws ServiceException {
		
		DAOProvider daoProvider = DAOProvider.getInstance();
		UserDAO userDAO = daoProvider.getUserDAO();

		try {
			return userDAO.registration(user);								 
		}catch (DAOException e){
			throw new ServiceException(e);
			
		}
	}

}
