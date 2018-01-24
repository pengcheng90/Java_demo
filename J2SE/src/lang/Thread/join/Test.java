package lang.Thread.join;

/**
 * 加入线程：首先启动要join的线程，然后调用join（）方法，该线程会独占cpu资源直到该线程结束
 */
public class Test {
    public static void main(String[] args) {
        Thread t0 = new JoinThread();
        Thread t1 = new JoinThread();
        Thread t2 = new JoinThread();

        t2.start();//首先启动
        try {
            t2.join();//加入线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t0.start();
        t1.start();

    }
}
