import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseCatalog catalog = createCourseCatalog(); // Create course catalog
        Student student = loginAndGetStudent(scanner); // Login or register a student

        if (student == null) {
            System.out.println("Failed to login or register. Exiting...");
            return;
        }

        int choice;
        do {
            displayMenu(); // Display menu options
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    displayCourseCatalog(catalog);
                    break;
                case 2:
                    enrollStudent(scanner, student, catalog);
                    break;
                case 3:
                    dropCourse(scanner, student, catalog);
                    break;
                case 4:
                    managePayment(scanner, student);
                    break;
                case 5:
                    viewTimetable(student);
                    break;
                case 6:
                    calculateFee(student);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                    break;
            }
        } while (choice != 7);
    }

    // Function to create a course catalog with sample courses
    private static CourseCatalog createCourseCatalog() {
        CourseCatalog catalog = new CourseCatalog("CAT1001");
        Schedule schedule1 = new Schedule("SCH1001", Arrays.asList("Mon", "Wed", "Fri"), "9:00", "10:00");
        Schedule schedule2 = new Schedule("SCH1002", Arrays.asList("Tue", "Thu"), "10:00", "11:30");

        // Create course fees map
        Map<String, Double> courseFees1 = new HashMap<>();
        courseFees1.put("CSE101", 200.0);

        Map<String, Double> courseFees2 = new HashMap<>();
        courseFees2.put("MTH101", 300.0);

        // Add courses with updated fees
        Course course1 = new Course("CSE101", "Introduction to Programming", 3, "Basic programming concepts", schedule1);
        course1.setFee(new Fee("F1001", courseFees1, "Tuition Fee"));

        Course course2 = new Course("MTH101", "Calculus I", 4, "Differential and Integral Calculus", schedule2);
        course2.setFee(new Fee("F1002", courseFees2, "Tuition Fee"));

        catalog.addCourse(course1);
        catalog.addCourse(course2);

        return catalog;
    }

    // Function to handle student login or registration
    private static Student loginAndGetStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        // Simulate database lookup or registration
        Student student = new Student(studentID, studentName);
        System.out.println("Welcome, " + student.getStudentName() + "!");

        return student;
    }

    // Function to display the menu options
    private static void displayMenu() {
        System.out.println("\nMENU:");
        System.out.println("1. Browse Course Catalog");
        System.out.println("2. Enroll in a Course");
        System.out.println("3. Drop a Course");
        System.out.println("4. Manage Payment");
        System.out.println("5. View Timetable");
        System.out.println("6. Calculate Fee");
        System.out.println("7. Exit");
    }

    // Function to display the course catalog
    private static void displayCourseCatalog(CourseCatalog catalog) {
        System.out.println("\nCourse Catalog:");
        for (Course course : catalog.getCourses()) {
            System.out.println(course);
        }
    }

    // Function to enroll a student in a course
    private static void enrollStudent(Scanner scanner, Student student, CourseCatalog catalog) {
        System.out.print("Enter course ID to enroll: ");
        String enrollCourseID = scanner.nextLine();
        Course enrollCourse = catalog.getCourse(enrollCourseID);
        if (enrollCourse != null) {
            student.enroll(enrollCourse);
            System.out.println("Enrolled in course: " + enrollCourse.getCourseName());
        } else {
            System.out.println("Course not found.");
        }
    }

    // Function to drop a course
    private static void dropCourse(Scanner scanner, Student student, CourseCatalog catalog) {
        System.out.print("Enter course ID to drop: ");
        String dropCourseID = scanner.nextLine();
        Course dropCourse = catalog.getCourse(dropCourseID);
        if (dropCourse != null) {
            student.drop(dropCourse);
            System.out.println("Dropped course: " + dropCourse.getCourseName());
        } else {
            System.out.println("Course not found.");
        }
    }

    // Function to manage payment
    private static void managePayment(Scanner scanner, Student student) {
        double totalFee = student.calculateTotalFee();
        System.out.println("Total fee: $" + totalFee);
        System.out.print("Proceed with payment? (y/n): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            Payment payment = new Payment("P1001", totalFee, new Date(), student);
            payment.processPayment(totalFee);
            System.out.println(payment.getPaymentDetails());
        } else {
            System.out.println("Payment cancelled.");
        }
    }

    // Function to view timetable
    private static void viewTimetable(Student student) {
        Timetable timetable = student.viewTimetable();
        System.out.println("\nTimetable:");
        for (Schedule schedule : timetable.getEntries()) {
            System.out.println("Course: " + schedule.getScheduleID() + ", Days: " + schedule.getDays() + ", Time: " + schedule.getStartTime() + " - " + schedule.getEndTime());
        }
    }

    // Function to calculate fee
    private static void calculateFee(Student student) {
        double totalFee = student.calculateTotalFee();
        System.out.println("Total fee: $" + totalFee);
    }
}
