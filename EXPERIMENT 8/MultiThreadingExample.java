class DisplayMessage extends Thread {
    private String message;
    private int interval;

    public DisplayMessage(String message, int interval) {
        this.message = message;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(message);
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + message);
        }
    }
}

public class MultiThreadingExample {
    public static void main(String[] args) {
        DisplayMessage thread1 = new DisplayMessage("BMS College of Engineering", 10000);
        DisplayMessage thread2 = new DisplayMessage("CSE", 2000);

        thread1.start();
        thread2.start();
    }
}
