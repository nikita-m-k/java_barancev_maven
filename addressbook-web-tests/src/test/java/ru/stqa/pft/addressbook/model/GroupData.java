package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  private final String name;
  private final String id;
  private final String header;
  private final String footer;

  public GroupData(String id, String name, String header, String footer) {
    this.id=id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }
  public GroupData(String name, String header, String footer) {
    this.id=null;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (!Objects.equals(name, groupData.name)) return false;
    return Objects.equals(id, groupData.id);
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

}
