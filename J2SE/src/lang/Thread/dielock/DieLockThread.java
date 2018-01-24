package lang.Thread.dielock;


public class DieLockThread implements Runnable {

    private boolean flag;

    public DieLockThread(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (Lock.lock1) {
                System.out.println(Thread.currentThread().getName() + ":获取第一把锁");
                synchronized (Lock.lock2) {
                    System.out.println(Thread.currentThread().getName() + ":获取第二把锁");
                }
            }
        } else {
            synchronized (Lock.lock2) {
                System.out.println(Thread.currentThread().getName()+":获取第二把锁");
                synchronized (Lock.lock1){
                    System.out.println(Thread.currentThread().getName()+":获取第一把锁");
                }
            }
        }
    }
}
