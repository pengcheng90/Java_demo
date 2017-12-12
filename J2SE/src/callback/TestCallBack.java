package callback;

public class TestCallBack implements Listener.CallBack{
    public static void main(String[] args) {
        new Listener().setOnListener(new TestCallBack());
    }

    @Override
    public void call() {
        System.out.println("back....");
    }
}
