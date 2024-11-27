class Bacon extends Breakfast {
    @Override
    public void run() {
        cookBacon();
    }

    public void cookBacon() {
        try{
            System.out.println("Cooking bacon...");
            Thread.sleep( 1000);
            System.out.println("Bacon cooked.");
            Thread.sleep( 1000);
        }
        catch (InterruptedException e) {
            cookBacon();
        }
    }
}