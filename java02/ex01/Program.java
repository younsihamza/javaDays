public class Program {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("you must enter two argement");
            System.exit(1);
        }
        Similarity obj =  new Similarity();
        obj.checkSimilarity(args[0], args[1]);
    }
}