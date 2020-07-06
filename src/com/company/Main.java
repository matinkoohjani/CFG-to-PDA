package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PushDownAutomata pda = new PushDownAutomata();
        pda.setTransitions("a.txt");
        pda.find("Q0", "aqppcp", "z");
        System.out.println(pda.isAccepted);
//        String grammar = "S->aSPCP|aSPP|q\n" + "C->c\n" + "P->p\n";
//        Scanner scanner = new Scanner(grammar);

//        while (scanner.hasNext()){
//            String temp = scanner.next();
//            String currentStackTop = temp.substring(0,1);
//            int lastIndex = 0, secondLastIndex=3;
//
//            while (lastIndex != -1) {
//                lastIndex = temp.indexOf("|", lastIndex);
//                if (lastIndex != -1) {
//                    String input = temp.substring(secondLastIndex,secondLastIndex+1);
//                    String nextStackTop = temp.substring(secondLastIndex+1, lastIndex);
//                    transitions.add(new Transition(Q1, input, currentStackTop, Q1, nextStackTop));
//                    secondLastIndex = ++lastIndex;
//                }
//            }
//            String input = temp.substring(secondLastIndex,secondLastIndex+1);
//            String nextStackTop = temp.substring(secondLastIndex+1);
//            transitions.add(new Transition(Q1, input, currentStackTop, Q1, nextStackTop));
//        }
//
//        for( Transition transition : transitions)
//            System.out.println(transition);
    }
}
