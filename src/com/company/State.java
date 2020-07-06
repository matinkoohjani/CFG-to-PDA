package com.company;

public class State {
    String name;
    boolean isInitial, isFinal;

    public State(String name, boolean isInitial, boolean isFinal) {
        this.name = name;
        this.isInitial = isInitial;
        this.isFinal = isFinal;
    }
}
