package design_mode.factory.factory_method;

import design_mode.factory.bean.Sample;
import design_mode.factory.bean.SampleA;

public class Factory_methodA implements Factory_method {
    @Override
    public Sample create() {
        return new SampleA();
    }
}
