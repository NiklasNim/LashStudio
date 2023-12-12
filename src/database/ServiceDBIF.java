package database;

import java.util.List;
import model.Service;

public interface ServiceDBIF {

	List<Service> findAllServices();

	void createService(Service newService);

}
