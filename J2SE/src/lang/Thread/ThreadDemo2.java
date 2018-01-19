package lang.Thread;

/**
 * 多线程方式2：实现Runnable接口
 * 作用：java是单继承的，如果一个类已经继承其他类（非Thread），想要实现多线程，可以使用实现Runable接口方式。
 */
public class ThreadDemo2 implements Runnable {
    @Override
    public void run() {
        for (int i = 50; i < 100; i++) {
            System.out.println(Thread.currentThread() + ":" + i);
        }
    }
}
