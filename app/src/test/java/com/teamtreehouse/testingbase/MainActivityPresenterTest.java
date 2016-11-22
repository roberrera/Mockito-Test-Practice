package com.teamtreehouse.testingbase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Rob on 11/22/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

  MainActivityPresenter presenter;

  @Mock
  MainActivityView view;

  @Before public void setUp() throws Exception {
    presenter = new MainActivityPresenter(view);
  }

  @Test public void editTextUpdated() throws Exception {
    // Arrange
    String givenString = "test123";

    // Act
    presenter.editTextUpdated(givenString);

    // Assert
    Mockito.verify(view).changeTextViewText(givenString);
  }

  @Test public void colorSelected() throws Exception {

  }

  @Test public void launchOtherActivityButtonClicked() throws Exception {

  }
}