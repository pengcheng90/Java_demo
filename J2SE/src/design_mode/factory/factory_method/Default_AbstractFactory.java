package design_mode.factory.factory_method;

import design_mode.factory.bean.Sample;
import design_mode.factory.bean.SampleA;
import design_mode.factory.bean.SampleB;

/**
 * 具体工厂类
 */
public class Default_AbstractFactory extends AbstractFactory {
    @Override
    public Sample createSampleA() {
        return new SampleA();
    }

    @Override
    public Sample createSampleB() {
        return new SampleB();
    }
}
