package Zad4;

public class AvgValArray {
    private int sum, avarage;

    int avgValArray(int[] array) {
        sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println("Wątek został przerwany");
            }
        }
        avarage = sum / array.length;
        return avarage;
    }
}
