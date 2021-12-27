package Zad4;

public class MyThreadSync implements Runnable {
    Thread thread;
    static SumArray sa = new SumArray();
    int a[], answer;

    MyThreadSync(String name, int nums[]) {
        thread = new Thread(this, name);
        a = nums;
    }

    public static MyThreadSync createAndStart(String name, int nums[]) {
        MyThreadSync myThreadSync = new MyThreadSync(name, nums);
        myThreadSync.thread.start();
        return myThreadSync;
    }

    public void run() {
        System.out.println(thread.getName() + " rzopoczyna nowe działanie");
        answer = sa.sumArray(a);
        System.out.println(thread.getName() + " wyliczył sumę równą " + answer);
        System.out.println(thread.getName() + " kończy działanie");
    }
}
