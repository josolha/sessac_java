package example0814;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<Integer,String> testMap = new HashMap<>();
        testMap.put(1,"test");
        testMap.put(2,"test2");
        testMap.put(3,"test3");
        testMap.put(4,"test4");

        testMap.forEach((k,v)->{
            System.out.println(k +" : " +v);
        });
    }
}
