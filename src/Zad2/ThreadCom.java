package Zad2;

public class ThreadCom {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThreadClock myThreadClock1 = MyThreadClock.createAndStart("tik", tt);
        MyThreadClock myThreadClock2 = MyThreadClock.createAndStart("tak", tt);
        try {
            myThreadClock1.thread.join();
            myThreadClock2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Wątek główny został przerwany");
        }
    }
}
