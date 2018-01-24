package lang.Thread.prio;

/**
 * 线程优先级测试，优先级不是绝对的，只是相对于其他线程得到cpu资源机会更大点
 * setPriority（）设置优先级，10，1，5三个常量，默认为5
 * getPriority（）获取当前线程的优先级
 */
public class Test {
    public static void main(String[] args) {
        Thread t0 = new ProiTestThread();
        Thread t1 = new ProiTestThread();
        Thread t2 = new ProiTestThread();

        t0.setPriority(10);
        t1.setPriority(1);
//        默认优先级
        t2.setPriority(5);

        t0.start();
        t1.start();
        t2.start();

    }
}
