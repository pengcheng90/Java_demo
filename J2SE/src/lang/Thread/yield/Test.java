package lang.Thread.yield;

/**
 * 等待线程，回到就绪状态，有抢占cpu的能力，有可能继续抢到cpu
 * Thread的yield（）静态方法，让出cpu
 */
public class Test {
    public static void main(String[] args) {
        Thread t0=new YieldThread();
        Thread t1=new YieldThread();
        Thread t2=new YieldThread();

        t0.start();
        t1.start();
        t2.start();
    }
}
