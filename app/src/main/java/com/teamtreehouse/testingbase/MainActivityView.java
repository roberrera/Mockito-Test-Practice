package com.teamtreehouse.testingbase;

/**
 * Created by Rob on 11/22/16.
 */

public interface MainActivityView {
  void changeTextViewText(String text);
  void changeBackgroundColor(int color);
  void launchOtherActivity(Class activity);
}
