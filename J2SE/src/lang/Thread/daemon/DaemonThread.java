package lang.Thread.daemon;

public class DaemonThread  extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i=0;i<50;i++){
            System.out.println(getName()+":"+i);
            Thread.yield();
        }
    }
}
