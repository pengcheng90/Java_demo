package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理代理
 */
public class HireProxy implements InvocationHandler {
    private Object obj;//代理对象

    public HireProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * @param proxy  被代理的对象必须实现接口
     * @param method 被代理的接口方法
     * @param args   被代理对象方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("前置操作");

        Object invoke = method.invoke(obj, args);
        if (args!=null&&args.length > 0) {
            for (Object a : args) {
                System.out.println("参数" + a);
            }
        }
        System.out.println("后置操作");

        return invoke;
    }
}
