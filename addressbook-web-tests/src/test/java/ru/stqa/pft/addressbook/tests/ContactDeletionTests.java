package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion(){
    selectContact();
    deleteContact();
  }

  private void selectContact(){
    wd.findElement(By.cssSelector("input[name='selected[]']")).click();
  }
  private void deleteContact(){
    wd.findElement(By.cssSelector("input[value='Delete']")).click();
    wd.findElement(By.cssSelector("input[value='Delete']")).sendKeys(Keys.ENTER);
  }

}
