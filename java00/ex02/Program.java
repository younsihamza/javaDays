
import java.util.Scanner;

public class Program {
    public static int floorSquare(int userNumber) {
        int i = 0;
        while (i * i <= userNumber ) {
            i++;
        }
        return i - 1;
    }
    public static boolean findPrime(int userNumber) {
        int userNumberSquare = Program.floorSquare(userNumber);
        boolean isPrime = true;
        int numberOfIteration = 1;

        if (userNumber == 0 || userNumber == 1) {
            return false;
        }
        for (int i = 2; i <= userNumberSquare; i++) {
            if (userNumber % i == 0) {
                isPrime = false;
                break;
            }
            numberOfIteration++;
        }
        return isPrime;
    }
    public static int sumNumber(int userNumber) {
        int result = 0;
        if (userNumber == 0) {
            return 0;
        }
        result = userNumber % 10;
        result += sumNumber(userNumber / 10);
        return result;
    }
    public static void main(String [] args){
        int userNumber;
        int coffeeRequest = 0;
        Scanner myObj = new Scanner(System.in).useDelimiter("\n");
        while (true) {
            System.out.print("-> ");
            userNumber = myObj.nextInt();
            if (userNumber == 42) {
                System.out.println("count of coffee-request : " + coffeeRequest);
                break;
            }
            if (findPrime(Program.sumNumber(userNumber)) == true) {
                coffeeRequest++;
            }
        }

    }
}
