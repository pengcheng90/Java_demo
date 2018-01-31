package design_mode.builder;

public class ConcreateBuilder implements Builder {
    @Override
    public void buildPartA() {
        //具体如何构建
    }

    @Override
    public void buildPartB() {
        //具体如何构建
    }

    @Override
    public void buildPartC() {
        //具体如何构建
    }

    @Override
    public Product getResult() {
        //返回最后的结果
        return null;
    }
}
