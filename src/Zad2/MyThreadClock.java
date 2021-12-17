package Zad2;

public class MyThreadClock implements Runnable {
    Thread thread;
    TickTock ttOb;

    MyThreadClock(String name, TickTock tt) {
        thread = new Thread(this, name);
        ttOb = tt;
    }

    public static MyThreadClock createAndStart(String name, TickTock tt) {
        MyThreadClock myThreadClock = new MyThreadClock(name, tt);
        myThreadClock.thread.start();
        return myThreadClock;
    }

    public void run() {
        if (thread.getName().compareTo("tik") == 0) {
            for (int i = 0; i < 5; i++)
                ttOb.tick(true);
            ttOb.tick(false);
        } else {
            for (int i = 0; i < 5; i++)
                ttOb.tock(true);
            ttOb.tock(false);
        }
    }
}