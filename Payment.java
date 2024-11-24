import java.util.Date;

public class Payment {
    private String paymentID;
    private double amount;
    private Date paymentDate;
    private Student student;

    public Payment(String paymentID, double amount, Date paymentDate, Student student) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.student = student;
    }

    public void processPayment(double amount) {
        // Simulate payment processing
        System.out.println("Payment of $" + amount + " processed for student " + student.getStudentID());
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Student getStudent() {
        return student;
    }

    public String getPaymentDetails() {
        return "Payment ID: " + paymentID + ", Amount: $" + amount + ", Payment Date: " + paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", student=" + student.getStudentID() +
                '}';
    }
}
