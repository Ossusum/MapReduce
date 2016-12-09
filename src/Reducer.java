import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Benny on 12/7/2016.
 */
public class Reducer {
    Mapper mapper;
    HashMap<String,Integer> reducedMap;
    public Reducer(Mapper mapper){
        reducedMap = new HashMap<String,Integer>();
        this.mapper = mapper;
    }

    public void reduce(){
        ArrayList<HashMap<String,Integer>> fileHashedLines = mapper.getFileHashedLines();
        for(int i = 0; i < fileHashedLines.size();++i){

            for (int j = 0; j < fileHashedLines.get(i).size();++j){

                String key = (String) fileHashedLines.get(i).keySet().toArray()[j];
                Integer value = (Integer) fileHashedLines.get(i).values().toArray()[j];

                if (reducedMap.containsKey(fileHashedLines.get(i).keySet().toArray()[j])){
                    Integer prev = reducedMap.get(key).intValue();
                    reducedMap.remove(key);//.keySet().toArray()[j]);
                    reducedMap.put(key,  value + prev );
                }else{
                    reducedMap.put((String)fileHashedLines.get(i).keySet().toArray()[j],1);
                }

            }

        }
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public HashMap<String, Integer> getReducedMap() {
        return this.reducedMap;
    }

    public void setReducedMap(HashMap<String, Integer> reducedMap) {
        this.reducedMap = reducedMap;
    }

    public String toString(){
        return reducedMap.toString();
    }

}
