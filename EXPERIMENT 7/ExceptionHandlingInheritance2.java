import java.util.Scanner;
class WrongAgeException extends Exception {
    public WrongAgeException(int age) {
        System.out.println("Exception: Age cannot be negative. Invalid age: " + age);
    }
}
class InvalidSonAgeException extends Exception {
    public InvalidSonAgeException(int fatherAge, int sonAge) {
        System.out.println("Exception: Son's age (" + sonAge + ") cannot be greater than or equal to father's age (" + fatherAge + ").");
    }
}
class Father {
    int fatherAge;

    public Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException(age);
        }
        this.fatherAge = age;
    }
}
class Son extends Father {
    int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAgeException, InvalidSonAgeException {
        super(fatherAge);
        if (sonAge < 0) {
            throw new WrongAgeException(sonAge);
        }
        if (sonAge >= fatherAge) {
            throw new InvalidSonAgeException(fatherAge, sonAge);
        }
        this.sonAge = sonAge;
    }

    public void displayAges() {
        System.out.println("Father's Age: " + fatherAge);
        System.out.println("Son's Age: " + sonAge);
    }
}
public class ExceptionHandlingInheritance2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Father's Age: ");
            int fatherAge = scanner.nextInt();

            System.out.print("Enter Son's Age: ");
            int sonAge = scanner.nextInt();

            Son son = new Son(fatherAge, sonAge);
            son.displayAges();

        } catch (WrongAgeException | InvalidSonAgeException e) {
            
        } finally {
            scanner.close();
        }
    }
}
