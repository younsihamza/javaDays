import java.util.Scanner;

public class Program {

    public static void sortClasses(String[][] classesTime,int numberOfClasses) {
        int[] classesDays = new int[numberOfClasses];
        String[] tamp ;
        for(int i  = 0; i < numberOfClasses ; i++) {
            classesDays[i] = Program.findDay(classesTime[i][1]);
        }
        for(int i = 0; i < numberOfClasses; i++) {
            for(int j = i; j < numberOfClasses ; j++ ) {
                if ((classesDays[i] > classesDays[j]) || 
                        (classesDays[i] == classesDays[j] &&
                        (int)classesTime[i][0].toCharArray()[0] > 
                        (int)classesTime[j][0].toCharArray()[0])) {

                    classesDays[i] = classesDays[i] ^ classesDays[j];
                    classesDays[j] = classesDays[i] ^ classesDays[j];
                    classesDays[i] = classesDays[i] ^ classesDays[j];
                    tamp = classesTime[i];
                    classesTime[i] = classesTime[j];
                    classesTime[j] = tamp;
                }
            }
        }
       
        
    }
    public static int findDay(String day) {
        final String[] days = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
        for(int i = 0; i < 7; i++) {
            if(days[i].equals(day)){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] studenTable = new String[10];
        String[][] classesTime =  new String[10][2];
        String [][] studentAttendance = new String[40][3];
        int numberOfAttendance = 0;
        int numberOfClasses = 0;
        int studentNumber = 0;
        Scanner myScanner = new Scanner(System.in);
    
        for(; studentNumber < 10; studentNumber++ ) {
            studenTable[studentNumber] = myScanner.nextLine();
            if (studenTable[studentNumber].length() > 10 || studenTable[studentNumber].length() == 0){
                System.err.println("ERROR : student name not valid");
                System.exit(-1);
            }
            if(studenTable[studentNumber].equals(".")){
                studenTable[studentNumber] = null;
                break;
            }
        }
        for(; numberOfClasses < 10; numberOfClasses++) {
            System.out.print("-> ");
            classesTime[numberOfClasses][0] = myScanner.next();
            if(classesTime[numberOfClasses][0].equals(".")) {
                break;
            }
            classesTime[numberOfClasses][1] = myScanner.next();
        }

        for(;numberOfAttendance < 40; numberOfAttendance++) {
            studentAttendance[numberOfAttendance][0] = myScanner.next();
            if(studentAttendance[numberOfAttendance][0].equals(".")) {
                break;
            }
            studentAttendance[numberOfAttendance][1] = myScanner.next();
            studentAttendance[numberOfAttendance][2] = myScanner.next();
        }
        Program.sortClasses(classesTime, numberOfClasses);
        for(int i = 0; i < numberOfClasses; i++) {
            System.out.println(classesTime[i][0] + " |  " + classesTime[i][1]);
        }
    }
}
