package lang.Thread.daemon;

/**
 * 守护进程测试：设置为守护进程的线程，随着主线程的结束而结束
 * setDaemon（true）设置为守护进程
 */
public class Test {
    public static void main(String[] args) {
        Thread t0 = new DaemonThread();
        Thread t1 = new DaemonThread();

        t0.setDaemon(true);
        t1.setDaemon(true);

        t0.start();
        t1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " Thread:" + i);
        }
    }
}
