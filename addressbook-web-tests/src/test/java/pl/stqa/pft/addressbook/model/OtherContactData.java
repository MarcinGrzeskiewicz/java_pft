package pl.stqa.pft.addressbook.model;

public class OtherContactData {
  private final String address;
  private final String mobile;
  private final String mail;

  public OtherContactData(String address, String mobile, String mail) {
    this.address = address;
    this.mobile = mobile;
    this.mail = mail;
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
