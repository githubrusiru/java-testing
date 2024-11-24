import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseCatalog {
    private String catalogID;
    private List<Course> courses;

    public CourseCatalog(String catalogID) {
        this.catalogID = catalogID;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course getCourse(String courseID) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "CourseCatalog{" +
                "catalogID='" + catalogID + '\'' +
                ", courses=" + courses +
                '}';
    }
}
