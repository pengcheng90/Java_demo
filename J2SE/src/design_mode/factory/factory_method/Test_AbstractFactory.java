package design_mode.factory.factory_method;

import design_mode.factory.bean.Sample;
import org.junit.jupiter.api.Test;

public class Test_AbstractFactory {

    @Test
    void test() {
        AbstractFactory abstractFactory = new Default_AbstractFactory();
        Sample sampleA = abstractFactory.createSampleA();
        Sample sampleB = abstractFactory.createSampleB();
        sampleA.m();
        sampleB.m();
    }
}
