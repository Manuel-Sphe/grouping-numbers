package sphe.solution.grouping;

import java.util.Collection;

public interface Genirc<T extends Comparable<T> > {

    Collection<T> collect(String input);

    String summarizeCollection(Collection<T> input);
}
