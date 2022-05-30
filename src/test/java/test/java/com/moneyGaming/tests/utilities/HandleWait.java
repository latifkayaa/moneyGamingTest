package test.java.com.moneyGaming.tests.utilities;

public class HandleWait {

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
