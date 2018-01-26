package lang.Class;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Person {
    private String name;
    private int age;

//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
//        Person person = new Person("ming", 22);
//        Class clazz = person.getClass();
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field f : fields) {
//            String key = f.getName();
//            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(key, clazz);
//            Method method=propertyDescriptor.getReadMethod();
//            Object value = method.invoke(person);
//
//            System.out.println(key+":"+value);
//        }
//    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        Class<?> aClass = Class.forName("lang.Class.Person");
        Person p = (Person) aClass.newInstance();

        /**
         * 获取属性
         */
        Field field1 = aClass.getDeclaredField("name");//获取指定的属性
        System.out.println("属性：" + field1);
        Field[] declaredFields = aClass.getDeclaredFields();//获取所有属性
        for (Field f : declaredFields) {
            System.out.println("属性：" + f);
        }

        /**
         * 获取方法
         */
        Method setName = aClass.getDeclaredMethod("setName", new Class[]{String.class});//获取指定的方法
        System.out.println("method1:" + setName);
        Method[] declaredMethods = aClass.getDeclaredMethods();//获取所有方法
        for (Method m : declaredMethods) {
            System.out.println("method：" + m);
        }

        Object invoke = setName.invoke(p, new String[]{"a"});
        System.out.println(p.getName());
    }
}
