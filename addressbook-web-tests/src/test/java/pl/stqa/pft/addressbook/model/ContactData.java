package pl.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String name;
  private final String lastname;
  private final String nickname;
  private final String address;
  private final String mobile;
  private final String mail;
  private String group;

  public int getId() {
    return id;
  }



  public ContactData(String name, String lastname, String nickname, String address, String mobile, String mail, String group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.mobile = mobile;
    this.mail = mail;
    this.group = group;
  }
  public ContactData(int id, String name, String lastname, String nickname, String address, String mobile, String mail, String group) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.mobile = mobile;
    this.mail = mail;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }

  public String getMail() {
    return mail;
  }

  public String getGroup() {
    return group;
  }


  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastname);
  }

}
