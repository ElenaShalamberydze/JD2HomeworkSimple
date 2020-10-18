package by.htp.jd2.dao;

import by.htp.jd2.entity.User;

public interface UserDAO {

	User authorization (String login, String password) throws DAOException;
	
	boolean registration (User user) throws DAOException;
	
}
