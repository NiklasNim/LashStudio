package database;
import java.sql.SQLException;
import java.util.*;
import model.*;

public interface ScheduleDBIF {
	
    List<Schedule> getAllAvailableSchedules();

    Schedule findScheduleById(int scheduleId);

    void markScheduleAsBooked(Schedule schedule);

}
