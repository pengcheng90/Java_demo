package proxy.dynamic;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        /**
         * 代理的接口实现类对象
         */
//        RealHireHouse hireHouse = new RealHireHouse();
        /**
         * 第一个参数：被代理对象大类加载起
         * 第二个参数：被代理对象的实现接口
         * 第三个参数：自定义的代理对象
         * 返回：实现真实对象接口的实现类
         */
//        HireHouse h = (HireHouse) Proxy.newProxyInstance(hireHouse.getClass().getClassLoader()
//                , hireHouse.getClass().getInterfaces(), new HireProxy(hireHouse));
//        h.hire();

        /**
         * 2。给list做代理
         */
        List list = new ArrayList();
        List h = (List) Proxy.newProxyInstance(list.getClass().getClassLoader()
                , list.getClass().getInterfaces(), new HireProxy(list));
        h.add("aa");
    }
}
