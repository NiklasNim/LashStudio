package database;
import java.time.LocalDateTime;
import java.util.List;
import model.Service;

public interface ServiceDBIF {
	Service findServiceById(int serviceId);
	LocalDateTime findAvailableServiceDates(int serviceId);
	List<Service> getAllServices();
}