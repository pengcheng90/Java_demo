package design_mode.factory.factory_method;

import design_mode.factory.bean.Sample;
import org.junit.jupiter.api.Test;

public class Test_Factory_method {
    @Test
    void test(){
//        Factory_method f=new Factory_methodA();
        Factory_method f=new Factory_methodB();
        Sample sample = f.create();
        sample.m();
    }
}
