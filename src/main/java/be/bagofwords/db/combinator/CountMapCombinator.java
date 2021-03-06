package be.bagofwords.db.combinator;

import be.bagofwords.counts.Counter;

import java.util.Map;

public class CountMapCombinator<T> implements Combinator<Counter<T>> {


    public CountMapCombinator() {
    }

    @Override
    public Counter<T> combine(Counter<T> first, Counter<T> second) {
        Counter<T> firstCloned = first.clone();
        for (Map.Entry<T, Long> entry : second.entrySet()) {
            firstCloned.inc(entry.getKey(), entry.getValue());
        }
        return firstCloned;
    }
}
