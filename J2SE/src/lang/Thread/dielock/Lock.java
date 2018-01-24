package lang.Thread.dielock;

public class Lock {
    //不加public，默认为default,在同一包下访问
    static Object lock1 = new Object();
    static Object lock2 = new Object();

}
