package com.example.apprithmetic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest {

    QuizLogic testQuizzer = new QuizLogic();

    @Test
    public void equation_is_valid() {
        testQuizzer.generateEquation();
        assertTrue(testQuizzer.getEquation().matches("^\\d+\\s[+-]\\s\\d+$"));
    }

    @Test
    public void solution_is_correct() {
        int testSolution;
        testQuizzer.generateEquation();

        String[] equationArray = testQuizzer.getEquation().split(" ");
        int testNum1 = Integer.parseInt(equationArray[0]);
        int testNum2 = Integer.parseInt(equationArray[2]);
        String testOperator = equationArray[1];

        if (testOperator.equals("+")) {
            testSolution = testNum1 + testNum2;
        } else {
            testSolution = testNum1 - testNum2;
        }
        assertEquals(testSolution, testQuizzer.getSolution());
    }
}