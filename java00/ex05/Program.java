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

    public static int checkAttendence(String student , String date, String[][] studentAttendance,int numberOfAttendance) {
        for(int i = 0; i < numberOfAttendance; i++) {
            if (date.equals(studentAttendance[i][1] + " " + studentAttendance[i][2]) && student.equals(studentAttendance[i][0])) {
                return (studentAttendance[i][3].equals("NOT_HERE")? -1 : 1);
            }
        }
        return 0;
    }

    public static int findDay(String day) {
        // change days order because september start on a Tursday
        final String[] days = {"TU", "WE", "TH", "FR", "SA", "SU","MO"}; 
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
        String [][] studentAttendance = new String[100][4];
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

        for(;numberOfAttendance < 100; numberOfAttendance++) {
            studentAttendance[numberOfAttendance][0] = myScanner.next();
            if(studentAttendance[numberOfAttendance][0].equals(".")) {
                break;
            }
            studentAttendance[numberOfAttendance][1] = myScanner.next();
            studentAttendance[numberOfAttendance][2] = myScanner.next();
            studentAttendance[numberOfAttendance][3] = myScanner.next();
        }
        Program.sortClasses(classesTime, numberOfClasses);
        System.out.printf("%10s","");
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < numberOfClasses; j++) {
                int numberPosition = Program.findDay(classesTime[j][1]) + 1  + 7 * i;
                if (numberPosition  <= 30)
                    System.out.printf("%1s:00%3s%3d|", classesTime[j][0] , classesTime[j][1] , numberPosition);
            }
        }
        System.out.println("");
        for(int k = 0; k < studentNumber; k++) {
            System.out.printf("%10s",studenTable[k]);
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < numberOfClasses; j++) {
                    int numberPosition = Program.findDay(classesTime[j][1]) + 1  + 7 * i;
                    if (numberPosition  <= 30){
                        int h = Program.checkAttendence(studenTable[k], classesTime[j][0] + " " + numberPosition, studentAttendance, numberOfAttendance);
                        if(h != 0)
                            System.out.printf("%10d|", h);
                        else
                            System.out.printf("%10s|", "");
                    }
                }
            }
            System.out.println("");
        }
    }
}
