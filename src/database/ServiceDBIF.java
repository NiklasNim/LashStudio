package database;

import java.time.LocalDate;
import java.util.List;

import controller.Services;
import model.Service;

public interface ServiceDBIF {

	List<Service> findAllServices();

	void createService(Service newService);

	List<Service> findAllServiceDates(LocalDate date);

}
