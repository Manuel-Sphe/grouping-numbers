package sphe.solution.grouping;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenericImpl implements Genirc<Character>{


    @Override
    public Collection<Character> collect(String input) {

        Optional<String> stringOptional = Optional.ofNullable(input);

        if(stringOptional.isEmpty()) throw new IllegalArgumentException("Input cannot be Empty/Null");

        var chars = input.split(",");

        /*
         * Check for empty input
         */
        if(chars.length == 1 && chars[0].isEmpty())
            throw new IllegalArgumentException("Input should contain at least one char");


        final boolean a = Character.isLetter('a');


        return null;
    }

    @Override
    public String summarizeCollection(Collection<Character> input) {
        return null;
    }
}
