package database;
import java.time.LocalDateTime;
import model.Service;

public interface ServiceDBIF {
	Service findServiceById(int serviceId);
	LocalDateTime findAvailableServiceDates(int serviceId);
}