package lang.Thread;

public class Test1 {
    public static void main(String[] args) {
        //第一种方式创建线程
      /*  Thread t1=new ThreadDemo1();
        t1.start();//不能通过t1.run()方式启动线程，通过start方式启动，jvm会去调用run线程体
        Thread t2=new ThreadDemo1();
        t2.start();  */

        //第二种方式创建线程
        Thread tr1 = new Thread(new ThreadDemo2());
        tr1.start();//不能通过t1.run()方式启动线程，通过start方式启动，jvm会去调用run线程体
        Thread tr2 = new Thread(new ThreadDemo2());
        tr2.start();
    }
}
