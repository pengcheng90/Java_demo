package lang.Class;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Person person = new Person("ming", 22);
        Class clazz = person.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            String key = f.getName();
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(key, clazz);
            Method method=propertyDescriptor.getReadMethod();
            Object value = method.invoke(person);

            System.out.println(key+":"+value);
        }
    }
}
