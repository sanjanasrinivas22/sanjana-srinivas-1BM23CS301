package SEE;

import CIE.Student;
import CIE.Internals;

public class External extends Student {
    int[] externalMarks = new int[5]; // Array to store external marks for 5 courses

    public External(String usn, String name, int sem, int[] externalMarks) {
        super(usn, name, sem); // Call parent class constructor
        this.externalMarks = externalMarks;
    }

    public int[] getExternalMarks() {
        return externalMarks;
    }

    public void displayExternalMarks() {
        System.out.print("External Marks: ");
        for (int mark : externalMarks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public void displayFinalMarks(Internals internals) {
        System.out.print("Final Marks: ");
        for (int i = 0; i < 5; i++) {
            int finalMark = internals.getInternalMarks()[i] + externalMarks[i]; // Calculate final marks
            System.out.print(finalMark + " ");
        }
        System.out.println();
    }
}
