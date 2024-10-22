
import java.util.Scanner;

public class Program {

    public static int floorSquare(int userNumber) {
        int i = 0;
        while (i * i <= userNumber ) {
            i++;
        }
        return i - 1;
    }
    public static void findPrime(int userNumber) {
        int userNumberSquare = Program.floorSquare(userNumber);
        boolean isPrime = true;
        int numberOfIteration = 1;

        if (userNumber == 0 || userNumber == 1) {
            System.out.println("false" + " " + numberOfIteration);
            return;
        }
        for (int i = 2; i <= userNumberSquare; i++) {
            if (userNumber % i == 0) {
                isPrime = false;
                break;
            }
            numberOfIteration++;
        }
        System.out.println(isPrime + " " + numberOfIteration);
    }
    public static void main(String [] args) {
        int userNumber; 
        Scanner myObj;

        userNumber = 0;
        myObj = new Scanner(System.in).useDelimiter("\n");
        System.out.print("-> ");
        if (myObj.hasNextInt()) {
            userNumber = myObj.nextInt();
            myObj.close();
         }else {
            System.err.println(" - No valid input . you should enter valid integer");
            myObj.close();
            System.exit(-1); 
        }
        if (userNumber < 0 ) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        Program.findPrime(userNumber);
    }
}
