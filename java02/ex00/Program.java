

import java.io.*;
import java.util.Scanner;

public class Program {
    
    static public  void main(String[] args)  throws IOException  { 
      Signatures obj  = Signatures.getSignatures();
      Scanner scanner = new Scanner(System.in);
      String hold = "";
      while(scanner.hasNext()){
        hold = scanner.nextLine();
        if(hold.equals("42")){
          obj.getResultFile();
          break;
        }
        obj.getFileExtantion(hold);
        System.out.println("PROCESSED");
      }
      scanner.close();
    }
}
