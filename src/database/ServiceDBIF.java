package database;


import java.time.LocalDateTime;
import java.util.List;
import model.Schedule;
import model.Service;

public interface ServiceDBIF {

	//List<Service> findAllServices();

	//void createService(Service newService);

	//List<Service> findAllServiceDates(LocalDate date);
	
	Service findServiceById(int serviceId);


	LocalDateTime findAvailableServiceDates(int serviceId);

	
	List<Schedule> getAllAvailableDates();

}
