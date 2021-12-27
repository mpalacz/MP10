package Zad4;

public class Sync {
    public static void main(String[] args) {
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (100 - 1) + 1);
        }

        MyThreadSync myThreadSync1 = MyThreadSync.createAndStart("Wątek potomny nr1", a);
        MyThreadSync myThreadSync2 = MyThreadSync.createAndStart("Wątek potomny nr2", a);
        try {
            myThreadSync1.thread.join();
            myThreadSync2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Wątek główny został przerwany");
        }
    }
}