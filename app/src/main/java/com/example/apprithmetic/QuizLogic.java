package com.example.apprithmetic;

public class QuizLogic {
    String equation;
    int solution;

    public void generateEquation() {
        long num1 = Math.round(Math.random() * 100);
        long num2 = Math.round(Math.random() * 100);
        String[] operators = {"+", "-"};
        String operator = operators[ (int) Math.round(Math.random())];
        equation = String.format("%s %s %s", num1, operator, num2);
    }

    public String getEquation() {
        return equation;
    }

    public int getSolution() {
        return solution;
    }
}
