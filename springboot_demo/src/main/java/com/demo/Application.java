package com.demo;

import com.demo.controller.BaseController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import util.AnnotationUtil;
import util.ClassUtil;

import java.util.List;

@SpringBootApplication
//mapper接口类扫描包配置
@MapperScan("com/demo/dao")
@ServletComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        //启动
//        application.addListeners(new AppStartedEventListener());
        application.run(args);

        List<Class<?>> clsList = ClassUtil.getAllClassByPackageName(BaseController.class.getPackage());
//        List<Class<?>> clsList = ClassUtil.getAllClassByPackageName(Package.getPackage("com.demo.controller"));
        //输出所有使用了特定注解的类的注解值
        AnnotationUtil.validAnnotation(clsList);
    }
}
