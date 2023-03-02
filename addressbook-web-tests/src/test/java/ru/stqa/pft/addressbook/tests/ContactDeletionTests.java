package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import java.awt.*;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
  }

}
