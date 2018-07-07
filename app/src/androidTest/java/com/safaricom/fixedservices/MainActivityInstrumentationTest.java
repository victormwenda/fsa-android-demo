package com.safaricom.fixedservices;

import android.support.annotation.UiThread;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.regex.Matcher;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

/**
 * MainActivityInstrumentationTest
 * For running android specific instrumentation tests
 * Created by Victor Rwanda <vrwanda@safaricom.co.ke> on 3/13/18.
 */

public class MainActivityInstrumentationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    protected MainActivity mActivity;
    protected EditText etUsername;
    protected EditText etPassword;
    protected Button btLogin;

    public MainActivityInstrumentationTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();

        etUsername = mActivity.findViewById(R.id.username);
        etPassword = mActivity.findViewById(R.id.password);
        btLogin = mActivity.findViewById(R.id.login);
    }

    @UiThread
    public void testSettingViewData() {

        Espresso.onView(ViewMatchers.withId(R.id.username))
                .perform(ViewActions.typeText("vrwanda@safaricom.co.ke"));
        Espresso.onView(ViewMatchers.withId(R.id.password))
                .perform(ViewActions.typeText("$tr0ngP@$$"));
    }

    @UiThread
    public void testCheckingViewData() {

    }

    @Test
    public void testLoginSuccessWithViewData() {
        String username = "vrwanda@safaricom.co.ke";
        String password = "$tr0ngP@$$";
        assertTrue(mActivity.authenticateUser(username, password));
    }

   @UiThread
    public void testResettingViewData() {
       Espresso.onView(ViewMatchers.withId(R.id.username)).perform(ViewActions.clearText());
       Espresso.onView(ViewMatchers.withId(R.id.password)).perform(ViewActions.clearText());
    }

    @UiThread
    public void testLoginFailedWithoutViewData() {
        String username = "vrwanda@safaricom.co.ke";
        String password = "$tr0ngP@$$";
        assertTrue(mActivity.authenticateUser(username, password));
    }
}
