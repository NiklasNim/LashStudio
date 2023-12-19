package controller;
import model.Schedule;
import database.ScheduleDB;
import database.ScheduleDBIF;
import java.util.List;

public class ScheduleController {
    private ScheduleDBIF scheduleDB;
    
    // Konstruktør til at initialisere ScheduleDBIF implementeringen 
    public ScheduleController() {
        this.scheduleDB = new ScheduleDB();
    }
    
    // Henter alle de tilgængelige tider fra databasen
    public List<Schedule> getAllAvailableSchedules() {
        return scheduleDB.getAllAvailableSchedules();
    }
}