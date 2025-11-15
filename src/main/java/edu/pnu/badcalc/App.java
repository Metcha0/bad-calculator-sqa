package edu.pnu.badcalc;

import java.util.Scanner;

public class App {
    public static Calculator c = new Calculator();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Calculator v1.0");
        while (true) {
            System.out.print("> ");
            String line = s.nextLine().trim();
            if (line.equalsIgnoreCase("quit")) break;
            if (line.isEmpty()) continue;
            try {
                System.out.println("= " + c.parseAndCompute(line));
            } catch (Exception e) {
                System.out.println("Error: invalid input or operation.");
            }
        }
    }
}
