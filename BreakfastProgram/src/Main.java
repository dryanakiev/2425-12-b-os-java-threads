class Something extends Thread {
    public void run() {
        Thread.currentThread().setName("Something thread");

        while (true){
            System.out.println("Doing work...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread.currentThread().setName("Main thread");

        Something somethingObject = new Something();

        // Daemon property interrupts something thread
        somethingObject.setDaemon(true);
        somethingObject.start();
    }
}