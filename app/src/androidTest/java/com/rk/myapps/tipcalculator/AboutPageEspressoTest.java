package com.rk.myapps.tipcalculator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by rkakadia on 8/22/2016.
 */

@RunWith(AndroidJUnit4.class)
public class AboutPageEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void openAndTestAboutPage() {
        sleep(5);
        onView(withContentDescription("More options")).perform(click());
        sleep(1);
        onView(withText("About")).perform(click());
        sleep(2);
        //Check about screen
        onView(withId(R.id.about_app_header))
                .check(matches(withText(containsString("Calculator"))));
    }

    private static int getResourceId(String s) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        String packageName = targetContext.getPackageName();
        return targetContext.getResources().getIdentifier(s, "id", packageName);
    }

    public void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
