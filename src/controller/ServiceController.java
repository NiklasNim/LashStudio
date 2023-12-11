package controller;
import java.util.List;
import model.Service;

public class ServiceController {

	private List<Service> services;

	public void addServiceById(int serviceId, Service newService) {
		for (Service existingService : services) {
			if (existingService.getServiceId() == serviceId) {
				System.out.println("Service with ID " + serviceId + " already exists.");
				return;
			}
		}
		services.add(newService);
		System.out.println("Service with ID " + serviceId + " added successfully.");
	}

}
