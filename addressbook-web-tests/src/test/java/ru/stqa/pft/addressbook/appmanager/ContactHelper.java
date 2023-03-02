package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ContactHelper {
  private WebDriver wd;

  public ContactHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void submitContactCreation() {
    wd.findElement(By.cssSelector("input[name='submit']")).click();
  }

  public void fillContactForm(ContactData contactData) {
    wd.findElement(By.cssSelector("input[name='firstname']")).clear();
    wd.findElement(By.cssSelector("input[name='firstname']")).sendKeys(contactData.getName());
    wd.findElement(By.cssSelector("input[name='middlename']")).clear();
    wd.findElement(By.cssSelector("input[name='middlename']")).sendKeys(contactData.getMiddlename());
    wd.findElement(By.cssSelector("input[name='lastname']")).clear();
    wd.findElement(By.cssSelector("input[name='lastname']")).sendKeys(contactData.getLastname());
    wd.findElement(By.cssSelector("input[name='nickname']")).clear();
    wd.findElement(By.cssSelector("input[name='nickname']")).sendKeys(contactData.getNickname());
  }

  public void initContactCreation() {
    wd.findElement(By.cssSelector("a[href='edit.php']")).click();
  }

  public void selectContact() {
    wd.findElement(By.cssSelector("input[name='selected[]']")).click();
  }

  public void deleteContact() {
    wd.findElement(By.cssSelector("input[value='Delete']")).click();
    wd.switchTo().alert().accept();

  }
}
