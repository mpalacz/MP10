package Zad4;

public class SumArray {
    private int sum;

    int sumArray(int nums[]) {
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println(Thread.currentThread().getName() + " wyliczył sumę częściową równą " + sum);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Wątek został przerwany");
            }
        }
        return sum;
    }
}
