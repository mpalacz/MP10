package Zad2;

public class TickTock {
    String state;

    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            notify();
            return;
        }
        System.out.println("tik ");
        state = "ticked";
        notify();
        try {
            Thread.sleep(500);
            while (!state.equals("tocked"))
                wait();
        } catch (InterruptedException e) {
            System.out.println("Wątek został przerwany");
        }
    }

    synchronized void tock(boolean running) {
        if (!running) {
            state = "tocked";
            notify();
            return;
        }
        System.out.println("tak");
        state = "tocked";
        notify();
        try {
            Thread.sleep(500);
            while (!state.equals("ticked"))
                wait();
        } catch (InterruptedException e) {
            System.out.println("Wątek został przerwany");
        }
    }
}
