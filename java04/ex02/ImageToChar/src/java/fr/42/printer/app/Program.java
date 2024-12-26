package app;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import java.util.List;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
import logic.ConvertImage;

public class Program {
  @Parameter(
    names="--white",
    validateWith = {ValidColor.class},
    description = "white spot color",
    required = true
    )
    private String white;
  @Parameter(names="--black",
    validateWith = {ValidColor.class},
    description = "black spot color",
    required = true
    )
    private String black;
    String getWhite(){
      return white;
    }
    String getBlack(){
      return black;
    }
    


    static String imagePath = "target/resources/it.bmp";
    public static void main(String[] args) {
      try {
        Program main = new Program();
        JCommander cmd = JCommander.newBuilder()
                .addObject(main)
                .build();
        cmd.parse(args);
        ConvertImage objConvert  = new ConvertImage();
        List<Integer> ImageArray = objConvert.convertImageToArray(Program.imagePath);
        ColoredPrinter cp = new ColoredPrinter.Builder(1,false).build();
        for(int i = 0; i < ImageArray.size(); i++) {
            if((byte)(ImageArray.get(i).intValue()) == 0 )
                cp.print(" ",Ansi.Attribute.NONE,Ansi.FColor.NONE, Ansi.BColor.valueOf(main.getBlack()));
            else
                cp.print(" ",Ansi.Attribute.NONE,Ansi.FColor.NONE, Ansi.BColor.valueOf(main.getWhite()));
            if((i + 1) % objConvert.getWidth() == 0 && i != 0)
                System.out.print("\n");
        }
      } catch(Exception e) {
        System.out.println(e.getMessage());
        System.exit(1);
      }
    }
}