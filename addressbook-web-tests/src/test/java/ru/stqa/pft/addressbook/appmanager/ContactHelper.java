package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.cssSelector("input[name='submit']"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.cssSelector("input[name='firstname']"), contactData.getName());
    type(By.cssSelector("input[name='middlename']"), contactData.getMiddlename());
    type(By.cssSelector("input[name='lastname']"), contactData.getLastname());
    type(By.cssSelector("input[name='nickname']"), contactData.getNickname());
  }

  public void initContactCreation() {
    click(By.cssSelector("a[href='edit.php']"));
  }

  public void selectContact() {
    click(By.cssSelector("input[name='selected[]']"));
  }

  public void deleteContact() {
    click(By.cssSelector("input[value='Delete']"));
    wd.switchTo().alert().accept();

  }
}
