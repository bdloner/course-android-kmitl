package kmitl.lab08.bdloner.Espresso;


import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.base.Default;
import android.support.test.espresso.core.deps.guava.annotations.Beta;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.project.demorecord.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

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

    @Before
    public void start() {
        Context context = InstrumentationRegistry.getTargetContext();

        File root = InstrumentationRegistry.getTargetContext().getFilesDir().getParentFile();
        String[] sharedPreferencesFileNames = new File(root, "shared_prefs").list();
        for (String fileName : sharedPreferencesFileNames) {
            InstrumentationRegistry.getTargetContext().getSharedPreferences(fileName.replace(".xml", ""), Context.MODE_PRIVATE).edit().clear().commit();
        }

        mActivityTestRule.launchActivity(new Intent());

    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }


    @Test
    public void TestCase1() {

        onView(withId(R.id.editTExtName)).perform(replaceText(""), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText(""), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);
        onView(withText("Please Enter user info")).check(matches(isDisplayed()));
        SystemClock.sleep(500);
    }

    @Test
    public void TestCase2() {

        onView(withId(R.id.editTExtName)).perform(replaceText(""), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);
        onView(withText("Please Enter user info")).check(matches(isDisplayed()));
        SystemClock.sleep(500);
    }

    @Test
    public void TestCase3() {

        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(500);
        onView(withText("Not Found")).check(matches(isDisplayed()));
        SystemClock.sleep(500);
    }

    @Test
    public void TestCase4() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText(""), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);
        onView(withText("Please Enter user info")).check(matches(isDisplayed()));
        SystemClock.sleep(500);
    }

    @Test
    public void TestCase5() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);
        // click "GO TO LIST" button and check test condition
        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(500);
        onView(withRecyclerView(R.id.list).atPositionOnView(0, R.id.textName)).check(matches(withText("Ying")));
        SystemClock.sleep(500);
        onView(withRecyclerView(R.id.list).atPositionOnView(0, R.id.textAge)).check(matches(withText("20")));
        SystemClock.sleep(500);
    }

    @Test
    public void TestCase6() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);

        onView(withId(R.id.editTExtName)).perform(replaceText("Ladarat"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);

        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(500);
        onView(withRecyclerView(R.id.list).atPositionOnView(1, R.id.textName)).check(matches(withText("Ladarat")));
        SystemClock.sleep(500);
        onView(withRecyclerView(R.id.list).atPositionOnView(1, R.id.textAge)).check(matches(withText("20")));
        SystemClock.sleep(500);
    }

    @Test
    public void TestCase7() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);

        onView(withId(R.id.editTExtName)).perform(replaceText("Ladarat"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);

        onView(withId(R.id.editTExtName)).perform(replaceText("Somkait"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("80"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());

        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(500);
        onView(withRecyclerView(R.id.list).atPositionOnView(2, R.id.textName)).check(matches(withText("Somkait")));
        SystemClock.sleep(500);
        onView(withRecyclerView(R.id.list).atPositionOnView(2, R.id.textAge)).check(matches(withText("80")));
        SystemClock.sleep(500);
    }

    @Test
    public void TestCase8() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);

        onView(withId(R.id.editTExtName)).perform(replaceText("Ladarat"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);

        onView(withId(R.id.editTExtName)).perform(replaceText("Somkait"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("80"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());

        onView(withId(R.id.editTExtName)).perform(replaceText("Prayoch"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("60"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);

        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(500);
        onView(withRecyclerView(R.id.list).atPositionOnView(3, R.id.textName)).check(matches(withText("Prayoch")));
        SystemClock.sleep(500);
        onView(withRecyclerView(R.id.list).atPositionOnView(3, R.id.textAge)).check(matches(withText("60")));
        SystemClock.sleep(500);
    }

    @Test
    public void TestCase9() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);

        onView(withId(R.id.editTExtName)).perform(replaceText("Ladarat"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);

        onView(withId(R.id.editTExtName)).perform(replaceText("Somkait"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("80"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());

        onView(withId(R.id.editTExtName)).perform(replaceText("Prayoch"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("60"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);

        onView(withId(R.id.editTExtName)).perform(replaceText("Prayoch"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(withId(R.id.editTextAge)).perform(replaceText("50"), closeSoftKeyboard());
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.buttonAdded), withText("ADDED"))).perform(click());
        SystemClock.sleep(500);

        onView(allOf(withId(R.id.buttonGotoList), withText("GO TO LIST"))).perform(click());
        SystemClock.sleep(500);
        onView(withRecyclerView(R.id.list).atPositionOnView(4, R.id.textName)).check(matches(withText("Prayoch")));
        SystemClock.sleep(500);
        onView(withRecyclerView(R.id.list).atPositionOnView(4, R.id.textAge)).check(matches(withText("50")));
        SystemClock.sleep(500);
    }
}
