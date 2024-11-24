public class Course {
    private String courseID;
    private String courseName;
    private int credits;
    private String description;
    private Schedule schedule;
    private Fee fee;

    public Course(String courseID, String courseName, int credits, String description, Schedule schedule) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.description = description;
        this.schedule = schedule;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public String getDescription() {
        return description;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseID + "\n" +
                "Course Name: " + courseName + "\n" +
                "Credits: " + credits + "\n" +
                "Description: " + description + "\n" +
                "Schedule: " + schedule + "\n" +
                "Fee: " + fee;
    }
}
