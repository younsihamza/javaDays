public class Program {

    public static void main(String[] arg) {
        if (arg.length != 1 || !arg[0].startsWith("--count=")) {
            System.err.println("ERROR : argements not valid ");
            System.exit(1);
        }
        try{
            Integer iteration = Integer.parseInt(arg[0].substring("--count=".length()));
            Resource resource = new Resource();
            Thread egg = new EggThread(iteration, resource);
            Thread hen = new HenThread(iteration, resource);
            egg.start();
            hen.start();
            egg.join();
            hen.join();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
