package pl.stqa.pft.addressbook;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String nickname;


  public ContactData(String name, String lastname, String nickname) {
    this.name = name;
    this.lastname = lastname;
    this.nickname = nickname;

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

}
