import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Benny on 12/7/2016.
 */
public class Mapper {
    private ArrayList<HashMap<String,Integer>> fileHashedLines;
    private File fileToRead;
    private String lineString;

    public Mapper(File fileToRead){
        fileHashedLines = new ArrayList<HashMap<String, Integer>>();
        this.fileToRead = fileToRead;
    }

    public void readFile(){
        try {
            FileReader fReader = new FileReader(fileToRead);
            BufferedReader bReader = new BufferedReader(fReader);

            while((lineString = bReader.readLine())!= null){
                fileHashedLines.add(mapLine(lineString));
            }

            bReader.close();
            fReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("\n==============================\nFile was not found!\n==============================\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public HashMap<String,Integer> mapLine(String lineString){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        lineString = lineString.replaceAll(","," ");
        lineString = lineString.replaceAll("\n"," ");
        String[] words = lineString.split(" ");
        for (int i = 0; i < words.length; ++i){
            map.put(words[i],1);
        }
        return map;
    }

    public ArrayList<HashMap<String, Integer>> getFileHashedLines() {
        return this.fileHashedLines;
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < fileHashedLines.size(); ++i)
            for(int j = 0; j <fileHashedLines.get(i).size();++j)
                s+= ((Map.Entry<String, Integer>)fileHashedLines.get(i).entrySet().toArray()[j]).getKey()+" : "+((Map.Entry<String, Integer>)fileHashedLines.get(i).entrySet().toArray()[j]).getValue()+"\n";
        return s;
    }
}
