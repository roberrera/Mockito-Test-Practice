package com.teamtreehouse.testingbase;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Rob on 11/21/16.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityTest {

  MainActivity activity;

  @Before
  public void setup() {
    // Instantiate MainActivity
    activity = Robolectric.setupActivity(MainActivity.class);
  }

  @Test
  public void editTextUpdatesTextView() throws Exception {
    // Arrange
    String givenString = "test123";
    activity.editText.setText(givenString);

    // Act
    activity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

    //Assert
    String actualString = activity.textView.getText().toString();
    assertEquals(givenString, actualString);
  }

  @Test
  public void spinnerUpdatesBackgroundColor() throws Exception  {
    // Arrange
    int index = 2;
    int givenColor = Color.GREEN;

    // Act
    activity.colorSpinner.setSelection(index);

    // Assert
    // Get the background color of the linear layout's background color
    int actualColor = ((ColorDrawable)activity.linearLayout.getBackground()).getColor();
    assertEquals(givenColor, actualColor);
  }

  @Test
  public void buttonLaunchesOtherActivity() throws Exception {
    // Arrange
    Class clazz = OtherActivity.class;
    Intent expectedIntent = new Intent(activity, clazz);

    // Act
    // Test clicking the button
    activity.launchActivityButton.callOnClick();

    // Assert
    // Check that the correct intent is called, via a shadow class
    ShadowActivity shadowActivity = Shadows.shadowOf(activity);
    Intent actualIntent = shadowActivity.getNextStartedActivity();
    assertTrue(expectedIntent.filterEquals(actualIntent));
  }

}
