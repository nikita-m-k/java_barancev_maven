package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.cssSelector("input[name='firstname']"), contactData.getName());
    type(By.cssSelector("input[name='middlename']"), contactData.getMiddlename());
    type(By.cssSelector("input[name='lastname']"), contactData.getLastname());
    type(By.cssSelector("input[name='nickname']"), contactData.getNickname());

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.cssSelector("a[href='edit.php']"));
  }

  public void selectContact(int index) {
    wd.findElements(By.cssSelector("td [name='selected[]']")).get(index).click();
  }

  public void deleteContact() {
    click(By.cssSelector("input[value='Delete']"));
    wd.switchTo().alert().accept();

  }

  public void initContactModification() {
    click(By.cssSelector("img[title='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnToContactPage() {
    click(By.cssSelector("img[title='Addressbook']"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contactData, boolean b) {
    initContactCreation();
    fillContactForm(contactData, b);
    submitContactCreation();
    returnToContactPage();
  }
  public void modifyContact(int index, ContactData contact) {
    selectContact(index);
    initContactModification();
    fillContactForm(contact, false);
    submitContactModification();
    returnToContactPage();
  }

  public int getContactCount() {
    return wd.findElements(By.cssSelector("td [name='selected[]']")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contact = new ArrayList<>();
    List<WebElement> contacts = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : contacts){
      String name = element.getText();
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      ContactData conct = new ContactData(id, name, null, null, null, null);
      contact.add(conct);
    }
    return contact;
  }
}
