package controller;

import java.util.*;
import model.Service;
import database.*;

public class ServiceController {
	//private List<Service> services;
	private ServiceDB serviceDB;

	public ServiceController() {
		//this.services = new ArrayList<>();
		this.serviceDB = new ServiceDB();

	}

	public List<Service> getAllServices() {
		return serviceDB.getAllServices();
	}
	
	public Service findServiceById(int serviceId) {
		return serviceDB.findServiceById(serviceId);
	}
}
