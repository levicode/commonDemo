package multiTread;

import java.util.Date;

public class RunableTest implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(new Date());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunableTest());
        thread.start();
        System.out.println("thread start");
    }
}
