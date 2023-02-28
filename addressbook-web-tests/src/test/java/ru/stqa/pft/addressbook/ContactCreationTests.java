package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactCreationTests {
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
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactData("Ivan", "Ivanovich", "Ivanov", "Pusworm"));
    submitContactCreation();
    //wd.findElement(By.cssSelector("img[title='Addressbook']")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.cssSelector("input[name='submit']")).click();
  }

  private void fillContactForm(ContactData contactData) {
    wd.findElement(By.cssSelector("input[name='firstname']")).clear();
    wd.findElement(By.cssSelector("input[name='firstname']")).sendKeys(contactData.getName());
    wd.findElement(By.cssSelector("input[name='middlename']")).clear();
    wd.findElement(By.cssSelector("input[name='middlename']")).sendKeys(contactData.getMiddlename());
    wd.findElement(By.cssSelector("input[name='lastname']")).clear();
    wd.findElement(By.cssSelector("input[name='lastname']")).sendKeys(contactData.getLastname());
    wd.findElement(By.cssSelector("input[name='nickname']")).clear();
    wd.findElement(By.cssSelector("input[name='nickname']")).sendKeys(contactData.getNickname());
  }

  private void initContactCreation() {
    wd.findElement(By.cssSelector("a[href='edit.php']")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }
}
