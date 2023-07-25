package sphe.solution.grouping;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        Map<String , List<String> > map = new HashMap<>();

        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        Iterator<String> iterator = Stream.of(strs).iterator();

        Stream.of(strs).map(String::toCharArray)
                .peek(Arrays::sort).map(String::new)
                .forEach(s -> {

                    if(iterator.hasNext()){
                        map.computeIfAbsent(s , x-> new ArrayList<>()).add(iterator.next());
                    }
        });

        System.out.println(map.values().stream().toList());


    }

    public List<List<String>> groupAnagrams(final String[] strs) {

        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        // Iterate over each word in the array
        for (String str : strs) {
            // Convert the word to a char array and sort it
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            // Convert the sorted char array back to a string
            String key = new String(arr);
            // If the key doesn't exist in the map, add it
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            // Add the current word to the list associated with the key
            map.get(key).add(str);
        }



        return map.values().stream().toList();
    }
}


