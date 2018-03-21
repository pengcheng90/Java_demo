package net;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 多线程读，会有线程安全问题
 */

public class Socket_Demo {

//    public static void main(String[] args) throws IOException {
//        java.net.Socket socket = new java.net.Socket("192.168.1.27", 9090);
//        socket.setKeepAlive(true);
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    InputStream inputStream = socket.getInputStream();
//                    int i = -1;
//                    while ((i = inputStream.read()) != -1) {
//                        System.out.println("thread one:" + i);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    InputStream inputStream = socket.getInputStream();
//                    int i = -1;
//                    while ((i = inputStream.read()) != -1) {
//                        System.out.println("thread two" + i);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }

    @Test
    void test_sendHeart() throws IOException, InterruptedException {
        byte[] h = {(byte) 252, (byte) 253, (byte) 143, (byte) '\n'};

        Socket socket = new Socket("10.211.97.250", 8989);
        socket.setKeepAlive(true);
        OutputStream outputStream = socket.getOutputStream();
//        while (true) {
        outputStream.write(h);
        Thread.sleep(50 * 1000L);
//        }
    }

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, 2000);// 设定指定的时间time,此处为2000毫秒

        new Thread(new Runnable() {
            @Override
            public void run() {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        System.out.println("-------设定要指定任1务--------");
                    }
                }, 2000);// 设定指定的时间time,此处为2000毫秒

                while (true) {
                    System.out.println(123);
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
