import java.util.Map;
import java.util.HashMap;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Similarity {

    public Similarity(){
       
    }
    public void checkSimilarity(String file1, String file2){
        Set<String> setWords = new HashSet<>();
        Map<String,Integer> wordsHolder1 = this.wordsOfFile(file1);
        Map<String,Integer> wordsHolder2 = this.wordsOfFile(file2);
        if(wordsHolder1 == null || wordsHolder2 == null)
            return;
        setWords.addAll(wordsHolder1.keySet());
        setWords.addAll(wordsHolder2.keySet());
        List<Integer> vector1 = this.TextToVector(wordsHolder1, setWords);
        List<Integer> vector2 = this.TextToVector(wordsHolder2, setWords);
        System.out.println((int)(this.CalculateSimilarity(vector1,vector2)*100) / 100f);
    }
    private Map<String, Integer> wordsOfFile(String fileName){
        try{
            FileReader file = new FileReader(fileName);
            Map<String,Integer> holdMap = new HashMap<>();
            BufferedReader buffer = new BufferedReader(file);
            String line;
            String regex = "[,\\.\\s;()<>%$#@!^&*]";
            String [] hold = null;
            while((line = buffer.readLine()) != null){
                hold = line.toLowerCase().split(regex); 
                for(int i = 0; i < hold.length; i++){
                    if(holdMap.containsKey(hold[i]))
                        holdMap.put(hold[i], holdMap.get(hold[i]) + 1);
                    else
                        holdMap.put(hold[i], 1);
                }
            }
            file.close();
            return holdMap;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    private List<Integer> TextToVector( Map<String,Integer> wordsMap, Set<String> setWords){
        List<Integer> vector = new ArrayList<>();
        for(String h: setWords){
            if(wordsMap.containsKey(h))
                vector.add(wordsMap.get(h));
            else
                vector.add(0);
        }
        return vector;
    }

    private double CalculateSimilarity(List<Integer> vector1, List<Integer> vector2){
        Integer Numerator = 0;
        Float A = 0f;
        Float B = 0f;
        for(int i = 0 ; i < vector1.size(); i++){
            Numerator += vector1.get(i) * vector2.get(i);
            A += vector1.get(i) * vector1.get(i);
            B += vector2.get(i) * vector2.get(i);
        }
        return Numerator / (Math.sqrt(A) * Math.sqrt(B));
    }
}
