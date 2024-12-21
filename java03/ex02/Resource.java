import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Resource {
    private int[] array;
    private int currentIndex;
    private int sum;
    
    Resource(Integer arraySize) {
        sum = 0;
       array = new int[arraySize];
       Arrays.fill(array, 1);
    }
    public synchronized void sumArray(Integer startProsition, Integer endPosition) {
        try {
            int sumLocal = 0;
            int i = startProsition ;
            for(;i <= endPosition; i++) {
                sumLocal += array[i];
            }
            sum += sumLocal;
            System.out.println(Thread.currentThread().getName() + " : from " + startProsition + " to " + endPosition + " sum is " + sumLocal);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public int getSum() {
        return sum;
    }
}
