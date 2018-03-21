package lang.Thread.test;

import java.util.Vector;

public class Data {
    public static void main(String[] args) {
        Vector<String> vector=new Vector<>();
        vector.add("a");
        vector.add("b");

        new Data().thread_method(vector);

    }
    private  void thread_method(Vector<String> vector){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (String s:vector){
                    System.out.println(s);
                }
            }
        }).start();
    }
}
