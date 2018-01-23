package lang.Thread.tx;

/**
 * 线程间通讯：通过Object的wait（）等待，和notify（）唤醒实现线程间通讯
 */
public class Client {
    public static void main(String[] args) {

        Fruit fruit = new Fruit("Apple", false);

        Product p = new Product(fruit);
        Customer c = new Customer(fruit);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();
    }
}
