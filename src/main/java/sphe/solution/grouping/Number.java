package sphe.solution.grouping;

import org.springframework.stereotype.Component;
import sphe.solution.grouping.numberrangesummarizer.NumberRangeSummarizer;
import java.util.*;

@Component
public class Number implements NumberRangeSummarizer{

    @Override
    public Collection<Integer> collect(String input) {
        // Check for null input
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        Collection<Integer> collection = new ArrayList<>();
        String[] number = input.split(",");

        // Check for empty input
        if (number.length == 1 && number[0].isEmpty()) {
            throw new IllegalArgumentException("Input must contain at least one number");
        }

        for (final String item : number) {
            try {
                collection.add(Integer.parseInt(item.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(item + " is not a valid integer");
            }
        }

        return collection;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if(input==null)
            return "";
        // Collection doesn't have a get(index), so I used the iterator, with equivalent pointer-iterator
        Iterator<Integer>  iterator = input.iterator();
        List<List<Integer>> groups = new ArrayList<>(); // holding lists
        List<Integer> currentGroup = new ArrayList<>();// group numbers, sequential number will size-of-this-list > 1

        Integer prev = null ;

        while(iterator.hasNext()){
            Integer item = iterator.next();

            if(item.equals(prev))
                continue;
            if(prev!= null && item.equals(prev+1)){ // used equals(Not == ) Integer is an Object .
                currentGroup.add(item);
            }
            else{
                // Add the list to the list of Lists
                if(!currentGroup.isEmpty()){
                    groups.add(currentGroup);
                }
                currentGroup = new ArrayList<>();
                currentGroup.add(item);
            }
            prev = item ;

        }
        if(!currentGroup.isEmpty())
            groups.add(currentGroup);

        ArrayList<String> myList = new ArrayList<>();
        groups.forEach((list)->{ // for-each list get lower and value
            int size = list.size();
            if(size==1)
                myList.add(String.valueOf(list.get(0)));
            else if (size > 1) {
                myList.add(list.get(0)+"-"+list.get(size-1));
            }
        });
        System.out.println(String.join(",",myList));
        return String.join(",",myList);
    }
}
