package by.htp.jd2.service;

import by.htp.jd2.service.impl.ClientServiceImpl;

public class ServiceProvider {
	
private static final ServiceProvider instance = new ServiceProvider();
	
	private ServiceProvider() {}
	
	private ClientService clientService = new ClientServiceImpl();
	
	
	public ClientService getClientService() {
		return clientService;
		
	}
	
	public static ServiceProvider getInstance() {
		return instance;
		
	}
}
