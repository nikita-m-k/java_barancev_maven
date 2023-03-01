package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupDeletionTest {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    logIn("admin", "secret");
  }

  private void logIn(String username, String password) throws InterruptedException {
    wd.get("http://localhost/addressbook/");
    Thread.sleep(1000);
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.cssSelector("input[type='submit']")).click();
  }

  @Test
  public void testGroupDeletion() {
    goToGroupPage();
    selectGroup();
    initGroupDeletion();
    goToGroupPage();
  }

  private void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  private void selectGroup() {
    wd.findElement(By.cssSelector("input[name='selected[]']")).click();
  }

  private void initGroupDeletion() {
    wd.findElement(By.cssSelector("input[name='delete']")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }
}
