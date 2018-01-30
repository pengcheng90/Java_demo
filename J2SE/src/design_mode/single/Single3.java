package design_mode.single;


/**
 * 单例模式3：内部类方式
 * <p>
 * 优点：延迟加载，线程安全（java中class加载时互斥的），也减少了内存消耗，推荐使用内部类方式
 *
 * 原因：
 * 因为在多线程环境下，jvm对一个类的初始化会做限制，同一时间只会允许一个线程去初始化一个类，这样就从虚拟机层面避免了大部分单例实现的问题
 */
public class Single3 {
    private static class LazyStyle {
        private static final Single3 INSTANCE = new Single3();
    }

    private Single3() {
    }

    public static final Single3 getInstance() {
        return LazyStyle.INSTANCE;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Single3 instance = getInstance();
                    System.out.println(instance);
                }
            }).start();
        }
    }
}
