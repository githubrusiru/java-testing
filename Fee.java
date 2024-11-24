import java.util.List;
import java.util.Map;

public class Fee {
    private String feeID;
    private Map<String, Double> courseFees;
    private String feeDescription;

    public Fee(String feeID, Map<String, Double> courseFees, String feeDescription) {
        this.feeID = feeID;
        this.courseFees = courseFees;
        this.feeDescription = feeDescription;
    }

    // Getters and setters

    public String getFeeID() {
        return feeID;
    }

    public void setFeeID(String feeID) {
        this.feeID = feeID;
    }

    public Map<String, Double> getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(Map<String, Double> courseFees) {
        this.courseFees = courseFees;
    }

    public String getFeeDescription() {
        return feeDescription;
    }

    public void setFeeDescription(String feeDescription) {
        this.feeDescription = feeDescription;
    }

    // Method to calculate total fee based on enrolled courses
    public double calculateFee(List<Course> enrolledCourses) {
        double totalFee = 100;
        for (Course course : enrolledCourses) {
            String courseID = course.getCourseID();
            if (courseFees.containsKey(courseID)) {
                totalFee += courseFees.get(courseID);
            }
        }
        return totalFee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fee{");
        sb.append("feeID='").append(feeID).append('\'');
        sb.append(", feeDescription='").append(feeDescription).append('\'');
        sb.append(", courseFees=");
        courseFees.forEach((courseID, fee) -> sb.append("Course ID: ").append(courseID).append(", Fee: $").append(fee).append("; "));
        sb.append('}');
        return sb.toString();
    }
}
