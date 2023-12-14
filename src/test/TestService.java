package test;
import org.junit.Test;
import static org.junit.Assert.*;
import database.*;

import java.time.LocalDate;

public class TestService {

	    @Test
	    public void testFindAvailableServiceDates() {
	        ServiceDBIF serviceDBIF = new ServiceDB();  // Opret objekt af din kildeklasse (ServiceDao)
	        int serviceId = 1;  // Erstat med den faktiske serviceId, du vil teste

	        LocalDate result = serviceDBIF.findAvailableServiceDates(serviceId);

	        assertNotNull(result);
	        System.out.println("Test passed. Found available time: " + result);
	    }
	}


