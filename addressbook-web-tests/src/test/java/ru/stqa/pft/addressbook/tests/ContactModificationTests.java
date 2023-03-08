package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification(){
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Sergey", "Sergeev","Sergov", "serg", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactPage();

  }
}
