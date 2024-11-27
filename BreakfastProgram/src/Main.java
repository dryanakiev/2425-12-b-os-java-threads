public class Main {
    public static void main(String[] args) {
        Thread.currentThread().setName("Main thread");

        Coffee coffee = new Coffee();
        Egg egg = new Egg();
        Bacon bacon = new Bacon();

        try {
            coffee.start();
            coffee.join();
            egg.start();
            egg.join();
            bacon.start();
            bacon.join();
        }
        catch (InterruptedException ignored) {}
    }
}