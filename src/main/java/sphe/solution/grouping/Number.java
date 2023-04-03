package sphe.solution.grouping;

import org.springframework.stereotype.Component;
import sphe.solution.grouping.numberrangesummarizer.NumberRangeSummarizer;

import java.util.*;
import java.util.function.Function;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

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

        Iterator<Integer>  iterator = input.iterator();
        List<List<Integer>> groups = new ArrayList<>();
        List<Integer> currentGroup = new ArrayList<>();
        Integer prev = null ;
        while(iterator.hasNext()){
            Integer item = iterator.next();

            if(prev!= null && item.equals(prev+1)){
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

        groups.forEach(System.out::println);
        return null;
    }
}
