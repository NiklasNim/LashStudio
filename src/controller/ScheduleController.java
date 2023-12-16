package controller;
import model.Schedule;
import database.ScheduleDB;
import database.ScheduleDBIF;
import java.util.List;

public class ScheduleController {
    private ScheduleDBIF scheduleDB;

    public ScheduleController() {
        this.scheduleDB = new ScheduleDB();
    }

    public List<Schedule> getAllAvailableSchedules() {
        return scheduleDB.getAllAvailableSchedules();
    }
}