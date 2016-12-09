import java.io.File;

/**
 * Created by Benny on 12/7/2016.
 */
public class Client {
    public static void main(String[]args){
        Mapper mapper = new Mapper(new File("data.txt"));
        mapper.readFile();
        System.out.println("==============Mapper Output==================");
        System.out.println(mapper);
        System.out.println("=============================================");
        Reducer reducer = new Reducer(mapper);
        reducer.reduce();
        System.out.println("==============Reducer Output==================");
        System.out.println(reducer);
        System.out.println("=============================================");
        DataManager dataManager = new DataManager(reducer.reducedMap);
        dataManager.sort(reducer.reducedMap);
        System.out.println("==============Sorted Output==================");
        //System.out.println(dataManager.sort(reducer.reducedMap));
        dataManager.sort(reducer.reducedMap);
        System.out.println("=============================================");
    }
}
