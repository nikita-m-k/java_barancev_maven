package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification(){
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "Pusworm", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Sergey", "Sergeev","Sergov", "serg", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size());
  }
}
