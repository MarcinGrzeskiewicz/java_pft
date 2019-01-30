package pl.stqa.pft.addressbook;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String nickname;
  private final String address;
  private final String mobile;
  private final String mail;

  public ContactData(String name, String lastname, String nickname, String address, String mobile, String mail) {
    this.name = name;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.mobile = mobile;
    this.mail = mail;
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
}
