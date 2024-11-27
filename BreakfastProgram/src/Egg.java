class Egg extends Breakfast {
    @Override
    public void run() {
        cookEggs();
    }

    public void cookEggs() {
        try{
            System.out.println("Cooking eggs...");
            Thread.sleep( 1000);
            System.out.println("Eggs cooked.");
            Thread.sleep( 1000);
        }
        catch (InterruptedException e) {
            cookEggs();
        }
    }
}