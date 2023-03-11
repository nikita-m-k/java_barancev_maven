package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "Pusworm", "test1"), true);
    }
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteContact();
  }

}
