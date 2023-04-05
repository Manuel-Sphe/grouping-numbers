package sphe.solution.grouping;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import sphe.solution.grouping.numberrangesummarizer.NumberRangeSummarizer;
import java.util.*;


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
                collection.add(Integer.parseInt(item.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(item + " is not a valid integer");
            }
        }

        // return a list, because my test use ArrayList, I rather change this one-line
        return new ArrayList<>(collection);
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
            /*
            Strange way to remove duplicates.. Isn't there an appropriate data structure you can use for this? Also makes me wonder if this method
            should concern itself with validating or checking input. Seems to me this would have been better done in the collect method. While collecting 
            input, ensure validaty of input, remove duplicates, Sort input? eg, 5,4,3,2,1... is this a valid group? Not accorind to this code. But we know 
            you are not guaranteed to get sorted input from a user.
            */
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


        return String.join(",",myList);
    }
}
