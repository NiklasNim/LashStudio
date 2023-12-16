package controller;

import model.Schedule;
import database.ScheduleDB;
import java.util.List;

public class ScheduleController {
    private ScheduleDB scheduleDB;

    public ScheduleController() {
        this.scheduleDB = new ScheduleDB();
    }

    public List<Schedule> getAllAvailableSchedules() {
        return scheduleDB.getAllAvailableSchedules();
    }
}