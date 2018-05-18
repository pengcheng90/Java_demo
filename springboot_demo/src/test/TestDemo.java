import com.demo.controller.BaseController;
import util.AnnotationUtil1;
import util.ClassUtil;

import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        List<Class<?>> clsList = ClassUtil.getAllClassByPackageName(BaseController.class.getPackage());
        //输出所有使用了特定注解的类的注解值
//        AnnotationUtil.validAnnotation(clsList);
        System.out.println(clsList);
        AnnotationUtil1.validAnnotation(clsList);

    }
}
