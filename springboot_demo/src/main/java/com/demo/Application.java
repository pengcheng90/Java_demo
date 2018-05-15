package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//mapper接口类扫描包配置
@MapperScan("com/demo/dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        //启动
        application.addListeners(new AppStartedEventListener());
        application.run(args);
    }
}
