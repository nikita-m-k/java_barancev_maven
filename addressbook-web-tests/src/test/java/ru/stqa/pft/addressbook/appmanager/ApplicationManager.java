package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  private ContactHelper contactHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private Browser browser;

  public ApplicationManager(Browser browser) {
    this.browser=browser;
  }

  public void init() throws InterruptedException {
    if (browser == Browser.FIREFOX){
      wd = new FirefoxDriver();
    } else if (browser == Browser.CHROME){
      wd = new ChromeDriver();
    } else if (browser == Browser.EDGE){
      wd = new EdgeDriver();
    }
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    Thread.sleep(1000);
    contactHelper = new ContactHelper(wd);
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.logIn("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
