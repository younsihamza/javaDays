
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class Signatures{
    private Integer maxLength = 0;
    private Map<String, String> SignaterData = null;
    private List<String> result = null;
    private static Signatures SignaturesObj = null;

    public static Signatures getSignatures() {
        if(SignaturesObj == null){
            SignaturesObj = new Signatures();
        }
        return SignaturesObj;
    }

    private Signatures (){
        this.SignaterData = new HashMap<String,String>();
        this.result = new ArrayList<>();
        loadSignatures();
    }

    private void loadSignatures() {
         try {
                InputStream file = new FileInputStream("signatures.txt");
                int ch = -1;
                String lable = "";
                String value = "";
                boolean islableEnd = false;
               
                while((ch = file.read()) != -1) {
                    if(ch == ' ')
                        continue;
                    else if(ch == 10){
                        islableEnd = false;
                        this.SignaterData.put(value, lable);
                        if(value.length() > maxLength )
                            maxLength = value.length();
                        value = "";
                        lable = "";
                    }
                    else if((char)ch == ','){
                        islableEnd = true;
                    }
                    else if(islableEnd == false){
                        lable +=(char)ch;
                    }else 
                        value += (char)ch;
                }
                file.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public void getFileExtantion(String FileName){
        try{
            InputStream file = new FileInputStream(FileName);
            int ch = -1;
            String tmp = "";
            while((ch= file.read()) != -1 && this.maxLength > tmp.length()){
                tmp += Integer.toHexString(ch).toUpperCase();
                if(this.SignaterData.containsKey(tmp)){
                    file.close();
                    this.result.add(this.SignaterData.get(tmp));
                }
            }
            file.close();
        } catch(Exception e){
        }
    }
    public void getResultFile(){
        try {
            OutputStream file = new FileOutputStream("result.txt");
            for(int i  = 0; i < this.result.size();i++){
                file.write(this.result.get(i).getBytes());
            }
            file.flush();
            file.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}