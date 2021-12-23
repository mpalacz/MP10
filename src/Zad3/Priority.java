package Zad3;

public class Priority implements Runnable {
    int count;
    Thread thread;
    static boolean stop = false;
    static String currentName;

    Priority(String name) {
        thread = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    public void run() {
        System.out.println(thread.getName() + " rozpoczyna działanie");
        do {
            count++;
            if (currentName.compareTo(thread.getName()) != 0) {
                currentName = thread.getName();
                System.out.println(currentName + " jest wykonywany");
            }
        } while (stop == false && count < 10_000_000);
        stop = true;
        System.out.println("\n" + thread.getName() + " kończy działanie");
    }
}

class PriorityDemo {
    public static void main(String[] args) {
        Priority mt1 = new Priority("Wątek o wysokim priorytecie");
        Priority mt2 = new Priority("Wątek o niskim priorytecie");
        Priority mt3 = new Priority("Wątek nr 1 o normalnym priorytecie");
        Priority mt4 = new Priority("Wątek nr 2 o normalnym priorytecie");
        Priority mt5 = new Priority("Wątek nr 3 o normalnym priorytecie");

        mt1.thread.setPriority(Thread.MAX_PRIORITY);
        mt2.thread.setPriority(Thread.MIN_PRIORITY);

        mt1.thread.start();
        mt2.thread.start();
        mt3.thread.start();
        mt4.thread.start();
        mt5.thread.start();

        try {
            mt1.thread.join();
            mt2.thread.join();
            mt3.thread.join();
            mt4.thread.join();
            mt5.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Główny wątek rozpoczyna działanie");
        }
        System.out.println("\nWątek o wysokim priorytecie doliczył do " + mt1.count);
        System.out.println("Wątek o niskim priorytecie doliczył do " + mt2.count);
        System.out.println("Wątek nr 1 o normalnym priorytecie doliczył do " + mt3.count);
        System.out.println("Wątek nr 2 o normalnym priorytecie doliczył do " + mt4.count);
        System.out.println("Wątek nr 3 o normalnym priorytecie doliczył do " + mt5.count);
    }
}
