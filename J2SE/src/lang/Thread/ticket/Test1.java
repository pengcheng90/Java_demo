package lang.Thread.ticket;

public class Test1 {
    public static void main(String[] args) {
        /**
         * 方式一：通过继承Thread方式
         */
//        Ticket_Thread tc1 = new Ticket_Thread();
//        Ticket_Thread tc2 = new Ticket_Thread();
//        Ticket_Thread tc3 = new Ticket_Thread();
//        Ticket_Thread tc4 = new Ticket_Thread();

        /**
         * 方式二：通过实现Runnable方式，共用对象，锁住共用的对象
         */
        Ticket_Thread2 thread2 = new Ticket_Thread2();
        Thread tc1 = new Thread(thread2);
        Thread tc2 = new Thread(thread2);
        Thread tc3 = new Thread(thread2);
        Thread tc4 = new Thread(thread2);

        tc1.start();
        tc2.start();
        tc3.start();
        tc4.start();
    }
}
