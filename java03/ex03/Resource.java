import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;
import java.io.InputStream;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;


public class Resource {
    private  Deque<String> urls;
    private Integer currentFileIndex;
    Resource() {
        this.urls = new ArrayDeque<>();
        this.currentFileIndex = 0;
        File file = new File("files_urls.txt");
        Scanner scanner  = new Scanner(file); 
        while(scanner.hasNextLine()){
            urls.add(scanner.nextLine());
        }
        scanner.close();
    }
    public synchronized Map<Integer, String> getLink() {
        if(urls.size() != 0){
            this.currentFileIndex++;
            return Map.of(this.currentFileIndex, this.urls.removeFirst());
        }
        return null;
    }
}

