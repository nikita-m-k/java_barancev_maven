package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "Pusworm", "test1"), true);
    }
  }

  @Test
  public void testContactDeletion() {
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteContact();
  }

}
