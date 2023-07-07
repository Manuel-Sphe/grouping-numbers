package sphe.solution.grouping;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import sphe.solution.grouping.numberrangesummarizer.NumberRangeSummarizer;
import java.util.*;
import java.util.stream.Collectors;


@Component
@Lazy
public class Number implements NumberRangeSummarizer{

    @Override
    public Collection<Integer> collect(String input) {
        // Check for null input
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        /*
        * The TreeSet - Will ensure no duplicates and sort the numbers .
        * TreeSet is basically an implementation of a self-balancing binary search tree like a Red-Black Tree.
        * Therefore, operations like add, remove, and search takes O(log(N)) time.
         * */
        Collection<Integer> collection = new TreeSet<>();
        String[] number = input.split(",");

        // Check for empty input
        if (number.length == 1 && number[0].isEmpty()) {
            throw new IllegalArgumentException("Input must contain at least one number");
        }

        for (final String item : number) { // would have been a great opportunity to use Java streams here
            try {
                // add the number to the collection
                collection.add(Integer.parseInt(item.trim()));
             // Check for invalid input
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(item + " is not a valid integer");
            }
        }

        // Start By Filtering and get those items and make them numeric

        Collection<Integer> numbers = Arrays.stream(number)
                .map(String::trim)
                .filter(num-> num.chars().allMatch(Character::isDigit))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        numbers.forEach(System.out::println);


        // return a list, because my test use ArrayList, I rather change this one-line than change the test
        return new ArrayList<>(collection);
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if(input.isEmpty())
            return "";
        // Collection doesn't have a get(index), so I used the iterator, with equivalent pointer-iterator
        Iterator<Integer>  iterator = input.iterator();
        List<List<Integer>> groups = new ArrayList<>(); // holding lists
        List<Integer> currentGroup = new ArrayList<>();// group numbers, sequential number will size-of-this-list > 1

        Integer prev = null ;

        while(iterator.hasNext()){
            Integer item = iterator.next();
            if(prev!= null && item.equals(prev + 1)){ // used equals(Not == ) Integer is an Object .
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
        if(!currentGroup.isEmpty()) // add the last group
            groups.add(currentGroup);

        ArrayList<String> myList = new ArrayList<>();

        groups.forEach((list)->{ // for-each list get lower and value

            int size = list.size();

            if(size == 1)
                myList.add(String.valueOf(list.get(0)));
            else if (size > 1) {
                myList.add(list.get(0)+"-"+list.get(size-1));
            }

        });


        return String.join(",",myList);
    }
}
