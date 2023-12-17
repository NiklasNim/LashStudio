package model;

import java.sql.Timestamp;

public class Schedule {
    private int scheduleId;
    private Timestamp startTime;
    private Timestamp endTime;
    private int employeeId_FK;
    private boolean isBooked;

    public Schedule(int scheduleId, Timestamp startTime, Timestamp endTime, int employeeId_FK) {
        this.scheduleId = scheduleId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.employeeId_FK = employeeId_FK;
    }

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public int getEmployeeId_FK() {
		return employeeId_FK;
	}

	public void setEmployeeId_FK(int employeeId_FK) {
		this.employeeId_FK = employeeId_FK;
	}
	
	public boolean isBooked() {
		return isBooked;
	}
	
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	
	@Override
	public String toString() {
        return getStartTime() + " - " + getEndTime();
    }

}
