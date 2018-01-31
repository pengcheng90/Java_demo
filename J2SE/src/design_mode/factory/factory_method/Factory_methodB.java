package design_mode.factory.factory_method;

import design_mode.factory.bean.Sample;
import design_mode.factory.bean.SampleB;

public class Factory_methodB implements Factory_method {
    @Override
    public Sample create() {
        return new SampleB();
    }
}
