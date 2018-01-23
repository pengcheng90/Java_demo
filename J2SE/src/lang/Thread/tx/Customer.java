package lang.Thread.tx;

public class Customer implements Runnable {
    private Fruit fruit;

    public Customer(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (fruit) {
                if (!fruit.isExist()) {
                    try {
                        fruit.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                fruit.setExist(false);
                fruit.notify();
                System.out.println("水果被购买了。。");
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
