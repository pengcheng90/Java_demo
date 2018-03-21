package net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;

public class Server_Demo {
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(9090);
        while (true) {
            java.net.Socket accept = serverSocket.accept();
            OutputStream outputStream = accept.getOutputStream();
            int i = 0;
            for (int j = 0; j < 255; j++) {
                    outputStream.write(j);
//                Thread.sleep(100L);
            }
        }
    }

}
