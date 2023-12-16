package controller;
import model.Service;
import database.*;

public class ServiceController {
	private ServiceDBIF serviceDB;

	public ServiceController() {
		this.serviceDB = new ServiceDB();
	}

	public Service findServiceById(int serviceId) {
		return serviceDB.findServiceById(serviceId);
	}
}