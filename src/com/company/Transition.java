package com.company;

public class Transition {
    State currentState, nextState;
    String input, currentStackTop, nextStackTop;

    public Transition(State currentState, String input, String currentStackTop, State nextState, String nextStackTop) {
        this.currentState = currentState;
        this.nextState = nextState;
        this.input = input;
        this.currentStackTop = currentStackTop;
        this.nextStackTop = nextStackTop.length()==0 ? "λ" : nextStackTop;
    }

    @Override
    public String toString() {
        return "(" + currentState.name + ", " + input + ", " + currentStackTop + ") = (" + nextState.name + ", " + nextStackTop + ")" ;
    }
}
