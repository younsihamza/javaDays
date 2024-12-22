import java.util.Map;
import java.io.OutputStream;
import java.net.URL;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class MyThread extends Thread{
    private Resource resource;

    MyThread(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true) {
            Map<Integer, String> link = resource.getLink();
            if (link == null)
                break;
            this.downloadFile(link);
        }
    }
    public void downloadFile(Map<Integer, String> link){
        Integer fileNumber = (Integer)link.keySet().toArray()[0];
        try {
            URL urlObject = new URL(link.get(fileNumber));
            BufferedInputStream file = new BufferedInputStream(urlObject.openStream());
            FileOutputStream outfile = new FileOutputStream("file " + fileNumber);
            byte[] data = new byte[1024];
            int dataLen = -1;
            System.out.println(this.getName() + " start download file number " + fileNumber);
            while((dataLen = file.read(data,0,1024))!= -1) {
                outfile.write(data,0,dataLen);
            }
            outfile.close();
            System.out.println(this.getName()+ " finish download file number " + fileNumber);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
