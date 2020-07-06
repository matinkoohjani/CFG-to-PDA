package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the address of the file which contains grammar in Greibach form: ");
        String fileAddress = scanner.next();
        System.out.println("\n*****************\n");
        PushDownAutomata pda = new PushDownAutomata();
        pda.setTransitions(fileAddress);
        System.out.println("\nTransitions has been recognized\n\n******************\n");

        while (!fileAddress.equals("no")){
            System.out.println("Enter a string to check if it is accepted or not : ");
            String input = scanner.next();
            System.out.println();
            pda.find("Q0", input, "z");
            if(pda.isAccepted)
                System.out.println(input + " is ACCEPTED\n");
            else
                System.out.println(input + " is REJECTED\n");
            pda.isAccepted = false;
            System.out.println("Want to check more strings ? (yes/no)");
            fileAddress = scanner.next();
            System.out.println();
        }

    }
}
