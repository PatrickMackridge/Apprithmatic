package com.example.apprithmetic;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class userInterfaceTests {
    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void correctUserInput() {
        onView(withId(R.id.userInput)).perform((typeText("20")), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.displayResult)).check(matches(withText("Correct!")));
    }

    @Test
    public void incorrectUserInput() {
        onView(withId(R.id.userInput)).perform((typeText("15")), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.displayResult)).check(matches(withText("Incorrect!")));
    }
}