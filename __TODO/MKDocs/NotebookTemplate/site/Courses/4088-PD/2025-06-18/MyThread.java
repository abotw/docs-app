import java.lang.Thread;

class Thread1 extends Thread {
    public void run() {
        System.out.println("Thread1 is Running……");
        try {
            this.sleep(10000);
        } catch(Exception e) {

        };
    }
}

class Thread2 implements Runnable {
    public void run() {
        System.out.println("Thread2 is running……");
    }
}

public class MyThread {
    public static void main(String[] args) {
        while(true) {
            Thread1 t1 = new Thread1();
            Thread t2 = new Thread(new Thread2());
            t1.start();
            t2.start();
            try {
                t2.sleep(100);
            } catch(Exception e) {};
        }
    }
}