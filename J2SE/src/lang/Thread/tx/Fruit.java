package lang.Thread.tx;

public class Fruit {
    private String name;
    private boolean isExist;

    public Fruit(String name, boolean isExist) {
        this.name = name;
        this.isExist = isExist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }
}
