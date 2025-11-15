package edu.pnu.badcalc;

public class Calculator {
    public double last;

    public double add(double a, double b) {
        last = a + b;
        return last;
    }

    public double subtract(double a, double b) {
        last = a - b;
        return last;
    }

    public double multiply(double a, double b) {
        last = a * b;
        return last;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        last = a / b;
        return last;
    }

    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative factorial not defined");
        long r = 1;
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        last = r;
        return r;
    }

    public double parseAndCompute(String expr) {
        String[] tokens = expr.split(" ");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Expression must be in format: <number> <operator> <number>");
        }

        double a = Double.parseDouble(tokens[0]);
        String op = tokens[1];
        double b = Double.parseDouble(tokens[2]);

        return switch (op) {
            case "+" -> add(a, b);
            case "-" -> subtract(a, b);
            case "*" -> multiply(a, b);
            case "/" -> divide(a, b);
            default -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
    }
}
