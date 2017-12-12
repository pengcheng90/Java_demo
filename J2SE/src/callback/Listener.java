package callback;

public class Listener {
    private CallBack back;

    public void setOnListener(CallBack callBack){
        this.back=callBack;
        try {
            Thread.sleep(1000);
            back.call();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public interface CallBack{
        void call();
    }
}
