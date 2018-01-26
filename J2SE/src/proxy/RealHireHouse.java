package proxy;

/**
 * 真实角色
 */
public class RealHireHouse implements  HireHouse{
    @Override
    public void hire() {
        System.out.println("租房。。。。");
    }
}
