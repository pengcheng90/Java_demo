package lang.Thread.yield;

public class YieldThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + ":" + i);
            Thread.yield();//运行一次，让出cpu
        }
    }
}
