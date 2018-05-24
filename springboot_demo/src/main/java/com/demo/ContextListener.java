package com.demo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpGet httpGet = new HttpGet("http://127.0.0.1:8081/swagger/user");
                try {
                    CloseableHttpResponse response = httpClient.execute(httpGet);
                    if (response.getStatusLine().getStatusCode() == 200) {
                        System.out.println("请求成功！");
                    }
                    System.out.println(response.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}