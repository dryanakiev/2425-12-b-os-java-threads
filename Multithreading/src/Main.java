class Something extends Thread {
    private int quantity;

    @Override
    public void run() {
        doWork();
    }

    public Something(int quantity) {
        this.quantity = quantity;
    }

    public void doWork() {
        System.out.println(Thread.currentThread().getName()+": Starting work");

        for (int i = 0; i < quantity; i++) {
            System.out.println(Thread.currentThread().getName()+": Working...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(Thread.currentThread().getName()+": Finished work");
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new Something(3));
        Thread threadTwo = new Thread(new Something(2));
        Thread threadThree = new Thread(new Something(6));

        threadOne.setName("Thread One");
        threadTwo.setName("Thread Two");
        threadThree.setName("Thread Three");


        try {
            threadOne.start();
            threadOne.setPriority(Thread.MAX_PRIORITY);

            threadTwo.start();
            threadTwo.setPriority(Thread.NORM_PRIORITY);
            threadTwo.join();

            threadThree.start();
            threadThree.setPriority(Thread.MIN_PRIORITY);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}