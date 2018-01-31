package design_mode.builder;

/**
 * Director的内容是如何将部件最后组装成成品
 */

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    //将部件partA partB partC 最后组成复杂对象
    //这里是将车轮 方向盘 和发动机组装成汽车的过程
    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}
