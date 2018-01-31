package design_mode.builder;

/**
 * 首先假设一个复杂对象由多个部件组成的，Builder模式是把复杂对象的创建和部件的创建分开，分别用Builder类和Director类表示
 */
public interface Builder {

    //创建部件A，比如汽车部件：发动机
    //创建部件A，比如汽车部件：轮子
    //创建部件A，比如汽车部件：方向盘

    public void buildPartA();

    public void buildPartB();

    public void buildPartC();

    Product getResult();
}
