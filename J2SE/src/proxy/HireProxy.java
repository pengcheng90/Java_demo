package proxy;

/**
 * 静态代理
 */
public class HireProxy implements HireHouse {
    private HireHouse hireHouse;

    public HireProxy(HireHouse hireHouse) {
        this.hireHouse = hireHouse;
    }

    @Override
    public void hire() {
        System.out.println("收中介费");
        hireHouse.hire();
        System.out.println("扣押金");

    }


}
