package lang.Thread.ticket;

public class Ticket_Thread2 implements Runnable {
    private int count_ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count_ticket > 0) {
                if (count_ticket % 2 == 0) {
                    synchronized (this) {//锁住的是当前对象
                        System.out.println(Thread.currentThread().getName() + "正在卖" + count_ticket-- + "张火车票");
                    }
                } else {
                    sale_ticket();
                }
            } else {
                System.out.println("票已售完");
                break;
            }
        }
    }


    private synchronized void sale_ticket() {    //锁住的是当前对象
        System.out.println(Thread.currentThread().getName() + "正在卖" + count_ticket-- + "张火车票");
    }
}
