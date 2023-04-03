package sphe.solution.grouping;

import org.springframework.stereotype.Component;
import sphe.solution.grouping.numberrangesummarizer.NumberRangeSummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.PatternSyntaxException;

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
        return null;
    }
}
