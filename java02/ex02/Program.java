import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        if(args.length != 1 || !args[0].startsWith("--current-folder="))
            return;
        String workDic = args[0].substring("--current-folder=".length());
        Scanner scanner = new Scanner(System.in);
        Cmd obj = new Cmd(workDic);
        while(true) {
            System.out.println(obj.getWorkDir());
            String[] commendTable = scanner.nextLine().split(" "); 
            String commend = commendTable[0];
            switch (commend) {
                case "ls":
                    obj.ls();
                    break;
                case "cd":
                    if (commendTable.length == 2)
                        obj.cd(commendTable[1]);
                    else
                        System.out.println("commend not valid");
                    break;
                case "mv":
                    if (commendTable.length == 3)
                        obj.mv(commendTable[1],commendTable[2]);
                    else
                        System.out.println("commend not valid");
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("commend not valid");
                    break;
            }
        }
    }
}
