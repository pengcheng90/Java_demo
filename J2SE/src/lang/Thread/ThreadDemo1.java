package lang.Thread;

/**
 * 多线程方式1：继承thread
 */
public class ThreadDemo1 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<50;i++){
            System.out.println(getName()+":"+i);
        }
    }
}
