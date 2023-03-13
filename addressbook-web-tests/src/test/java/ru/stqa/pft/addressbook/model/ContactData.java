package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String name;
  private final String id;
  private final String middlename;
  private final String lastname;
  private final String nickname;



  private final String group;

  public ContactData(String id, String name, String middlename, String lastname, String nickname, String group) {
    this.id = id;
    this.name = name;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.group=group;
  }
  public ContactData(String name, String middlename, String lastname, String nickname, String group) {
    this.id = null;
    this.name = name;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.group = group;
  }

  public String getId() {
    return id;
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

  public String getGroup(){return group;}

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (!Objects.equals(id, that.id)) return false;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
