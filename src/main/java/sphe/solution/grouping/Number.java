package sphe.solution.grouping;

import org.springframework.stereotype.Component;
import sphe.solution.grouping.numberrangesummarizer.NumberRangeSummarizer;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class Number implements NumberRangeSummarizer{

    @Override
    public Collection<Integer> collect(String input){
        return null;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        return null;
    }
}
