import java.util.ArrayList;
import java.util.List;

public class Timetable {
    private List<Schedule> entries;

    public Timetable() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(Schedule schedule) {
        entries.add(schedule);
    }

    public List<Schedule> getEntries() {
        return entries;
    }

    @Override
    public String toString() {
        StringBuilder timetable = new StringBuilder();
        for (Schedule schedule : entries) {
            timetable.append(schedule.toString()).append("\n");
        }
        return timetable.toString();
    }
}
