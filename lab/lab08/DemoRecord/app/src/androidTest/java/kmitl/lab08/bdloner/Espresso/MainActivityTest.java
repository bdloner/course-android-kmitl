package kmitl.lab08.bdloner.Espresso;


import android.os.SystemClock;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.project.demorecord.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    @Test
    public void TestCase1() {

        onView(ViewMatchers.withId(R.id.editTExtName)).perform(replaceText(""), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(withId(R.id.editTextAge)).perform(replaceText(""), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(1000);
        onView(withText("Please Enter user info")).check(matches(isDisplayed()));
        SystemClock.sleep(1000);
    }
    @Test
    public void TestCase2() {

        onView(withId(R.id.editTExtName)).perform(replaceText(""), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(1000);
        onView(withText("Please Enter user info")).check(matches(isDisplayed()));
        SystemClock.sleep(1000);
    }

    @Test
    public void TestCase3() {

        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(1000);
        onView(withText("Not Found")).check(matches(isDisplayed()));
        SystemClock.sleep(1000);
    }

    @Test
    public void TestCase4() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(withId(R.id.editTextAge)).perform(replaceText(""), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(1000);
        onView(withText("Please Enter user info")).check(matches(isDisplayed()));
        SystemClock.sleep(1000);
    }

    @Test
    public void TestCase5() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(1000);
        onView(withRecyclerView(R.id.list).atPositionOnView(0, R.id.textName)).check(matches(withText("Ying")));
        SystemClock.sleep(1000);
        onView(withRecyclerView(R.id.list).atPositionOnView(0, R.id.textAge)).check(matches(withText("20")));
        SystemClock.sleep(1000);
    }

    @Test
    public void TestCase6() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ladarat"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(1000);
        onView(withRecyclerView(R.id.list).atPositionOnView(1, R.id.textName)).check(matches(withText("Ladarat")));
        SystemClock.sleep(1000);
        onView(withRecyclerView(R.id.list).atPositionOnView(1, R.id.textAge)).check(matches(withText("20")));
        SystemClock.sleep(1000);
    }

    @Test
    public void TestCase7() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Somkait"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(withId(R.id.editTextAge)).perform(replaceText("80"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(1000);
        onView(withRecyclerView(R.id.list).atPositionOnView(2, R.id.textName)).check(matches(withText("Somkait")));
        SystemClock.sleep(1000);
        onView(withRecyclerView(R.id.list).atPositionOnView(2, R.id.textAge)).check(matches(withText("80")));
        SystemClock.sleep(1000);
    }

    @Test
    public void TestCase8() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Prayoch"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(withId(R.id.editTextAge)).perform(replaceText("60"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(1000);
        onView(withRecyclerView(R.id.list).atPositionOnView(3, R.id.textName)).check(matches(withText("Prayoch")));
        SystemClock.sleep(1000);
        onView(withRecyclerView(R.id.list).atPositionOnView(3, R.id.textAge)).check(matches(withText("60")));
        SystemClock.sleep(1000);
    }

    @Test
    public void TestCase9() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Prayoch"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(withId(R.id.editTextAge)).perform(replaceText("50"), closeSoftKeyboard());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(1000);
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(1000);
        onView(withRecyclerView(R.id.list).atPositionOnView(4, R.id.textName)).check(matches(withText("Prayoch")));
        SystemClock.sleep(1000);
        onView(withRecyclerView(R.id.list).atPositionOnView(4, R.id.textAge)).check(matches(withText("50")));
        SystemClock.sleep(1000);
    }
}
