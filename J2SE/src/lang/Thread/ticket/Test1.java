package lang.Thread.ticket;

public class Test1 {
    public static void main(String[] args) {
        Ticket_Thread tc1 = new Ticket_Thread("窗口1");
        Ticket_Thread tc2 = new Ticket_Thread("窗口2");
        Ticket_Thread tc3 = new Ticket_Thread("窗口3");
        Ticket_Thread tc4 = new Ticket_Thread("窗口4");

        tc1.start();
        tc2.start();
        tc3.start();
        tc4.start();
    }
}
