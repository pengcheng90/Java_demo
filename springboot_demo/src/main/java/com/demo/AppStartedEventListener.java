//package com.demo;
//
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//
//import java.io.IOException;
//
//public class AppStartedEventListener implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        ApplicationContext applicationContext = event.getApplicationContext();
//        if (applicationContext != null) {
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            HttpGet httpGet = new HttpGet("http://127.0.0.1:8081/swagger/user");
//            try {
//                CloseableHttpResponse response = httpClient.execute(httpGet);
//                if (response.getStatusLine().getStatusCode() == 200) {
//                    System.out.println("请求成功！");
//                }
//                System.out.println(response.toString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//}
