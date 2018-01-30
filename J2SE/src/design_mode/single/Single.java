package design_mode.single;

import org.junit.jupiter.api.Test;

/**
 * 单例模式：保证一个类仅有一个实例，并提供一个访问的全局访问点
 * <p>
 * 1.懒汉式
 * <p>
 * 优点：延迟加载（需要的时候才床架对象），适合单线程操作
 * 缺点：线程不安全，在多线程中很容易出现不同步的情况，如在数据库对象进行频繁的读写操作对象
 */
public class Single {
    private static Single single = null;

    /**
     * 私有化构造函数：防止通过该方式创建对象
     */
    private Single() {

    }

    public static Single getInstance() {
        if (single == null) return new Single();
        else return single;
    }

    @Test
    void test() throws InterruptedException {
        while (true) {    //多线程不同步
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Single instance = getInstance();
                    System.out.println(instance);
                }
            });
            thread.start();
            Thread.sleep(2 * 1000L);
        }
    }

}
