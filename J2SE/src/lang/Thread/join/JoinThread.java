package lang.Thread.join;

public class JoinThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i=0;i<50;i++){
            System.out.println(getName()+":"+i);
        }
    }
}
