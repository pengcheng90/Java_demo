package lang.Thread.prio;

public class ProiTestThread extends Thread {
    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 50; i++) {
            System.out.println(getName()+":"+i);
        }
    }
}
