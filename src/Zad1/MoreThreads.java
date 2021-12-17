package Zad1;

public class MoreThreads {
    public static void main(String[] args) {
        System.out.println("Główny wątek rozpoczyna działanie.");
        MyThread myThread1 = MyThread.createAndStart("Wątek potomny nr 1");
        MyThread myThread2 = MyThread.createAndStart("Wątek potomny nr 2");
        MyThread myThread3 = MyThread.createAndStart("Wątek potomny nr 3");

        try {
            myThread1.thread.join();
            myThread2.thread.join();
            myThread3.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Wątek główny został przerwany");
        }
        System.out.println("Wątek główny kończy działanie");
    }
}
