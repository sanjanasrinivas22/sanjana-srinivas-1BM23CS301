import java.util.Scanner;

class Student_SGPA {

    String usn;
    String name;
    int n;
    int[] credits;
    int[] marks;

    public void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter USN:");
        usn = sc.next();
        System.out.println("Enter Name:");
        name = sc.next();
        System.out.println("Enter number of subjects:");
        n = sc.nextInt();
        credits = new int[n];
        marks = new int[n];
        System.out.println("Enter credits and marks for each subject:");
        for (int i = 0; i < n; i++) {
            System.out.print("Credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();
            System.out.print("Marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    public void display() {
        System.out.println("Student's details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Credits and marks of each subject are:");
        for (int i = 0; i < n; i++) {
            System.out.println("Subject " + (i + 1) + ": credits = " + credits[i] + ", marks = " + marks[i]);
        }
    }

    private int getGradePoint(int mark) {
        if (mark >= 90) {
            return 10;
        } else if (mark >= 80) {
            return 9;
        } else if (mark >= 70) {
            return 8;
        } else if (mark >= 60) {
            return 7;
        } else if (mark >= 50) {
            return 6;
        } else if (mark >= 40) {
            return 5;
        } else {
            return 0;
        }
    }

    public double calculateSGPA() {
        int totalCredits = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int gradePoint = getGradePoint(marks[i]);
            sum += gradePoint * credits[i];
            totalCredits += credits[i];
        }
        return (double) sum / totalCredits;
    }
}

class sgpamain {

    public static void main(String[] args) {
        Student_SGPA student = new Student_SGPA();
        student.acceptDetails();
        student.display();
        double SGPA = student.calculateSGPA();
        System.out.printf("SGPA = " + SGPA);
    }
}