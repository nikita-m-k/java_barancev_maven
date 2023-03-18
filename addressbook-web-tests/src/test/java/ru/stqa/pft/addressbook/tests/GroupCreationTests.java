package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    app.group().create(new GroupData("test1", "test2", "test3"));
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
