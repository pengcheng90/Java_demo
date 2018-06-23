import com.demo.controller.BaseController;
import util.AnnotationUtil;
import util.ClassUtil;

import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        System.out.println("package name:0+"+BaseController.class.getPackage());
        List<Class<?>> clsList = ClassUtil.getAllClassByPackageName(Package.getPackage("com.demo.controller"));
//        List<Class<?>> clsList = ClassUtil.getAllClassByPackageName(BaseController.class.getPackage());
        //输出所有使用了特定注解的类的注解值
//        AnnotationUtil.validAnnotation(clsList);
        System.out.println(clsList);
        AnnotationUtil.validAnnotation(clsList);

    }
}
