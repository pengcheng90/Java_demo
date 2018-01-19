package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTcp {
    //    public static void main(String[] args) {
//
//        try {
//            Socket socket = new Socket("192.168.1.39", 8989);
//            OutputStream outputStream = socket.getOutputStream();
//            while (true){
//                for (int i=0;i<256;i++){
//                    outputStream.write((byte)i);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {
        ServerSocket server;
        Socket socket1 = null;
        try {
            server = new ServerSocket( 8080);
            socket1=server.accept();

//            InputStream inputStream = socket1.getInputStream();
//            int i=-1;
//            while ((i=inputStream.read())!=-1){
//                System.out.println(i);
//            }
            socket1.getOutputStream().write("asdasd".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("run---");
        }
    }
}
