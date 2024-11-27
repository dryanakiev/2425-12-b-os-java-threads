class Coffee extends Breakfast {
    @Override
    public void run() {
        pourCoffee();
    }

    public void pourCoffee() {
        try {
            System.out.println("Pouring coffee...");
            Thread.sleep(1000);
            System.out.println("Coffee poured.");
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            pourCoffee();
        }

    }
}