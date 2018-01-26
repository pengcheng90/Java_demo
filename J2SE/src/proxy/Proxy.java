package proxy;

/**
 * 静态代理
 */
public class Proxy implements HireHouse {
    private HireHouse hireHouse;

    @Override
    public void hire() {
        if (hireHouse == null) hireHouse = new RealHireHouse();
        System.out.println("加佣金");
        hireHouse.hire();
        System.out.println("扣押金");

    }


}
