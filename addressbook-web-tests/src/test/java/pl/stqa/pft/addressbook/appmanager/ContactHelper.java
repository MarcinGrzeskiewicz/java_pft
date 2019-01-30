package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.OtherContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super (wd);
  }

  public void createContact() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactform(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());


  }

  public void initNewContact() {
    click(By.linkText("add new"));
  }

  public void fillOtherContactForm(OtherContactData OtherContactData) {
    type(By.name("address"), OtherContactData.getAddress());
    type(By.name("mobile"), OtherContactData.getMobile());
    type(By.name("email"), OtherContactData.getMail());

  }
}
