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
}