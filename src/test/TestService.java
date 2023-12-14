package test;
import org.junit.Test;
import static org.junit.Assert.*;
import database.*;


import java.time.LocalDateTime;

public class TestService {

	    @Test
	    public void testFindAvailableServiceDates() {
	        ServiceDBIF serviceDB = new ServiceDB();  // Opret objekt af din kildeklasse (ServiceDao)
	        int serviceId = 1;  // Erstat med den faktiske serviceId, du vil teste

	        LocalDateTime result = serviceDB.findAvailableServiceDates(serviceId);

	        assertNotNull(result);
	        System.out.println("Test passed. Found available time: " + result);
	    }
	}


