import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Integer numberOfThreads = Integer.parseInt(args[1].substring("--threadsCount=".length()));
        Integer sizeOfArray = Integer.parseInt(args[0].substring("--arraySize=".length()));
        Resource resource = new Resource(sizeOfArray);
        System.out.println("Sum: " + sizeOfArray);
        try{
            Mythread tmp = null;
            int sizeOfEach = sizeOfArray / numberOfThreads;
            if((sizeOfEach + 1) * (numberOfThreads -1) >= sizeOfArray )
                sizeOfEach -= 1;
            System.out.println(sizeOfEach);
            int rem = sizeOfArray % numberOfThreads;
            int curentChenked = 0;
            int i = 0;
            List<Mythread> threadHolder = new ArrayList<>();
            for(; i < numberOfThreads; i++) {
                int end = (i == numberOfThreads - 1) ? sizeOfArray -1 : curentChenked + sizeOfEach ;
                tmp = new Mythread(resource, curentChenked , end);
                tmp.setName("Thread " + (i+1));
                tmp.start();
                threadHolder.add(tmp);
                curentChenked = end + 1 ;
            }
            for (Mythread thread : threadHolder) {
                thread.join();
            }
            System.out.println("sum by threads: " + resource.getSum());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
