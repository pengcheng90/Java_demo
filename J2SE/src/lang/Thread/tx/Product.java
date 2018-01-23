package lang.Thread.tx;

public class Product implements Runnable {
    private Fruit fruit;

    public Product(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (fruit) {
                if (fruit.isExist()) {
                    try {
                        //wait()是Object的方法，sleep（）是Thread的方法，wait（）会释放锁，而sleep（）不会
                        fruit.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("水果被生产了。。");
                fruit.setExist(true);
                fruit.notify();//唤醒
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
