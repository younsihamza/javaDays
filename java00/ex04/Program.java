import java.util.Scanner;

class Program {
    public static void printChart(int[][] chartData, int length){
        double charRate = (double)(chartData[0][1]) / 10;

        if (length > 10) {
            length = 10;
        }
        for (int i = 11; i >= 0 ; i--){
            for (int j = 0; j < length ; j++){
                if ((int)((float)chartData[j][1] / charRate)  == i  ) {
                    System.out.print(chartData[j][1]+ "   ");
                }else if ((int)((float)chartData[j][1] / charRate) > i){
                    System.out.print("#" + "   ");
                }
            }
            System.out.println("");
        }
        for(int i = 0; i < length; i++){
            System.out.print((char)chartData[i][0]+ "  ");
        }
        System.out.println("");
    }

    public static void sortArray(int [][] chartData , int length) {
        for (int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                if (chartData[i][1] < chartData[j][1]){
                    int[] tamp = chartData[i].clone();
                    chartData[i] = chartData[j].clone();
                    chartData[j] = tamp;
                }else if (chartData[i][1] == chartData[j][1]) {
                    if (chartData[i][0] > chartData[j][0]) {
                        chartData[i][0] = chartData[j][0] ^ chartData[i][0];
                        chartData[j][0] = chartData[j][0] ^ chartData[i][0];
                        chartData[i][0] = chartData[j][0] ^ chartData[i][0];
                    }
                }
            }
        }
    }

    public static void main(String [] args){
        Scanner myScanner = new Scanner(System.in);
        int [][] chartData = new int[1000][2];
        int[] logicArray = new int[65536];
        String inputUser = "";
        char [] inputUserArray;
        if (myScanner.hasNextLine())
            inputUser = myScanner.nextLine();
        else
            System.exit(-1);
        inputUserArray = inputUser.toCharArray();
        for (char i:inputUserArray){
            logicArray[(int)i] += 1; 
        }
        int currentIndex = 0;
        for (int i = 0; i < 1000 ; i++) {
            if (logicArray[i] != 0) {
                chartData[currentIndex][0] = i;
                chartData[currentIndex][1] = logicArray[i];
                currentIndex++;
            }
        }
        Program.sortArray(chartData, currentIndex);
        Program.printChart(chartData, currentIndex);
    }
}