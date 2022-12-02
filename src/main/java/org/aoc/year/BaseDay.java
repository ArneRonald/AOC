package org.aoc.year;

import org.aoc.util.InputRetriever;

public abstract class BaseDay {

    public BaseDay(int year, int day){
        retriever = new InputRetriever(year, day);
    }

    public InputRetriever retriever;

    protected abstract void solve();
}
