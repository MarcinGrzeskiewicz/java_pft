package pl.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String nickname;
  private final String address;
  private final String mobile;
  private final String mail;
  private String group;

  public ContactData(String name, String lastname, String nickname, String address, String mobile, String mail, String group) {
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

  public String getGroup() { return group; }
}
