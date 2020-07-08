package com.example.apprithmetic;

public class EquationGenerator {
    String equation;
    int solution;

    public void generateEquation() {
        equation = "10 + 10";
        solution = 20;
    }

    public String getEquation() {
        return equation;
    }

    public int getSolution() {
        return solution;
    }
}
