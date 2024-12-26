package app;
import java.util.List;

import logic.ConvertImage;
public class Program {
    static String white;
    static String black;
    static String imagePath = "target/resources/it.bmp";
    public static void parseArgements(String[] args){
        if(args.length != 2 
                ||!args[0].startsWith("--white=")
                ||!args[1].startsWith("--black=")){
            System.err.println("ERROR: ARGEMENT not valid");
            System.exit(1);
        }
        Program.white = args[0].substring("--white=".length());
        Program.black = args[1].substring("--black=".length());
    }
    public static void main(String[] args) {
        Program.parseArgements(args);
        ConvertImage objConvert  = new ConvertImage();
        List<Integer> ImageArray = objConvert.convertImageToArray(Program.imagePath);
        for(int i = 0; i < ImageArray.size(); i++) {
            if((byte)(ImageArray.get(i).intValue()) == 0 )
                System.out.print(Program.black);
            else
                System.out.print(Program.white);
                
            if((i + 1) % objConvert.getWidth() == 0 && i != 0)
                System.out.print("\n");
        }
    }
}