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
                System.out.println(fruit.getName()+"被购买了。。");
                fruit.notify();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
