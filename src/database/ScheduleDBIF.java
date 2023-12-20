package database;
import java.util.*;
import model.*;

public interface ScheduleDBIF {
	// Metode til at hente ledige tider 
    List<Schedule> getAllAvailableSchedules();
    
    // Metode til at finde en tidsplan baseret på scheduleId
    Schedule findScheduleById(int scheduleId);
    
}