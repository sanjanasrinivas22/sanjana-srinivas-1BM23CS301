import CIE.Internals;
import SEE.External;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking input for number of students
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        External[] students = new External[n];

        // Loop to input details for each student
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1));

            System.out.print("Enter USN: ");
            String usn = scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Semester: ");
            int sem = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter internal marks for 5 courses: ");
            int[] internalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                internalMarks[j] = scanner.nextInt();
            }
            Internals internals = new Internals(internalMarks);

            System.out.println("Enter external marks for 5 courses: ");
            int[] externalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                externalMarks[j] = scanner.nextInt();
            }
            External student = new External(usn, name, sem, externalMarks);

            // Display student details, internal, external, and final marks
            student.displayStudentDetails();
            internals.displayInternalMarks();
            student.displayExternalMarks();
            student.displayFinalMarks(internals);
        }
        scanner.close();
    }
}
