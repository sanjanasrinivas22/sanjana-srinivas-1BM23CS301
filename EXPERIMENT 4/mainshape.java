import java.util.Scanner;

abstract class shape {

     int d1;
    int d2;

    public shape(int d1, int d2) {
        this.d1 = d1;
        this.d2 = d2;

    }

    public abstract void printarea();
}

class rectangle extends shape {

    public rectangle(int width, int height) {
        super(width, height);
    }

    public void printarea() {
        int area = d1 * d2;
        System.out.println("area of rectangle:" + area);

    }
}

class triangle extends shape {

    public triangle(int base, int height) {
        super(base, height);
    }

    public void printarea() {
        double area = 0.5 * d1 * d2;
        System.out.println("area of triangle:" + area);

    }
}

class circle extends shape {

    public circle(int radius) {

        super( radius,0);
    }
    public void printarea() {
        double area = Math.PI * d1 * d1;
        System.out.println("area of circle:" + area);

    }
}
class mainshape {

    public static void main(String[] args) {
        shape rectangle = new rectangle(5, 10);
        shape triangle = new triangle(4, 5);
        shape circle = new circle(4);
        rectangle.printarea();
        triangle.printarea();
        circle.printarea();
    }
}
