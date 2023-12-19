package database;
import java.time.LocalDateTime;
import java.util.List;
import model.Service;

public interface ServiceDBIF {
	//Metode til at finde en service baseret på serviceId i databasen
	Service findServiceById(int serviceId);
	
	// Metode til at finde ledige tider for en service på serviceId i databasen
	LocalDateTime findAvailableServiceDates(int serviceId);
	
	// Metode til at hente alle services fra databasen
	List<Service> getAllServices();
}