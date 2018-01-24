package lang.Thread.dielock;

/**
 * 线程死锁：当线程1拿到锁1后想要继续拿到锁2，线程2已拿到锁2想要拿到锁1，两个线程相互等待，导致死锁
 * <p>
 * 产生死锁的两种情况：
 * 当两个线程相互调用Thread.join();
 * 当两个线程使用嵌套的同步块时，一个线程占用了另一个线程的必需的锁，互相等待时被阻塞，就有可能出现死锁。
 */
public class Test {
    public static void main(String[] args) {

        Thread t0 = new Thread(new DieLockThread(true));
        Thread t1 = new Thread(new DieLockThread(false));

        t0.start();

        t1.start();
    }
}
