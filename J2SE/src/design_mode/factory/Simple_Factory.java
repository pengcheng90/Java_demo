package design_mode.factory;

import design_mode.factory.bean.Sample;
import design_mode.factory.bean.SampleA;
import design_mode.factory.bean.SampleB;
import org.junit.jupiter.api.Test;

/**
 * 工厂模式1：简单工厂模式
 * <p>
 * 简单工厂模式：又称为静态工厂模式。它存在的目的很简单：定义一个创建对象的接口。
 * <p>
 * 在简单工厂模式中，一个工厂类处于对产品类实例化调用的中心位置上，它决定哪一个产品类应该被实例化，如同一个交通警察站在来往的车辆流中
 * 决定放行哪一个方向的车辆向哪一个方向流动一样。
 * <p>
 * 组成：
 * 工厂类角色：本模式的核心，含有一定的商业逻辑和判断逻辑。在java中往往由一个具体类实现。
 * 抽象产品角色：一般是具体产品继承的父类或者实现的接口。在java中由接口或者抽象类实现。如bean包下的Sample接口
 * 具体产品角色：工厂类所创建的对象就是此角色的实例。如bean包下的SampleA、SampleB类。
 */
public class Simple_Factory {
    public static Sample creator(int which) {
        if (which == 1) {
            return new SampleA();
        } else if (which == 2) {
            return new SampleB();
        }
        return null;
    }

    @Test
    void test() {
//        Sample creator = creator(1);
        Sample creator = creator(2);
        creator.m();
    }
}
