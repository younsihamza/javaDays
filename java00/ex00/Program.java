
public class Program {
    public static void main (String[] args) {
        final int USER_NUMBER = 479598;
        int sumNumber = 0;
        
        sumNumber += (USER_NUMBER / 100000 ) % 10;
        sumNumber += (USER_NUMBER / 10000 ) % 10;
        sumNumber += (USER_NUMBER / 1000 ) % 10;
        sumNumber += (USER_NUMBER / 100 ) % 10;
        sumNumber += (USER_NUMBER / 10 ) % 10;
        sumNumber += (USER_NUMBER ) % 10;

        System.out.println(sumNumber);
    }
}
