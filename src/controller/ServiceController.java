package controller;
import model.Service;
import java.util.List;
import database.*;

public class ServiceController {
	private ServiceDBIF serviceDB;

	// Konstruktør til at initialisere ServiceDBIF implementeringen 
	public ServiceController() {
		this.serviceDB = new ServiceDB();
	}

	// Finder en service baseret på serviceId
	public Service findServiceById(int serviceId) {
		return serviceDB.findServiceById(serviceId);
	}
	
	// Henter alle services fra databasen
	public List<Service> getAllServices() {
		return serviceDB.getAllServices();
	}
}