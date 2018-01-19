package lang.Thread.ticket;

/**
 * 案例：卖火车票
 */
public class Ticket_Thread extends Thread {
    private static int count_ticket = 100;//static多个对象共享，属于类的变量
    private static Object object = new Object();//同步锁（同步钥匙）对象，
    // 同步代码块的锁对象可以是任意类对象（线程的实现方式是继承于Thread），这个对象必须是共享的（静态的）

    public Ticket_Thread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (object) { //加同步锁的方式解决线程安全问题（资源共享问题）
            while (count_ticket > 0) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "正在卖" + count_ticket-- + "张火车票");
            }
        }
        System.out.println("票已售完");
    }
}
