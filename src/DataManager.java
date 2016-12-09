import java.util.*;
import java.util.Map.Entry;

/**SortAndShuffle
 * Created by Benny on 12/7/2016.
 */
public class DataManager {
    private HashMap<String,Integer> sorted;

    public DataManager(HashMap<String,Integer> reducedMap){
        this.sorted = reducedMap;
    }


    public HashMap<String, Integer> sort(HashMap<String,Integer> reducedMap) {

        Object[] a = reducedMap.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Entry<String, Integer>) o2).getValue()
                        .compareTo(((Entry<String, Integer>) o1).getValue());
            }
        });
        for (Object e : a) {
            System.out.println(((Entry<String, Integer>) e).getKey() + " : " + ((Entry<String, Integer>) e).getValue());
        }
            return reducedMap;
    }
}
