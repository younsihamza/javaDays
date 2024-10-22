import java.util.Scanner;

public class Program {
    public static void printResult(long result, int numberOfWeeks){
        if (result == 0)
            return ;
        printResult(result / 10, --numberOfWeeks);
        System.out.print("Week " + numberOfWeeks + " ");
        for(int i = 0; i < (result % 10);i++){
            System.out.print("=");
        }
        System.out.println(">");
    }
    public static void main(String [] args) {
        int currentWeek = 1;
        String userInput;
        int minResultInWeek;
        long storageNumber = 0;
        int result;
        Scanner objScanner = new Scanner(System.in);
        while(currentWeek <= 18) {
            System.out.print("-> ");
            userInput = objScanner.nextLine();
            if (userInput.equals("42")) {
                break;
            }
            if (!userInput.equals("Week "+currentWeek)){
                System.err.println("IllegalArgument");
                objScanner.close();
                System.exit(-1);
            }
            System.out.print("-> ");
            minResultInWeek = objScanner.nextInt();
            for (int i = 0; i < 4; i++){
                result = objScanner.nextInt();
                if (result < 1 || result > 9) {
                    System.err.println("result should be between 1 and 9");
                    objScanner.close();
                    System.exit(-1);
                }
                if (result < minResultInWeek){
                    minResultInWeek = result;
                }
            }
            objScanner.nextLine();
            storageNumber = storageNumber * 10 + minResultInWeek;
            currentWeek++;
        }
        objScanner.close();
        Program.printResult(storageNumber, currentWeek);

    }
}
