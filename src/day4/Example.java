package day4;

public class Example {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new MyThread()).start();
        }

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}


class MyThread implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}