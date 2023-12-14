package database;

import java.time.LocalDate;
import java.util.List;

import controller.*;
import model.Service;

public interface ServiceDBIF {

	List<Service> findAllServices();

	void createService(Service newService);

	List<Service> findAllServiceDates(LocalDate date);

	LocalDate findAvailableServiceDates(int serviceId);
}
