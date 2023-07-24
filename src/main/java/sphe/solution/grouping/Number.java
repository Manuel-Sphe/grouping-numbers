package sphe.solution.grouping;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import sphe.solution.grouping.numberrangesummarizer.NumberRangeSummarizer;
import java.util.*;


@Component
@Lazy
public class Number implements NumberRangeSummarizer  {

    /**
     * Collects the input
     * @param input string
     * @return a Collection of Distinct Integers
     */
    @Override
    public Collection<Integer> collect(String input) {
        // Check for null input

        Optional<String> stringOptional = Optional.ofNullable(input);



        String stringValue = stringOptional.orElseThrow(()-> new NullPointerException("Input cannot be null"));

        if (stringValue.trim().isEmpty()) {
                throw new IllegalArgumentException("Input cannot be Empty");
        }

        var number = input.split(",");

        // Check for empty input

        List<Integer> numbersList = Arrays.stream(number)
                .map(String::trim)
                .filter(num -> num.chars().allMatch(Character::isDigit))
                .map(Integer::parseInt)
                .sorted().distinct().toList();

        if (numbersList.isEmpty()) {
            throw new IllegalArgumentException("Input must contain at least number");
        }

        return numbersList ;
    }



    /**
     * get the summarized string
     * @param input a Collection
     * @return a String
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {

        if(Objects.isNull(input))
            return null;

        if(input.isEmpty() ) {
            return null;
        }



        // Collection doesn't have a get(index), so I used the iterator, with equivalent pointer-iterator
        Iterator<Integer>  iterator = input.iterator();
        List<List<Integer>> groups = new ArrayList<>(); // holding lists
        List<Integer> currentGroup = new ArrayList<>();// group numbers, sequential number will size-of-this-list > 1

        Integer prev = null ;

        while(iterator.hasNext()){
            Integer item = iterator.next();
            if(Objects.nonNull(prev) && item.equals(prev + 1)){
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

        groups.forEach( list -> { // for-each list get lower and value

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
