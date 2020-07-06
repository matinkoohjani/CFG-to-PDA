package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PushDownAutomata {
    ArrayList<Transition> transitions = new ArrayList<>();
    State Q0 = new State("Q0", true, false);
    State Q1 = new State("Q1", false, false);
    State Q2 = new State("Q2", false, true);
    boolean isAccepted = false;

    public PushDownAutomata(){
        transitions.add(new Transition(Q0, "λ", "z", Q1, "Sz"));
        transitions.add(new Transition(Q1, "λ", "z", Q2, "z"));
    }

    public void setTransitions(String fileAddress){
        try{
            File grammarFile = new File(fileAddress);
            Scanner scanner = new Scanner(grammarFile);

            while (scanner.hasNext()){
                String temp = scanner.next();
                String currentStackTop = temp.substring(0,1);
                int lastIndex = 0, secondLastIndex=3;

                while (lastIndex != -1) {
                    lastIndex = temp.indexOf("|", lastIndex);
                    if (lastIndex != -1) {
                        String input = temp.substring(secondLastIndex,secondLastIndex+1);
                        String nextStackTop = temp.substring(secondLastIndex+1, lastIndex);
                        transitions.add(new Transition(Q1, input, currentStackTop, Q1, nextStackTop));
                        secondLastIndex = ++lastIndex;
                    }
                }
                String input = temp.substring(secondLastIndex,secondLastIndex+1);
                String nextStackTop = temp.substring(secondLastIndex+1);
                transitions.add(new Transition(Q1, input, currentStackTop, Q1, nextStackTop));
            }

            for( Transition transition : transitions)
                System.out.println(transition);
        }
        catch (Exception e){ e.printStackTrace(); }
    }

    public void find(String currentState, String input, String stack){
        if(currentState.equals("Q0"))
            find("Q1", input, "Sz");
        else if(currentState.equals("Q1")){
            if(input.length()==0 && stack.equals("z")){
                isAccepted = true;
                return;
            }
            String currentInput = input.substring(0,1);
            String currentStack = stack.substring(0,1);
            for(Transition transition : transitions){
                if(transition.input.equals(currentInput) && transition.currentStackTop.substring(0,1).equals(currentStack)){
                    if(transition.nextStackTop.equals("λ"))
                        find(transition.nextState.name, input.substring(1), stack.substring(1));
                    else
                        find(transition.nextState.name, input.substring(1), transition.nextStackTop + stack.substring(1));
                }
            }



        }
    }
}
