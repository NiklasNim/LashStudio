package database;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import controller.*;
import model.Schedule;
import model.Service;

public interface ServiceDBIF {

	//List<Service> findAllServices();

	//void createService(Service newService);

	//List<Service> findAllServiceDates(LocalDate date);
	
	Service findServiceById(int serviceId);

<<<<<<< Updated upstream
	LocalDateTime findAvailableServiceDates(int serviceId);
=======
	LocalDate findAvailableServiceDates(int serviceId);
	
	List<Schedule> getAllAvailableDates();
>>>>>>> Stashed changes
}
