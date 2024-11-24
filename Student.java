import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student {
    private String studentID;
    private String studentName;
    private List<Enrollment> enrolledCourses;

    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Enrollment> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enroll(Course course) {
        enrolledCourses.add(new Enrollment(this, course));
    }

    public void drop(Course course) {
        enrolledCourses.removeIf(enrollment -> enrollment.getCourse().equals(course));
    }

    public double calculateTotalFee() {
        // Simulating fee calculation
        Fee fee = new Fee("F1001", Map.of("CSE101", 100.0, "MTH101", 200.0), "Tuition Fee");
        return fee.calculateFee(enrolledCourses.stream().map(Enrollment::getCourse).toList());
    }

    public Timetable viewTimetable() {
        Timetable timetable = new Timetable();
        for (Enrollment enrollment : enrolledCourses) {
            timetable.addEntry(enrollment.getCourse().getSchedule());
        }
        return timetable;
    }

    public Timetable generateSchedule() {
        // Assuming generateSchedule and viewTimetable do the same thing
        return viewTimetable();
    }
}
