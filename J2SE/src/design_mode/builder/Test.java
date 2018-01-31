package design_mode.builder;

/**
 *
 为何使用

 是为了将构建复杂对象的过程和它的部件解耦。注意：是解耦过程和部件。
 因为一个复杂的对象，不但有很多大量组成部分，如汽车，有很多部件：车轮、方向盘、发动机，还有各种小零件等等，部件很多，但远不止这些，如何将这些部件装配成一辆汽车，这个装配过程也很复杂(需要很好的组装技术)，Builder模式就是为了将部件和组装过程分开。

 如何使用

 首先假设一个复杂对象是由多个部件组成的，Builder模式是把复杂对象的创建和部件的创建分别开来，分别用Builder类和Director类来表示。

 Builder：为创建一个Product对象的各个部件指定抽象接口。

 ConcreteBuilder：实现Builder的接口以构造和装配该产品的各个部件，定义并明确它所创建的表示，提供一个检索产品的接口

 Director：构造一个使用Builder接口的对象。

 Product：表示被构造的复杂对象。ConcreateBuilder创建该产品的内部表示并定义它的装配过程。

 *
 *
 */
public class Test {

    @org.junit.jupiter.api.Test
    void test() {
        ConcreateBuilder builder = new ConcreateBuilder();
        Director director = new Director(builder);
        director.construct();
        Product result = builder.getResult();
    }
}
