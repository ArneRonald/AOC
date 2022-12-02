package org.aoc.year;

import org.aoc.util.InputRetriever;

public abstract class BaseDay {

    public BaseDay(InputRetriever inputRetriever){
        retriever = inputRetriever;
    }

    public InputRetriever retriever;

    protected abstract void solve();
}
