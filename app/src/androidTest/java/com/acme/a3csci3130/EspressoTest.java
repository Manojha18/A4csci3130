package com.acme.a3csci3130;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by Manojha on 2018-03-15.
 */

public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void create() {

        /** Creating a new user
         *
         */

        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("Aruna"));
        onView(withId(R.id.email)).perform(typeText("aruna@gmail.com"));
        onView(withId(R.id.business_num)).perform(typeText("1234"));
        onView(withId(R.id.prim_business)).perform(typeText("Fisher"));
        onView(withId(R.id.address)).perform(typeText("1333 south park street"));
        onView(withId(R.id.province)).perform(typeText("NS"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());

    }

    @Test
    public void read() {

        // choosing a position to perform//
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        // Checking whether the existing details  matches the given string values//

        onView(withId(R.id.name)).check(matches(withText("manojhaP")));
        onView(withId(R.id.email)).check(matches(withText("manojha@gmail.com")));
        onView(withId(R.id.business_num)).check(matches(withText("1234")));
        onView(withId(R.id.prim_business)).check(matches(withText("Distributor")));
        onView(withId(R.id.address)).check(matches(withText("102, queen Street")));
        onView(withId(R.id.province)).check(matches(withText("NS")));

    }

    @Test
    public void update() {
        onData(anything())
                .inAdapterView(allOf(withId(R.id.listView), isCompletelyDisplayed()))
                .atPosition(0).perform(click());

        //Replacing the primary business for user manojha at position(0) in the array list//

        onView(withId(R.id.prim_business)).perform(replaceText("Fisher"),closeSoftKeyboard());

        onView(withId(R.id.updateButton)).perform(click());

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).check(matches(withText("manojhaP")));


    }

    @Test

    public void delete() {

        /**Deleting a user from  the array list at position (2)
         *
         *
         */

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(2).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());

    }
}
