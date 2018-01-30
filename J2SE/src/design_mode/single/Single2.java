package design_mode.single;

import org.junit.jupiter.api.Test;

/**
 * 单例模式2：双重检查
 * 优点：延迟加载，线程安全
 * 缺点：写法复杂
 */
public class Single2 {
    private static Single2 single2 = null;

    /**
     * 私有化构造器
     */
    private Single2() {
    }

    public static Single2 getInstance() {
        if (single2 == null) {
            synchronized (Single2.class) {
                if (single2 == null) single2 = new Single2();
            }
        }
        return single2;
    }

    @Test
    void test() {
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Single2 instance = getInstance();
                    System.out.println(instance);
                }
            });
            thread.start();
        }
    }
}
