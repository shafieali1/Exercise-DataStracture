import java.util.Date;

class Loan {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    // No-argument constructor
    public Loan() {
        annualInterestRate = 2.5;
        numberOfYears = 1;
        loanAmount = 1000;

    }

    // Constructor with arguments
    public Loan(double annualInterestRate, int numberOfYears,
                double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date();
    }

    // Getters
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public java.util.Date getLoanDate(){
        return loanDate;
    }

    // Setters
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // Monthly payment
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;

        return loanAmount * monthlyInterestRate /
                (1 - 1 / Math.pow(1 + monthlyInterestRate,
                        numberOfYears * 12));
    }

    // Total payment
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }
}




class BMI {

    private String name;
    private int age;
    private double weight;
    private double height;

    // Constructor with name, age, weight, and height
    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    // Constructor with name, weight, and height
    // Default age = 20
    public BMI(String name, double weight, double height) {
        this.name = name;
        this.age = 20;
        this.weight = weight;
        this.height = height;
    }

    // Get BMI
    public double getBMI() {
        return weight * 703 / (height * height);
    }

    // Get BMI status
    public String getStatus() {
        double bmi = getBMI();

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}





class Course {

    private String courseName;
    private String[] students;
    private int numberOfStudents;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        students = new String[100];
        numberOfStudents = 0;
    }

    // Get course name
    public String getCourseName() {
        return courseName;
    }

    // Add a student
    public void addStudent(String student) {

        // If array is full, create a larger array
        if (numberOfStudents >= students.length) {
            String[] newStudents = new String[students.length * 2];

            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
            }

            students = newStudents;
        }

        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    // Drop a student
    public void dropStudent(String student) {

        for (int i = 0; i < numberOfStudents; i++) {

            if (students[i].equals(student)) {

                // Shift remaining students to the left
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[numberOfStudents - 1] = null;
                numberOfStudents--;

                break;
            }
        }
    }

    // Get students
    public String[] getStudents() {
        return students;
    }

    // Get number of students
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}

// main test











public class Test {


    public static void main(String[] args) {

        // =========================
        // Exercise 2.0 - Loan
        // =========================
        System.out.println("===== LOAN =====");

        Loan loan = new Loan(5.0, 5, 50000);

        System.out.println("Annual Interest Rate: "
                + loan.getAnnualInterestRate());

        System.out.println("Number of Years: "
                + loan.getNumberOfYears());

        System.out.println("Loan Amount: "
                + loan.getLoanAmount());
        System.out.println("Loan Date = " + loan.getLoanDate());

        System.out.println("Monthly Payment: "
                + loan.getMonthlyPayment());

        System.out.println("Total Payment: "
                + loan.getTotalPayment());


        // =========================
        // Exercise 2.1 - BMI
        // =========================
        System.out.println("\n===== BMI =====");

        BMI bmi = new BMI("Mohamed", 25, 160, 70);

        System.out.println("Name: " + bmi.getName());
        System.out.println("Age: " + bmi.getAge());
        System.out.println("Weight: " + bmi.getWeight());
        System.out.println("Height: " + bmi.getHeight());
        System.out.println("BMI: " + bmi.getBMI());
        System.out.println("Status: " + bmi.getStatus());


        // =========================
        // Exercise 2.2 - Course
        // =========================
        System.out.println("\n===== COURSE =====");

        Course course = new Course("Java Programming");

        course.addStudent("Mohamed");
        course.addStudent("Ahmed");
        course.addStudent("Ali");

        System.out.println("Course Name: "
                + course.getCourseName());

        System.out.println("Number of Students: "
                + course.getNumberOfStudents());

        System.out.println("Students:");

        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.println(course.getStudents()[i]);
        }

        course.dropStudent("Ahmed");

        System.out.println("\nAfter dropping Ahmed:");

        System.out.println("Number of Students: "
                + course.getNumberOfStudents());

        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.println(course.getStudents()[i]);
        }
    }
}