package lang.annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnoTest {

    @Test
    public void testAnno() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //        Class<?> aClass = Class.forName("lang.annotation.AnnoTest");
        Class<AnnoTest> aClass = AnnoTest.class;
        AnnoTest annoTest = aClass.newInstance();

        Method m1s = aClass.getDeclaredMethod("m1", new Class[]{});
        if (m1s.isAnnotationPresent(AnnoDemo.class)) {          //获取指定注解
            AnnoDemo annotation = m1s.getAnnotation(AnnoDemo.class);
            System.out.println(annotation.value());
        }

        Annotation[] declaredAnnotations = m1s.getDeclaredAnnotations(); //获取所有注解
        for (Annotation a : declaredAnnotations) {
            System.out.println(a);
        }
        m1s.invoke(annoTest, new Object[]{});
    }

    @AnnoDemo(value = "anno_test_value")
    public void m1() {
        System.out.println("m1().......");
    }
}
