package ru.stqa.pft.addressbook;

public class ContactData {
  private final String name;
  private final String middlename;
  private final String lastname;
  private final String nickname;

  public ContactData(String name, String middlename, String lastname, String nickname) {
    this.name = name;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
  }

  public String getName() {
    return name;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }
}
