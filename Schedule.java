import java.util.List;

public class Schedule {
    private String scheduleID;
    private List<String> days;
    private String startTime;
    private String endTime;

    public Schedule(String scheduleID, List<String> days, String startTime, String endTime) {
        this.scheduleID = scheduleID;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public List<String> getDays() {
        return days;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Schedule " + "scheduleID=" + scheduleID + '\'' +", days=" + days +", startTime=" + startTime + '\'' +", endTime=" + endTime + '\'' +'}';
    }
}
