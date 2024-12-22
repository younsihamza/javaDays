import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        if(args.length != 1 || !args[0].startsWith("--threadsCount=")) {
                System.out.println("ERROR: not valid argiment ");
                System.exit(1);
            }
        Resource resource = new Resource();
        MyThread tmp = null;
        List<MyThread> hold =  new ArrayList<>();
        try {
            Integer numberOfThreads = Integer.parseInt(args[0].substring("--threadsCount".length()));
            for(int i = 0; i < numberOfThreads; i++) {
                tmp =  new MyThread(resource);
                tmp.start();
                hold.add(tmp);
            }
            for(MyThread y : hold) {
                y.join();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }    
}
