
public class Program {
    public static void main(String[] args) {
        try {
            if(args.length != 1 || !args[0].startsWith("--count="))
                System.exit(1);
            Integer numberOfTime = Integer.parseInt(args[0].substring("--count=".length()));
            MyThread t1 = new MyThread("EGG", numberOfTime);
            MyThread t2 = new MyThread("HEN", numberOfTime);
            Thread tr1 = new Thread(t1);
            Thread tr2 = new Thread(t2);
            tr1.start();
            tr2.start();
            tr1.join();
            tr2.join();
            for(int i = 0; i < numberOfTime ; i++){
                System.out.println("Human");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}