package controller;

import java.util.*;
import model.Service;
import database.*;

public class ServiceController {
	private List<Service> services;
	private ServiceDB serviceDB;

	public ServiceController() {
		this.services = new ArrayList<>();
		this.serviceDB = new ServiceDB();
        this.services = serviceDB.findAllServices();
	}

	public List<Service> getAllServices() {
		return services;
	}
	
	public Service findServiceById(int serviceId) {
		
		return serviceDB.findServiceById(serviceId);
	}

	public void createService(Service newService) {
		serviceDB.createService(newService);
	}

}
